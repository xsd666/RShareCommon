package com.run.rshare.common.agreement.document;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ApiOperation
 * @Description: 描述对路径的某个操作
 * @Author xsd
 * @Date 2023/8/22
 * @Version V1.0
 **/
public class OpenApiOperation {
    /**
     * 对此操作行为的简短描述。
     */
    private String summary;
    /**
     * 对此操作行为的详细解释
     */
    private String description;
    /**
     * 用于标识此操作的唯一字符串，
     */
    private String operationId;
    /**
     * 声明此操作已经被废弃，使用者应该尽量避免使用此操作
     */
    private Boolean deprecated = Boolean.FALSE;
    /**
     * 必选. 定义执行此操作后的可能的响应值列表
     */
    private LinkedHashMap<String, OpenApiResponse> responses;
    /**
     * 此操作的请求体
     */
    private RequestBody requestBody;

    private List<HeadersParameter> parameters = new ArrayList<HeadersParameter>();

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public Boolean getDeprecated() {
        return deprecated;
    }

    public void setDeprecated(Boolean deprecated) {
        this.deprecated = deprecated;
    }

    public Map<String, OpenApiResponse> getResponses() {
        return responses;
    }

    public void setResponses(LinkedHashMap<String, OpenApiResponse> responses) {
        this.responses = responses;
    }

    public RequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }

    public List<HeadersParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<HeadersParameter> parameters) {
        this.parameters = parameters;
    }
}