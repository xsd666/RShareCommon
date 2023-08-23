package com.run.rshare.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
 * 服务请求日志表
 * @TableName gw_request_logs
 */
public class gw_request_logs implements Serializable {

    /**
     * 旧ID,无序
     */
    @NotBlank(message="[旧ID,无序]涓嶈兘涓虹┖")
    @Size(max= 64,message="缂栫爜闀垮害涓嶈兘瓒呰繃64")
    @ApiModelProperty("旧ID,无序")
    @Length(max= 64,message="缂栫爜闀垮害涓嶈兘瓒呰繃64")
    public String id;
    /**
     * 用户ID
     */
    @Size(max= 100,message="缂栫爜闀垮害涓嶈兘瓒呰繃100")
    @ApiModelProperty("用户ID")
    @Length(max= 100,message="缂栫爜闀垮害涓嶈兘瓒呰繃100")
    public String userId;
    /**
     * 应用ID
     */
    @Size(max= 100,message="缂栫爜闀垮害涓嶈兘瓒呰繃100")
    @ApiModelProperty("应用ID")
    @Length(max= 100,message="缂栫爜闀垮害涓嶈兘瓒呰繃100")
    public String appId;
    /**
     * 服务资源标识
     */
    @Size(max= 100,message="缂栫爜闀垮害涓嶈兘瓒呰繃100")
    @ApiModelProperty("服务资源标识")
    @Length(max= 100,message="缂栫爜闀垮害涓嶈兘瓒呰繃100")
    public String serviceId;
    /**
     * 请求方IP
     */
    @Size(max= 255,message="缂栫爜闀垮害涓嶈兘瓒呰繃255")
    @ApiModelProperty("请求方IP")
    @Length(max= 255,message="缂栫爜闀垮害涓嶈兘瓒呰繃255")
    public String requestIp;
    /**
     * 服务地址
     */
    @Size(max= 500,message="缂栫爜闀垮害涓嶈兘瓒呰繃500")
    @ApiModelProperty("服务地址")
    @Length(max= 500,message="缂栫爜闀垮害涓嶈兘瓒呰繃500")
    public String requestUrl;
    /**
     * 服务请求时间
     */
    @ApiModelProperty("服务请求时间")
    public Date requestTime;
    /**
     * 请求方式
     */
    @Size(max= 64,message="缂栫爜闀垮害涓嶈兘瓒呰繃64")
    @ApiModelProperty("请求方式")
    @Length(max= 64,message="缂栫爜闀垮害涓嶈兘瓒呰繃64")
    public String requestMethod;
    /**
     *
     */
    @Size(max= 50,message="缂栫爜闀垮害涓嶈兘瓒呰繃50")
    @ApiModelProperty("")
    @Length(max= 50,message="缂栫爜闀垮害涓嶈兘瓒呰繃50")
    public String requestOriginalHeader;
    /**
     * 原始请求参数
     */
    @Size(max= -1,message="缂栫爜闀垮害涓嶈兘瓒呰繃-1")
    @ApiModelProperty("原始请求参数")
    @Length(max= -1,message="缂栫爜闀垮害涓嶈兘瓒呰繃-1")
    public String requestOriginalParam;
    /**
     * 请求头内容
     */
    @Size(max= -1,message="缂栫爜闀垮害涓嶈兘瓒呰繃-1")
    @ApiModelProperty("请求头内容")
    @Length(max= -1,message="缂栫爜闀垮害涓嶈兘瓒呰繃-1")
    public String requestHeadParam;
    /**
     * 处理后请求参数
     */
    @Size(max= -1,message="缂栫爜闀垮害涓嶈兘瓒呰繃-1")
    @ApiModelProperty("处理后请求参数")
    @Length(max= -1,message="缂栫爜闀垮害涓嶈兘瓒呰繃-1")
    public String requestParam;
    /**
     * 服务访问地址,服务实际跳转地址
     */
    @Size(max= 500,message="缂栫爜闀垮害涓嶈兘瓒呰繃500")
    @ApiModelProperty("服务访问地址,服务实际跳转地址")
    @Length(max= 500,message="缂栫爜闀垮害涓嶈兘瓒呰繃500")
    public String forwardUrl;
    /**
     * 转发时间
     */
    @ApiModelProperty("转发时间")
    public Date forwardTime;
    /**
     * 服务转发状态
     */
    @Size(max= 20,message="缂栫爜闀垮害涓嶈兘瓒呰繃20")
    @ApiModelProperty("服务转发状态")
    @Length(max= 20,message="缂栫爜闀垮害涓嶈兘瓒呰繃20")
    public String forwardState;
    /**
     * 服务转发失败原因
     */
    @Size(max= 4000,message="缂栫爜闀垮害涓嶈兘瓒呰繃4000")
    @ApiModelProperty("服务转发失败原因")
    @Length(max= 4000,message="缂栫爜闀垮害涓嶈兘瓒呰繃4,000")
    public String forwardFailReason;
    /**
     * 服务响应时间
     */
    @ApiModelProperty("服务响应时间")
    public Date responseTime;
    /**
     *
     */
    @Size(max= 50,message="缂栫爜闀垮害涓嶈兘瓒呰繃50")
    @ApiModelProperty("")
    @Length(max= 50,message="缂栫爜闀垮害涓嶈兘瓒呰繃50")
    public String responseOriginalHeader;
    /**
     * 原始响应请求
     */
    @Size(max= -1,message="缂栫爜闀垮害涓嶈兘瓒呰繃-1")
    @ApiModelProperty("原始响应请求")
    @Length(max= -1,message="缂栫爜闀垮害涓嶈兘瓒呰繃-1")
    public String responseOriginalParam;
    /**
     *
     */
    @Size(max= 50,message="缂栫爜闀垮害涓嶈兘瓒呰繃50")
    @ApiModelProperty("")
    @Length(max= 50,message="缂栫爜闀垮害涓嶈兘瓒呰繃50")
    public String responseHeader;
    /**
     * 处理后响应请求
     */
    @Size(max= -1,message="缂栫爜闀垮害涓嶈兘瓒呰繃-1")
    @ApiModelProperty("处理后响应请求")
    @Length(max= -1,message="缂栫爜闀垮害涓嶈兘瓒呰繃-1")
    public String responseParam;
    /**
     * 服务响应状态
     */
    @Size(max= 20,message="缂栫爜闀垮害涓嶈兘瓒呰繃20")
    @ApiModelProperty("服务响应状态")
    @Length(max= 20,message="缂栫爜闀垮害涓嶈兘瓒呰繃20")
    public String responseState;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    public Date createTime;

