package com.run.rshare.common.agreement.document;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.run.rshare.common.agreement.AgreementFunction.FunctionEnum;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @ClassName OpenAPIDocument
 * @Description: OpenAPI 对象
 * @Author xsd
 * @Date 2023/8/21
 * @Version V1.0
 **/
public class OpenApiDocument {
    /**
     * 必选. 这个字符串必须是开放API规范版本号提到的符合语义化版本号规范的版本号。openapi字段应该被工具或者客户端用来解释 OpenAPI 文档。这个值和API info.version字符串没有关联。
     */
    protected String openapi = "3.0.1";
    /**
     * 必选。此字段提供API相关的元数据。相关工具可能需要这个字段。
     */
    protected Info info;
    /**
     * 这是一个Server对象的数组， 提供到服务器的连接信息。如果没有提供servers属性或者是一个空数组
     */
    protected List<Servers> servers;
    /**
     * 必选。对所提供的API有效的路径和操作。
     */
    protected Map<String, OpenApiPath> paths;

    public String getOpenapi() {
        return openapi;
    }

    public void setOpenapi(String openapi) {
        this.openapi = openapi;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Servers> getServers() {
        return servers;
    }

    public void setServers(List<Servers> servers) {
        this.servers = servers;
    }

    public Map<String, OpenApiPath> getPaths() {
        return paths;
    }

    public void setPaths(Map<String, OpenApiPath> paths) {
        this.paths = paths;
    }

    public void paths(String key, OpenApiPath path) {
        if (this.paths == null) {
            this.paths = new LinkedHashMap<String, OpenApiPath>();
        }
        this.paths.put(key, path);
    }

    /**
     * 获取请求方法
     *
     * @return
     */
    public String fetchHttpMethod() {
        Optional<String> path = paths.keySet().stream().findFirst();
        if (!path.isPresent()) {
            return null;
        }
        OpenApiPath openApiPath = paths.get(path.get());
        String httpMethod = openApiPath.fetchHttpMethod();
        return httpMethod;
    }

    /**
     * 获取请求头
     *
     * @return
     */
    public JSONObject fetchRequestHeader(Map<String, Object> paramsMap) {
        if (MapUtils.isEmpty(paths)) {
            return null;
        }
        String path = paths.keySet().iterator().next();
        OpenApiPath openApiPath = paths.get(path);
        OpenApiOperation openApiOperation = openApiPath.get();
        if (openApiOperation == null) {
            return null;
        }
        List<HeadersParameter> parameters = openApiOperation.getParameters();
        JSONObject jsonObject = new JSONObject();
        parameters.forEach(parameter -> {
            jsonObject.put(parameter.getName(), getVal(parameter.getDefaultValue(), paramsMap));
        });
        return jsonObject;
    }

    public OpenApiOperation fetchOpenApiOperation() {
        if (MapUtils.isEmpty(paths)) {
            return null;
        }
        String path = paths.keySet().iterator().next();
        OpenApiPath openApiPath = paths.get(path);
        OpenApiOperation openApiOperation = openApiPath.get();
        return openApiOperation;
    }

    /**
     * 获取请求schema
     *
     * @return
     */
    public Optional<OpenApiSchema> fetchRequestSchemaOptional() {
        OpenApiOperation openApiOperation = fetchOpenApiOperation();
        Optional<OpenApiSchema> openApiSchemaOptional = Optional.of(openApiOperation.getRequestBody())
                .map(RequestBody::getContent)
                .map(OpenApiContent::getApplicationJson)
                .map(OpenApiMediaType::getSchema);
        return openApiSchemaOptional;
    }


    /**
     * 获取响应Response
     *
     * @param responseCode
     * @return
     */
    public Optional<OpenApiResponse> fetchOpenApiResponseOptional(String responseCode) {
        OpenApiOperation openApiOperation = fetchOpenApiOperation();
        Optional<OpenApiResponse> openApiResponse = Optional.of(openApiOperation.getResponses())
                .map(response -> response.get(responseCode));
        return openApiResponse;
    }

    /**
     * 获取响应Response参数
     *
     * @param openApiResponseOptional
     * @return fetchResponseHeader
     */
    public JSONObject fetchResponseHeader(Optional<OpenApiResponse> openApiResponseOptional,Map<String, Object> paramsMap) {
        if (!openApiResponseOptional.isPresent()) {
            return null;
        }
        OpenApiResponse apiResponse = openApiResponseOptional.get();
        List<HeadersParameter> parameters = apiResponse.getParameters();
        JSONObject jsonObject = new JSONObject();
        parameters.forEach(parameter -> {
            jsonObject.put(parameter.getName(), getVal(parameter.getDefaultValue(), paramsMap));
        });
        return jsonObject;
    }

    /**
     * 获取响应json
     *
     * @return
     */
    public JSONObject fetchResponseJSON(Optional<OpenApiResponse> openApiResponseOptional, Map<String, Object> paramsMap) {
        Optional<OpenApiSchema> openApiSchemaOptional = openApiResponseOptional.map(OpenApiResponse::getContent)
                .map(OpenApiContent::getApplicationJson)
                .map(OpenApiMediaType::getSchema);
        if (!openApiSchemaOptional.isPresent()) {
            return null;
        }
        OpenApiSchema apiSchema = openApiSchemaOptional.get();
        return fetchJSON(apiSchema, paramsMap);

    }


    /**
     * 获取响应schema
     *
     * @param openApiResponse
     * @return
     */
    public Optional<OpenApiSchema> fetchResponseSchemaOptional(Optional<OpenApiResponse> openApiResponse) {
        return openApiResponse.map(OpenApiResponse::getContent)
                .map(OpenApiContent::getApplicationJson)
                .map(OpenApiMediaType::getSchema);
    }

    /**
     * 获取json
     *
     * @return
     */
    public JSONObject fetchJSON(OpenApiSchema apiSchema, Map<String, Object> paramsMap) {
        Map<String, OpenApiProperties> properties = apiSchema.getProperties();
        if (MapUtils.isEmpty(properties)) {
            return new JSONObject();
        }
        JSONObject requestParams = new JSONObject();
        properties.forEach((key, val) -> {
            setParamJsonKey(requestParams, val, paramsMap);
        });
        return requestParams;
    }


    /**
     * 获取请求json
     *
     * @return
     */
    public JSONObject fetchRequestJSON(Map<String, Object> paramsMap) {
        Optional<OpenApiSchema> schemaOptional = fetchRequestSchemaOptional();
        if (!schemaOptional.isPresent()) {
            return null;
        }
        OpenApiSchema apiSchema = schemaOptional.get();
        return fetchJSON(apiSchema, paramsMap);
    }

    /**
     * 设置参数的key
     *
     * @param requestParams
     * @param openApiProperties
     */
    private void setParamJsonKey(JSONObject requestParams, OpenApiProperties openApiProperties, Map<String, Object> paramsMap) {
        String valType = openApiProperties.getType();
        String defaultValue = openApiProperties.getDefaultValue();
        String title = openApiProperties.getTitle();
        Map<String, OpenApiProperties> properties = openApiProperties.getProperties();
        if ("array".equalsIgnoreCase(valType)) {
            JSONArray jsonArray = new JSONArray();
            Items items = openApiProperties.getItems();
            if (items != null) {
                Map<String, OpenApiProperties> itemsProperties = items.getProperties();
                JSONObject item = new JSONObject();
                if (MapUtils.isNotEmpty(itemsProperties) && defaultValue != null && !defaultValue.startsWith("REFER")) {
                    for (Map.Entry<String, OpenApiProperties> entry : itemsProperties.entrySet()) {
                        setParamJsonKey(item, entry.getValue(), paramsMap);
                    }
                    jsonArray.add(item);
                } else if (defaultValue != null && defaultValue.startsWith("REFER")) {
                    Object val = getVal(defaultValue, paramsMap);
                    if (val != null) {
                        jsonArray = JSONArray.parseArray(val.toString());
                    }
                }
            }
            requestParams.put(title, jsonArray);
        } else if ("object".equalsIgnoreCase(valType)) {
            JSONObject item = new JSONObject();
            if (MapUtils.isNotEmpty(properties) && defaultValue != null && !defaultValue.startsWith("REFER")) {
                for (Map.Entry<String, OpenApiProperties> entry : properties.entrySet()) {
                    setParamJsonKey(item, entry.getValue(), paramsMap);
                }
            } else if (defaultValue != null && defaultValue.startsWith("REFER")) {
                Object val = getVal(defaultValue, paramsMap);
                if (val != null) {
                    item = JSONObject.parseObject(val.toString());
                }
            }

            requestParams.put(title, item);
        } else {
            requestParams.put(title, getVal(defaultValue, paramsMap));
        }
    }

    /**
     * 根据配置的信息获取值
     *
     * @param defaultValue
     * @param argMap
     * @return
     */
    public Object getVal(String defaultValue, Map<String, Object> argMap) {
        if (StringUtils.isBlank(defaultValue)) {
            return null;
        }
        Object val = null;
        String between = StringUtils.substringBetween(defaultValue, "(", ")");
        if (StringUtils.isBlank(between)) {
            between = StringUtils.substringBetween(defaultValue, "（", "）");
        }
        if (defaultValue.startsWith("VALUE")) {
            val = between;
        } else if (defaultValue.startsWith("FUNC")) {
            val = FunctionEnum.getVal(between);
        } else if (defaultValue.startsWith("REFER")) {
            val = argMap.getOrDefault(between, null);
        }
        return val;
    }
}
