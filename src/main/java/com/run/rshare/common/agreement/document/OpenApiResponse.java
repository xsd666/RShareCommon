package com.run.rshare.common.agreement.document;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OpenApiResponse
 * @Description: 响应结果
 * @Author xsd
 * @Date 2023/8/22
 * @Version V1.0
 **/
public class OpenApiResponse {

    private String description;

    private OpenApiContent content;

    private List<HeadersParameter> parameters = new ArrayList<HeadersParameter>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OpenApiContent getContent() {
        return content;
    }

    public void setContent(OpenApiContent content) {
        this.content = content;
    }

    public List<HeadersParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<HeadersParameter> parameters) {
        this.parameters = parameters;
    }
}
