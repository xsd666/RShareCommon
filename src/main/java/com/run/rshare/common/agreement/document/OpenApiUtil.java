package com.run.rshare.common.agreement.document;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jayway.jsonpath.DocumentContext;
import com.run.rshare.common.agreement.ServiceRequest;
import com.run.rshare.common.agreement.ServiceResponse;
import com.run.rshare.common.agreement.type.FieldInfo;
import com.run.rshare.common.utils.ReqAndRespUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName OpenApiUtil
 * @Description: 规约工具类
 * @Author xsd
 * @Date 2023/8/23
 * @Version V1.0
 **/
public class OpenApiUtil {

    private static Logger LOG = LoggerFactory.getLogger(OpenApiUtil.class);

    /**
     * 规约excel导入
     *
     * @param file
     * @return
     */
    public static JSONObject importExcelRegFile(File file) {
        JSONObject fileContent = ReqAndRespUtil.externalRegFile(file.getAbsolutePath());
        return fileContent;
    }

    /**
     * 构建规约响应请求体
     *
     * @param openApiJsonSchema
     * @param paramsMap
     * @return
     */
    public static ServiceResponse buildServiceResponse(String openApiJsonSchema, Map<String, Object> paramsMap) {
        OpenApiDocument openApiDocument = JSONObject.parseObject(openApiJsonSchema, OpenApiDocument.class);
        Optional<OpenApiResponse> responseOptional = openApiDocument.fetchOpenApiResponseOptional("200");
        if (!responseOptional.isPresent()) {
            return new ServiceResponse("500", "该服务规约错误");
        }
        //获取响应json
        JSONObject responseJson = openApiDocument.fetchResponseJSON(responseOptional,paramsMap);

        if (responseJson == null) {
            return new ServiceResponse("500", "该服务规约错误");
        }
        ServiceResponse serviceResponse = new ServiceResponse("200", "成功");
        serviceResponse.setResponse(responseJson);
        return serviceResponse;
    }

    /**
     * 构建规约请求体
     *
     * @param openApiJsonSchema
     * @param paramsMap
     * @return
     */
    public static ServiceRequest buildServiceRequest(String openApiJsonSchema, Map<String, Object> paramsMap) {
        OpenApiDocument openApiDocument = JSONObject.parseObject(openApiJsonSchema, OpenApiDocument.class);
        JSONObject paramsMapTemplate = openApiDocument.fetchRequestJSON(new HashMap<>());
        String httpMethod = openApiDocument.fetchHttpMethod();
        ServiceRequest serviceRequest = new ServiceRequest();
        //填充请求头
        JSONObject requestHeader = openApiDocument.fetchRequestHeader(paramsMap);
        HttpHeaders httpHeaders = new HttpHeaders();
        if (MapUtils.isNotEmpty(requestHeader)) {
            requestHeader.forEach((key, val) -> {
                if (val != null) {
                    httpHeaders.add(key, val.toString());
                }
            });
        }
        if (HttpMethod.GET.name().equalsIgnoreCase(httpMethod) && MapUtils.isNotEmpty(paramsMap)) {
            //get请求只取一层
            List<String> params = new ArrayList<>();
            paramsMapTemplate.forEach((key, val) -> {
                val = "";
                if (paramsMap.containsKey(key)) {
                    val = paramsMap.get(key);
                }
                params.add(String.format("%s=%s", key, val));
            });
            serviceRequest.setRequestFormParam(Joiner.on("&").join(params));
        } else {
            //post请求
            DocumentContext context = com.jayway.jsonpath.JsonPath.parse(paramsMapTemplate);
            paramsMap.forEach((key, val) -> {
                String path = "$.." + key;
                context.set(path, val);
            });
            JSONObject params = JSONObject.parseObject(context.jsonString());
            serviceRequest.setRequestJsonParam(params);
        }
        serviceRequest.setHeader(httpHeaders);
        serviceRequest.setHttpMethod(httpMethod);

        return serviceRequest;
    }

