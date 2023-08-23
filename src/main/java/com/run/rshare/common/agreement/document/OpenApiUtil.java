package com.run.rshare.common.agreement.document;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName OpenApiUtil
 * @Description: ��Լ������
 * @Author xsd
 * @Date 2023/8/23
 * @Version V1.0
 **/
public class OpenApiUtil {

    /**
     * json����תΪOpenApiJson excel
     * @param reqAndRespData
     * @param name     �ӿ�����
     * @param desc     �ӿ�����
     * @param version  �ӿڰ汾��
     * @param servers  ��ַ
     * @param operationId  url��operationId��һ�µ�
     * @param httpMethod  ���󷽷�,get.post
     * @return
     */
    public static String reqAndRespToOpenApiJson(JSONObject reqAndRespData,String name,String desc,String version,List<Servers> servers,String operationId,String httpMethod){
        OpenApiDocument openAPIDocument = new OpenApiDocument();
        Info info = new Info();
        info.setDescription(desc);
        info.setVersion(version);
        info.setTitle(name);
        openAPIDocument.setInfo(info);
        openAPIDocument.setServers(servers);
        OpenApiOperation openApiOperation = new OpenApiOperation();
        //����ͷ
        List<HeadersParameter> headersParameters = OpenApiUtil.buildHeadersParameter(reqAndRespData.getJSONArray("service_req_headers"));
        openApiOperation.setParameters(headersParameters);
        //������
        OpenApiContent openApiContent = OpenApiUtil.buildOpenApiContent(reqAndRespData.getJSONArray("service_req_args"), reqAndRespData.getJSONObject("service_req_sample").getString("body"));
        openApiOperation.setSummary(name);
        openApiOperation.setDescription(desc);
        openApiOperation.setOperationId(operationId);
        openApiOperation.setDeprecated(Boolean.FALSE);
        RequestBody requestBody = new RequestBody();
        requestBody.setContent(openApiContent);
        openApiOperation.setRequestBody(requestBody);
        //��Ӧ��
        LinkedHashMap<String, OpenApiResponse> responses = OpenApiUtil.buildOpenApiResponse(reqAndRespData.getJSONArray("service_resp_headers"), reqAndRespData.getJSONArray("service_resp_args"), reqAndRespData.getJSONArray("service_resp_code"), reqAndRespData.getJSONObject("service_resp_sample").getString("body"));
        openApiOperation.setResponses(responses);
        OpenApiPath path = new OpenApiPath();
        path.set(httpMethod, openApiOperation);
        //url��operationId��һ�µ�
        openAPIDocument.paths("/" + operationId, path);
        String defaultSchema = JSON.toJSONString(openAPIDocument, SerializerFeature.PrettyFormat);
        return defaultSchema;
    }
    /**
     * ������Ӧ��
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
     * �����������
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
            HeadersParameter parameter = new HeadersParameter();
            parameter.setIn("header");
            parameter.setName(arg);
            parameter.setDescription(name);
            if (StrUtil.isNotBlank(required)) {
                parameter.setRequired(Objects.equals("��", required) ? Boolean.TRUE : Objects.equals("1", required) ? Boolean.TRUE : Boolean.FALSE);
            }
            parameter.setExample("");
            Map<String, Object> schema = new HashMap<>();
            schema.put("type", type);
            parameter.setSchema(schema);
            parameters.add(parameter);
        }
        return parameters;
    }

    /**
     * ����������
     *
     * @param reqArgs
     * @return
     */
    public static OpenApiContent buildOpenApiContent(JSONArray reqArgs, String example) {
        OpenApiContent openApiContent = new OpenApiContent();
        //xml�Ȳ���
        openApiContent.setApplicationXml(new OpenApiMediaType());
        OpenApiMediaType openApiMediaType = new OpenApiMediaType();
        OpenApiSchema apiSchema = new OpenApiSchema();
        apiSchema.setType("object");
        apiSchema.setExample(example);
        Map<String, OpenApiProperties> properties = Maps.newHashMap();
        Map<String, List<JSONObject>> groupByParentArgMap = reqArgs.stream().map(obj -> JSON.parseObject(obj.toString()))
                .collect(Collectors.groupingBy(obj -> obj.getString("pArg")));
        //����Ӹ�Ԫ��
        List<JSONObject> parentList = groupByParentArgMap.get("");
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

    public static  void buildProperties(List<JSONObject> parentList, Map<String, OpenApiProperties> properties, Map<String, List<JSONObject>> groupByParentArgMap) {
        if (CollectionUtils.isEmpty(parentList)) {
            return;
        }
        for (int i = 0, size = parentList.size(); i < size; i++) {
            JSONObject item = parentList.get(i);
            String arg = item.getString("arg");
            String desc = item.getString("desc");
            String type = item.getString("type");
            String required = item.getString("required");
            //���ñ����� ��ǰĿ¼�ı�����
            List<JSONObject> child = groupByParentArgMap.getOrDefault(arg, Lists.newArrayList());
            List<String> requiredArgs = fetchRequiredArgs(child);
            OpenApiProperties openApiPropertiesItem = new OpenApiProperties();
            openApiPropertiesItem.setType(type);
            openApiPropertiesItem.setTitle(arg);
            openApiPropertiesItem.setDescription(desc);
            Map<String, OpenApiProperties> propertiesItem = Maps.newHashMap();
            buildProperties(child, propertiesItem, groupByParentArgMap);
            if (!MapUtils.isEmpty(propertiesItem)) {
                openApiPropertiesItem.setProperties(propertiesItem);
            }
            openApiPropertiesItem.setProperties(propertiesItem);
            if (!MapUtils.isEmpty(propertiesItem)) {
                openApiPropertiesItem.setProperties(propertiesItem);
            }
            if (StrUtil.isNotBlank(required) && CollectionUtils.isNotEmpty(requiredArgs)) {
                openApiPropertiesItem.setRequired(requiredArgs);
            }
            properties.put(arg, openApiPropertiesItem);

        }
    }

    /**
     * �õ���ǰ�ڵ�����б�����ֶ�
     *
     * @param child
     * @return
     */
    public static List<String> fetchRequiredArgs(List<JSONObject> child) {
        List<String> requiredArgs = child.stream().map(json -> JSON.parseObject(JSON.toJSONString(json)))
                .filter(json -> (StrUtil.isNotBlank(json.getString("required")) && (Objects.equals("��", json.getString("required")) || Objects.equals("1", json.getString("required")))))
                .map(json -> json.getString("arg")).collect(Collectors.toList());
        return requiredArgs;
    }
}