    /**
     * 旧ID,无序
     */
    public void setId(String id){
        this.id = id;
    }

    /**
     * 用户ID
     */
    public void setUserId(String userId){
        this.userId = userId;
    }

    /**
     * 应用ID
     */
    public void setAppId(String appId){
        this.appId = appId;
    }

    /**
     * 服务资源标识
     */
    public void setServiceId(String serviceId){
        this.serviceId = serviceId;
    }

    /**
     * 请求方IP
     */
    public void setRequestIp(String requestIp){
        this.requestIp = requestIp;
    }

    /**
     * 服务地址
     */
    public void setRequestUrl(String requestUrl){
        this.requestUrl = requestUrl;
    }

    /**
     * 服务请求时间
     */
    public void setRequestTime(Date requestTime){
        this.requestTime = requestTime;
    }

    /**
     * 请求方式
     */
    public void setRequestMethod(String requestMethod){
        this.requestMethod = requestMethod;
    }

    /**
     *
     */
    public void setRequestOriginalHeader(String requestOriginalHeader){
        this.requestOriginalHeader = requestOriginalHeader;
    }

    /**
     * 原始请求参数
     */
    public void setRequestOriginalParam(String requestOriginalParam){
        this.requestOriginalParam = requestOriginalParam;
    }

    /**
     * 请求头内容
     */
    public void setRequestHeadParam(String requestHeadParam){
        this.requestHeadParam = requestHeadParam;
    }