    /**
     * 获取响应参数
     *
     * @param openApiJsonSchema 规约json
     * @param responseCode      响应码
     * @param responseJson      响应结果json
     * @return
     */
    public static List<FieldInfo> getResponseFieldInfoByOpenApiJson(String openApiJsonSchema, String responseCode, String responseJson) {
        OpenApiDocument openApiDocument = JSONObject.parseObject(openApiJsonSchema, OpenApiDocument.class);
        Optional<OpenApiResponse> openApiResponse = openApiDocument.fetchOpenApiResponseOptional(responseCode);
        Optional<OpenApiSchema> openApiSchemaOptional = openApiDocument.fetchResponseSchemaOptional(openApiResponse);
        if (!openApiSchemaOptional.isPresent()) {
            return Lists.newArrayList();
        }
        OpenApiSchema apiSchema = openApiSchemaOptional.get();
        RSharePath responseFieldsPath = apiSchema.getResponseFieldsPath();
        if (responseFieldsPath == null) {
            LOG.error("响应结果中 position is blan");
            return null;
        }
        String position = responseFieldsPath.getPosition();
        if (StrUtil.isBlank(position)) {
            LOG.error("响应结果中 position is blank");
            return null;
        }
        List<FieldInfo> fieldInfoList = getFieldInfoByOpenApiSchema(apiSchema, position, responseJson);
        return fieldInfoList;
    }

    /**
     * 从服务规约json中获取请求字段信息
     *
     * @param openApiJsonSchema 规约json
     * @param requestJson       请求参数json
     * @return
     */
    public static List<FieldInfo> getRequestFieldInfoByOpenApiJson(String openApiJsonSchema, String requestJson) {
        OpenApiDocument openApiDocument = JSONObject.parseObject(openApiJsonSchema, OpenApiDocument.class);
        Optional<OpenApiSchema> schemaOptional = openApiDocument.fetchRequestSchemaOptional();
        if (!schemaOptional.isPresent()) {
            return null;
        }
        OpenApiSchema openApiSchema = schemaOptional.get();
        RSharePath requestFields = openApiSchema.getRequestFieldsPath();
        if (requestFields == null) {
            LOG.error("请求参数中 position is blank");
            return null;
        }
        String position = requestFields.getPosition();
        if (StrUtil.isBlank(position)) {
            LOG.error("请求参数中 position is blank");
            return null;
        }
        List<FieldInfo> fieldInfoList = getFieldInfoByOpenApiSchema(openApiSchema, position, requestJson);
        return fieldInfoList;
    }

    /**
     * 通过Schema获取FieldInfo
     *
     * @param openApiSchema
     * @return
     */
    private static List<FieldInfo> getFieldInfoByOpenApiSchema(OpenApiSchema openApiSchema, String position, String json) {
        List<FieldInfo> fieldInfoList = Lists.newArrayList();
        Object eval = JSONPath.eval(json, position);
        if (eval instanceof String) {
            FieldInfo fieldInfo = new FieldInfo();
            fieldInfo.setType("");
            fieldInfo.setValue(eval.toString());
            fieldInfoList.add(fieldInfo);
        } else {
            JSONArray evalList = (JSONArray) eval;
            evalList.forEach(evalItem -> {
                FieldInfo fieldInfo = new FieldInfo();
                fieldInfo.setType("");
                fieldInfo.setValue(evalItem.toString());
                fieldInfoList.add(fieldInfo);
            });
        }
        return fieldInfoList;
    }

    /**
     * json数据转为OpenApiJson excel
     *
     * @param reqAndRespData
     * @param name           接口名称
     * @param desc           接口描述
     * @param version        接口版本号
     * @param servers        地址
     * @param operationId    url和operationId是一致的
     * @param httpMethod     请求方法,get.post
     * @return
     */
    public static String reqAndRespToOpenApiJson(JSONObject reqAndRespData, String name, String desc, String version, List<Servers> servers, String operationId, String httpMethod) {
        OpenApiDocument openAPIDocument = new OpenApiDocument();
        Info info = new Info();
        info.setDescription(desc);
        info.setVersion(version);
        info.setTitle(name);
        openAPIDocument.setInfo(info);
        openAPIDocument.setServers(servers);
        OpenApiOperation openApiOperation = new OpenApiOperation();
        //请求头
        List<HeadersParameter> headersParameters = OpenApiUtil.buildHeadersParameter(reqAndRespData.getJSONArray("service_req_headers"));
        openApiOperation.setParameters(headersParameters);
        //请求体
        OpenApiContent openApiContent = OpenApiUtil.buildOpenApiContent(reqAndRespData.getJSONArray("service_req_args"), reqAndRespData.getJSONObject("service_req_sample").getString("body"));
        openApiOperation.setSummary(name);
        openApiOperation.setDescription(desc);
        openApiOperation.setOperationId(operationId);
        openApiOperation.setDeprecated(Boolean.FALSE);
        RequestBody requestBody = new RequestBody();
        requestBody.setContent(openApiContent);
        openApiOperation.setRequestBody(requestBody);
        //响应体
        LinkedHashMap<String, OpenApiResponse> responses = OpenApiUtil.buildOpenApiResponse(reqAndRespData.getJSONArray("service_resp_headers"), reqAndRespData.getJSONArray("service_resp_args"), reqAndRespData.getJSONArray("service_resp_code"), reqAndRespData.getJSONObject("service_resp_sample").getString("body"));
        openApiOperation.setResponses(responses);
        OpenApiPath path = new OpenApiPath();
        path.set(httpMethod, openApiOperation);
        //url和operationId是一致的
        openAPIDocument.paths("/" + operationId, path);
        String defaultSchema = JSON.toJSONString(openAPIDocument, SerializerFeature.PrettyFormat);
        return defaultSchema;
    }

