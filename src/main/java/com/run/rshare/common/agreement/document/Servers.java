package com.run.rshare.common.agreement.document;

/**
 * @ClassName Servers
 * @Description: 这是一个Server对象的数组， 提供到服务器的连接信息。如果没有提供servers属性或者是一个空数组
 * @Author xsd
 * @Date 2023/8/22
 * @Version V1.0
 **/
public class Servers {
    /**
     * 必选. 指向目标主机的URL地址。这个URL地址支持服务器变量而且可能是相对路径，表示主机路径是相对于本文档所在的路径
     */
    private String url;
    /**
     * 一个可选的字符串，用来描述此URL地址
     */
    private String description;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
