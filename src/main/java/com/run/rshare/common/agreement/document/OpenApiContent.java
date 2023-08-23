package com.run.rshare.common.agreement.document;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @ClassName RequestBody
 * @Description: 请求体
 * @Author xsd
 * @Date 2023/8/22
 * @Version V1.0
 **/
public class OpenApiContent {

    @JsonProperty("application/json")
    @JSONField(name = "application/json")
    private OpenApiMediaType applicationJson;

    @JsonProperty("application/xml")
    @JSONField(name = "application/xml")
    private OpenApiMediaType applicationXml;

    public OpenApiMediaType getApplicationJson() {
        return applicationJson;
    }

    public void setApplicationJson(OpenApiMediaType applicationJson) {
        this.applicationJson = applicationJson;
    }

    public OpenApiMediaType getApplicationXml() {
        return applicationXml;
    }

    public void setApplicationXml(OpenApiMediaType applicationXml) {
        this.applicationXml = applicationXml;
    }
}
