package com.run.rshare.common.agreement.document;

/**
 * @ClassName Info
 * @Description: 这个对象提供API的元数据。如果客户端需要时可能会用到这些元数据，而且可能会被呈现在编辑工具或者文档生成工具中。
 * @Author xsd
 * @Date 2023/8/21
 * @Version V1.0
 **/
public class Info {
    /**
     * 对应用的简短描述
     */
    private String description;
    /**
     * 必选. API文档的版本信息
     */
    private String version;
    /**
     * 必选. 应用的名称
     */
    private String title;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