    /**
     * 设置响应体
     *
     * @param respHeaders
     * @param respArgs
     * @param respCodes
     * @return
     */
    public static LinkedHashMap<String, OpenApiResponse> buildOpenApiResponse(JSONArray respHeaders, JSONArray respArgs, JSONArray respCodes, String example) {
        LinkedHashMap<String, OpenApiResponse> responses = Maps.newLinkedHashMap();
        for (int i = 0, size = respCodes.size(); i < size; i++) {
            JSONObject respCode = respCodes.getJSONObject(i);
            String code = respCode.getString("code");
            String desc = respCode.getString("desc");
            OpenApiResponse openApiResponse = new OpenApiResponse();
            openApiResponse.setDescription(desc);
            OpenApiContent openApiContent = buildOpenApiContent(respArgs, example);
            openApiResponse.setContent(openApiContent);
            openApiResponse.setParameters(buildHeadersParameter(respHeaders));
            responses.put(code, openApiResponse);
        }
        return responses;
    }

    /**
     * 构建请求参数
     *
     * @param reqHeaders
     * @return
     */
    public static List<HeadersParameter> buildHeadersParameter(JSONArray reqHeaders) {
        List<HeadersParameter> parameters = new ArrayList<>();
        for (int i = 0, size = reqHeaders.size(); i < size; i++) {
            JSONObject header = reqHeaders.getJSONObject(i);
            String arg = header.getString("arg");
            String name = header.getString("name");
            String desc = header.getString("desc");
            String type = header.getString("type");
            String required = header.getString("required");
            String defaultValue = header.getString("defaultValue");
            HeadersParameter parameter = new HeadersParameter();
            parameter.setIn("header");
            parameter.setName(arg);
            parameter.setDescription(name);
            if (StrUtil.isNotBlank(required)) {
                parameter.setRequired(Objects.equals("是", required) ? Boolean.TRUE : Objects.equals("1", required) ? Boolean.TRUE : Boolean.FALSE);
            }
            parameter.setDefaultValue(defaultValue);
            parameter.setExample("");
            Map<String, Object> schema = new HashMap<>();
            schema.put("type", type);
            parameter.setSchema(schema);
            parameters.add(parameter);
        }
        return parameters;
    }

    /**
     * 构建请求体
     *
     * @param reqArgs
     * @return
     */
    public static OpenApiContent buildOpenApiContent(JSONArray reqArgs, String example) {
        OpenApiContent openApiContent = new OpenApiContent();
        //xml先不做
        openApiContent.setApplicationXml(new OpenApiMediaType());
        OpenApiMediaType openApiMediaType = new OpenApiMediaType();
        OpenApiSchema apiSchema = new OpenApiSchema();
        apiSchema.setType("object");
        apiSchema.setExample(example);
        Map<String, OpenApiProperties> properties = Maps.newHashMap();
        Map<String, List<JSONObject>> groupByParentArgMap = reqArgs.stream().map(obj -> JSON.parseObject(obj.toString()))
                .collect(Collectors.groupingBy(obj -> obj.getString("pArg")));
        //先添加父元素
        List<JSONObject> parentList = groupByParentArgMap.get("");
        Map<String, JSONObject> pathMap = reqArgs.stream().map(obj -> JSON.parseObject(obj.toString()))
                .filter(json -> StrUtil.isNotBlank(json.getString("path")))
                .collect(Collectors.toMap(
                        json -> json.getString("arg"),
                        v1 -> v1,
                        (v1, v2) -> v2
                ));
        //设置rSharePath
        setRSharePath(apiSchema, pathMap, reqArgs);
        buildProperties(parentList, properties, groupByParentArgMap);
        List<String> requiredArgs = fetchRequiredArgs(parentList);
        if (CollectionUtils.isNotEmpty(requiredArgs)) {
            apiSchema.setRequired(requiredArgs);
        }
        apiSchema.setProperties(properties);
        openApiMediaType.setSchema(apiSchema);
        openApiContent.setApplicationJson(openApiMediaType);
        return openApiContent;
    }

