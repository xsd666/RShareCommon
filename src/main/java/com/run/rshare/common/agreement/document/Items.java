package com.run.rshare.common.agreement.document;

import java.util.Map;

/**
 * @ClassName Items
 * @Description: TODO
 * @Author xsd
 * @Date 2023/8/28
 * @Version V1.0
 **/
public class Items {

    /**
     * 类型
     */
    private String type = "object";
    /**
     * 描述
     */
    private String description = "数据项对象";

    /**
     * 参数响应信息
     */
    private Map<String, OpenApiProperties> properties;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, OpenApiProperties> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, OpenApiProperties> properties) {
        this.properties = properties;
    }
}