    /**
     * 处理后请求参数
     */
    public void setRequestParam(String requestParam){
        this.requestParam = requestParam;
    }

    /**
     * 服务访问地址,服务实际跳转地址
     */
    public void setForwardUrl(String forwardUrl){
        this.forwardUrl = forwardUrl;
    }

    /**
     * 转发时间
     */
    public void setForwardTime(Date forwardTime){
        this.forwardTime = forwardTime;
    }

    /**
     * 服务转发状态
     */
    public void setForwardState(String forwardState){
        this.forwardState = forwardState;
    }

    /**
     * 服务转发失败原因
     */
    public void setForwardFailReason(String forwardFailReason){
        this.forwardFailReason = forwardFailReason;
    }

    /**
     * 服务响应时间
     */
    public void setResponseTime(Date responseTime){
        this.responseTime = responseTime;
    }

    /**
     *
     */
    public void setResponseOriginalHeader(String responseOriginalHeader){
        this.responseOriginalHeader = responseOriginalHeader;
    }

    /**
     * 原始响应请求
     */
    public void setResponseOriginalParam(String responseOriginalParam){
        this.responseOriginalParam = responseOriginalParam;
    }

    /**
     *
     */
    public void setResponseHeader(String responseHeader){
        this.responseHeader = responseHeader;
    }

    /**
     * 处理后响应请求
     */
    public void setResponseParam(String responseParam){
        this.responseParam = responseParam;
    }

    /**
     * 服务响应状态
     */
    public void setResponseState(String responseState){
        this.responseState = responseState;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }


    /**
     * 旧ID,无序
     */
    public String getId(){
        return this.id;
    }

    /**
     * 用户ID
     */
    public String getUserId(){
        return this.userId;
    }

    /**
     * 应用ID
     */
    public String getAppId(){
        return this.appId;
    }

    /**
     * 服务资源标识
     */
    public String getServiceId(){
        return this.serviceId;
    }

    /**
     * 请求方IP
     */
    public String getRequestIp(){
        return this.requestIp;
    }

    /**
     * 服务地址
     */
    public String getRequestUrl(){
        return this.requestUrl;
    }

    /**
     * 服务请求时间
     */
    public Date getRequestTime(){
        return this.requestTime;
    }

    /**
     * 请求方式
     */
    public String getRequestMethod(){
        return this.requestMethod;
    }

    /**
     *
     */
    public String getRequestOriginalHeader(){
        return this.requestOriginalHeader;
    }

    /**
     * 原始请求参数
     */
    public String getRequestOriginalParam(){
        return this.requestOriginalParam;
    }

    /**
     * 请求头内容
     */
    public String getRequestHeadParam(){
        return this.requestHeadParam;
    }

    /**
     * 处理后请求参数
     */
    public String getRequestParam(){
        return this.requestParam;
    }

    /**
     * 服务访问地址,服务实际跳转地址
     */
    public String getForwardUrl(){
        return this.forwardUrl;
    }

    /**
     * 转发时间
     */
    public Date getForwardTime(){
        return this.forwardTime;
    }

    /**
     * 服务转发状态
     */
    public String getForwardState(){
        return this.forwardState;
    }

    /**
     * 服务转发失败原因
     */
    public String getForwardFailReason(){
        return this.forwardFailReason;
    }

    /**
     * 服务响应时间
     */
    public Date getResponseTime(){
        return this.responseTime;
    }

    /**
     *
     */
    public String getResponseOriginalHeader(){
        return this.responseOriginalHeader;
    }

    /**
     * 原始响应请求
     */
    public String getResponseOriginalParam(){
        return this.responseOriginalParam;
    }

    /**
     *
     */
    public String getResponseHeader(){
        return this.responseHeader;
    }

    /**
     * 处理后响应请求
     */
    public String getResponseParam(){
        return this.responseParam;
    }

    /**
     * 服务响应状态
     */
    public String getResponseState(){
        return this.responseState;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime(){
        return this.createTime;
    }

}
