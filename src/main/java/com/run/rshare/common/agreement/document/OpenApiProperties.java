package com.run.rshare.common.agreement.document;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ApiProperties
 * @Description: 参数实体信息
 * @Author xsd
 * @Date 2023/8/22
 * @Version V1.0
 **/
public class OpenApiProperties {
    /**
     * 必须的字段
     */
    private List<String> required;
    /**
     * 类型
     */
    private String type;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 函数信息
     */
    private String format;
    /**
     * 默认值
     */
    @JSONField(name="default")
    private String defaultVal;
    /**
     * 正则表达式
     */
    private String pattern;

    @JSONField(name="enum")
    private List<String> enumVal;
    /**
     * 实例
     */
    private List<String> examples;

    /**
     * 参数响应信息
     */
    private Map<String, OpenApiProperties> properties;


    public List<String> getRequired() {
        return required;
    }

    public void setRequired(List<String> required) {
        this.required = required;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDefaultVal() {
        return defaultVal;
    }

    public void setDefaultVal(String defaultVal) {
        this.defaultVal = defaultVal;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public List<String> getEnumVal() {
        return enumVal;
    }

    public void setEnumVal(List<String> enumVal) {
        this.enumVal = enumVal;
    }

    public List<String> getExamples() {
        return examples;
    }

    public void setExamples(List<String> examples) {
        this.examples = examples;
    }

    public Map<String, OpenApiProperties> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, OpenApiProperties> properties) {
        this.properties = properties;
    }
}
