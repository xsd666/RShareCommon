package com.run.rshare.common.agreement.document;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ApiSchema
 * @Description: 请求体Schema
 * @Author xsd
 * @Date 2023/8/22
 * @Version V1.0
 **/
public class OpenApiSchema {
    /**
     * 类型
     */
    private String type;
    /**
     * 参数响应信息
     */

    private Map<String, OpenApiProperties> properties;
    /**
     * 实例
     */
    private String example;

    private List<String> required;

    @JSONField(name = "x-rshare-request_fields-path")
    private RSharePath requestFieldsPath;

    @JSONField(name = "x-rshare-response_fields-path")
    private RSharePath responseFieldsPath;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, OpenApiProperties> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, OpenApiProperties> properties) {
        this.properties = properties;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public List<String> getRequired() {
        return required;
    }

    public void setRequired(List<String> required) {
        this.required = required;
    }

    public RSharePath getRequestFieldsPath() {
        return requestFieldsPath;
    }

    public void setRequestFieldsPath(RSharePath requestFieldsPath) {
        this.requestFieldsPath = requestFieldsPath;
    }

    public RSharePath getResponseFieldsPath() {
        return responseFieldsPath;
    }

    public void setResponseFieldsPath(RSharePath responseFieldsPath) {
        this.responseFieldsPath = responseFieldsPath;
    }
}
