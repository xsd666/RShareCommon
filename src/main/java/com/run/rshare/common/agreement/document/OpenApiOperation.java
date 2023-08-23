package com.run.rshare.common.agreement.document;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ApiOperation
 * @Description: ������·����ĳ������
 * @Author xsd
 * @Date 2023/8/22
 * @Version V1.0
 **/
public class OpenApiOperation {
    /**
     * �Դ˲�����Ϊ�ļ��������
     */
    private String summary;
    /**
     * �Դ˲�����Ϊ����ϸ����
     */
    private String description;
    /**
     * ���ڱ�ʶ�˲�����Ψһ�ַ�����
     */
    private String operationId;
    /**
     * �����˲����Ѿ���������ʹ����Ӧ�þ�������ʹ�ô˲���
     */
    private Boolean deprecated = Boolean.FALSE;
    /**
     * ��ѡ. ����ִ�д˲�����Ŀ��ܵ���Ӧֵ�б�
     */
    private LinkedHashMap<String, OpenApiResponse> responses;
    /**
     * �˲�����������
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