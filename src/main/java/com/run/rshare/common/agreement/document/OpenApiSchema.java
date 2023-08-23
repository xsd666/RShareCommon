package com.run.rshare.common.agreement.document;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ApiSchema
 * @Description: ������Schema
 * @Author xsd
 * @Date 2023/8/22
 * @Version V1.0
 **/
public class OpenApiSchema {
    /**
     * ����
     */
    private String type;
    /**
     * ������Ӧ��Ϣ
     */

    private Map<String, OpenApiProperties> properties;
    /**
     * ʵ��
     */
    private String example;

    private List<String> required;

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
}
