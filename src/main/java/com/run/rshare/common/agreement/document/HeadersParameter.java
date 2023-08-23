package com.run.rshare.common.agreement.document;

import java.util.Map;

/**
 * @ClassName HeadersParameter
 * @Description: TODO
 * @Author xsd
 * @Date 2023/8/22
 * @Version V1.0
 **/
public class HeadersParameter {

    private String name;
    private String in;
    private String description;
    private Boolean required;
    private String example;
    private Map<String,Object> schema;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public Map<String, Object> getSchema() {
        return schema;
    }

    public void setSchema(Map<String, Object> schema) {
        this.schema = schema;
    }
}
