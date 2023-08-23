package com.run.rshare.common.agreement.document;

import io.swagger.models.HttpMethod;

/**
 * @ClassName OpenAPIPath
 * @Description: 到各个端点的相对路径，路径必须以/打头，这个路径会被直接连接到 Server 对象 的url字段以组成完整URL地
 * @Author xsd
 * @Date 2023/8/21
 * @Version V1.0
 **/
public class OpenApiPath {
    private OpenApiOperation get;
    private OpenApiOperation put;
    private OpenApiOperation post;
    private OpenApiOperation delete;

    public void set(String httpMethod,OpenApiOperation openApiOperation){
        if(HttpMethod.GET.name().equalsIgnoreCase(httpMethod)){
            setGet(openApiOperation);
        }else if(HttpMethod.PUT.name().equalsIgnoreCase(httpMethod)){
            setPut(openApiOperation);
        }else if(HttpMethod.POST.name().equalsIgnoreCase(httpMethod)){
            setPost(openApiOperation);
        }else if(HttpMethod.DELETE.name().equalsIgnoreCase(httpMethod)){
            setDelete(openApiOperation);
        }
    }

    public OpenApiOperation getGet() {
        return get;
    }

    public void setGet(OpenApiOperation get) {
        this.get = get;
    }

    public OpenApiOperation getPut() {
        return put;
    }

    public void setPut(OpenApiOperation put) {
        this.put = put;
    }

    public OpenApiOperation getPost() {
        return post;
    }

    public void setPost(OpenApiOperation post) {
        this.post = post;
    }

    public OpenApiOperation getDelete() {
        return delete;
    }

    public void setDelete(OpenApiOperation delete) {
        this.delete = delete;
    }
}