    /**
     * 设置RSharePath
     *
     * @param apiSchema
     * @param pathMap
     * @param reqArgs
     */
    private static void setRSharePath(OpenApiSchema apiSchema, Map<String, JSONObject> pathMap, JSONArray reqArgs) {
        pathMap.forEach((arg, json) -> {
            String path = json.getString("path");
            String pathType = json.getString("pathType");
            //请求参数
            if (StrUtil.isNotBlank(path)) {
                //请求字段
                if (path.contains("requestField")) {
                    RSharePath rSharePath = new RSharePath(arg, pathType);
                    setRSharePathPosition(rSharePath, json, reqArgs);
                    apiSchema.setRequestFieldsPath(rSharePath);
                }
                //响应参数
                if (path.contains("responseField")) {
                    RSharePath rSharePath = new RSharePath(arg, pathType);
                    setRSharePathPosition(rSharePath, json, reqArgs);
                    apiSchema.setResponseFieldsPath(rSharePath);
                }
                //响应数据
                if (path.contains("responseData")) {
                    RSharePath rSharePath = new RSharePath(arg, pathType);
                    setRSharePathPosition(rSharePath, json, reqArgs);
                    apiSchema.setResponseDataPath(rSharePath);
                }
            }

        });
    }

    /**
     * 获取RSharePath
     *
     * @param json
     * @param reqArgs
     * @return
     */
    private static void setRSharePathPosition(RSharePath rSharePath, JSONObject json, JSONArray reqArgs) {
        String pArg = json.getString("pArg");
        if (StrUtil.isBlank(pArg)) {
            rSharePath.setPosition("$." + rSharePath.getPosition());
            return;
        }
        Optional<JSONObject> parent = reqArgs.stream()
                .map(obj -> JSON.parseObject(obj.toString()))
                .filter(itemJson -> pArg.equals(itemJson.getString("arg")))
                .findFirst();
        if (parent.isPresent()) {
            JSONObject parentJson = parent.get();
            String type = parentJson.getString("type");
            String arg = parentJson.getString("arg");
            if ("array".equalsIgnoreCase(type)) {
                arg = arg + "[*]";
            }
            String pathString = arg + "." + rSharePath.getPosition();
            rSharePath.setPosition(pathString);
            setRSharePathPosition(rSharePath, parentJson, reqArgs);
        }

    }


    public static void buildProperties(List<JSONObject> parentList, Map<String, OpenApiProperties> properties, Map<String, List<JSONObject>> groupByParentArgMap) {
        if (CollectionUtils.isEmpty(parentList)) {
            return;
        }
        for (int i = 0, size = parentList.size(); i < size; i++) {
            JSONObject item = parentList.get(i);
            String arg = item.getString("arg");
            String desc = item.getString("desc");
            String type = item.getString("type");
            String required = item.getString("required");
            String path = item.getString("path");
            String pathType = item.getString("pathType");
            String defaultValue = item.getString("defaultValue");
            //设置必填项 当前目录的必填项
            List<JSONObject> child = groupByParentArgMap.getOrDefault(arg, Lists.newArrayList());
            List<String> requiredArgs = fetchRequiredArgs(child);
            OpenApiProperties openApiPropertiesItem = new OpenApiProperties();
            openApiPropertiesItem.setType(type);
            openApiPropertiesItem.setTitle(arg);
            openApiPropertiesItem.setDescription(desc);
            openApiPropertiesItem.setDefaultValue(defaultValue);
            Map<String, OpenApiProperties> propertiesItems = Maps.newHashMap();
            buildProperties(child, propertiesItems, groupByParentArgMap);
            //如果是 array 下面需要添加items,再将properties属性给items
            if ("array".equalsIgnoreCase(type)) {
                Items items = new Items();
                items.setProperties(propertiesItems);
                openApiPropertiesItem.setItems(items);
            }else {
                openApiPropertiesItem.setProperties(propertiesItems);
            }

            if (StrUtil.isNotBlank(required) && CollectionUtils.isNotEmpty(requiredArgs)) {
                openApiPropertiesItem.setRequired(requiredArgs);
            }
            properties.put(arg, openApiPropertiesItem);

        }
    }

    /**
     * 拿到当前节点的所有必须的字段
     *
     * @param child
     * @return
     */
    public static List<String> fetchRequiredArgs(List<JSONObject> child) {
        List<String> requiredArgs = child.stream().map(json -> JSON.parseObject(JSON.toJSONString(json)))
                .filter(json -> (StrUtil.isNotBlank(json.getString("required")) && (Objects.equals("是", json.getString("required")) || Objects.equals("1", json.getString("required")))))
                .map(json -> json.getString("arg")).collect(Collectors.toList());
        return requiredArgs;
    }
}
