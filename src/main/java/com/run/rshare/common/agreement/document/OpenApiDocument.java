package com.run.rshare.common.agreement.document;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName OpenAPIDocument
 * @Description: OpenAPI 对象
 * @Author xsd
 * @Date 2023/8/21
 * @Version V1.0
 **/
public class OpenApiDocument {
    /**
     * 必选. 这个字符串必须是开放API规范版本号提到的符合语义化版本号规范的版本号。openapi字段应该被工具或者客户端用来解释 OpenAPI 文档。这个值和API info.version字符串没有关联。
     */
    protected String openapi = "3.0.1";
    /**
     * 必选。此字段提供API相关的元数据。相关工具可能需要这个字段。
     */
    protected Info info;
    /**
     * 这是一个Server对象的数组， 提供到服务器的连接信息。如果没有提供servers属性或者是一个空数组
     */
    protected List<Servers> servers;
    /**
     * 必选。对所提供的API有效的路径和操作。
     */
    protected Map<String, OpenApiPath> paths;

    public String getOpenapi() {
        return openapi;
    }

    public void setOpenapi(String openapi) {
        this.openapi = openapi;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Servers> getServers() {
        return servers;
    }

    public void setServers(List<Servers> servers) {
        this.servers = servers;
    }

    public Map<String, OpenApiPath> getPaths() {
        return paths;
    }

    public void setPaths(Map<String, OpenApiPath> paths) {
        this.paths = paths;
    }

    public void paths(String key, OpenApiPath path) {
        if (this.paths == null) {
            this.paths = new LinkedHashMap<String, OpenApiPath>();
        }
        this.paths.put(key, path);
    }

}
