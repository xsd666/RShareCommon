package com.run.rshare.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* ����������־��
* @TableName gw_request_logs
*/
public class gw_request_logs implements Serializable {

    /**
    * ��ID,����
    */
    @NotBlank(message="[��ID,����]不能为空")
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("��ID,����")
    @Length(max= 64,message="编码长度不能超过64")
    public String id;
    /**
    * �û�ID
    */
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("�û�ID")
    @Length(max= 100,message="编码长度不能超过100")
    public String userId;
    /**
    * Ӧ��ID
    */
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("Ӧ��ID")
    @Length(max= 100,message="编码长度不能超过100")
    public String appId;
    /**
    * ������Դ��ʶ
    */
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("������Դ��ʶ")
    @Length(max= 100,message="编码长度不能超过100")
    public String serviceId;
    /**
    * ����IP
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("����IP")
    @Length(max= 255,message="编码长度不能超过255")
    public String requestIp;
    /**
    * �����ַ
    */
    @Size(max= 500,message="编码长度不能超过500")
    @ApiModelProperty("�����ַ")
    @Length(max= 500,message="编码长度不能超过500")
    public String requestUrl;
    /**
    * ��������ʱ��
    */
    @ApiModelProperty("��������ʱ��")
    public Date requestTime;
    /**
    * ����ʽ
    */
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("����ʽ")
    @Length(max= 64,message="编码长度不能超过64")
    public String requestMethod;
    /**
    * 
    */
    @Size(max= 50,message="编码长度不能超过50")
    @ApiModelProperty("")
    @Length(max= 50,message="编码长度不能超过50")
    public String requestOriginalHeader;
    /**
    * ԭʼ�������
    */
    @Size(max= -1,message="编码长度不能超过-1")
    @ApiModelProperty("ԭʼ�������")
    @Length(max= -1,message="编码长度不能超过-1")
    public String requestOriginalParam;
    /**
    * ����ͷ����
    */
    @Size(max= -1,message="编码长度不能超过-1")
    @ApiModelProperty("����ͷ����")
    @Length(max= -1,message="编码长度不能超过-1")
    public String requestHeadParam;
    /**
    * ������������
    */
    @Size(max= -1,message="编码长度不能超过-1")
    @ApiModelProperty("������������")
    @Length(max= -1,message="编码长度不能超过-1")
    public String requestParam;
    /**
    * ������ʵ�ַ,����ʵ����ת��ַ
    */
    @Size(max= 500,message="编码长度不能超过500")
    @ApiModelProperty("������ʵ�ַ,����ʵ����ת��ַ")
    @Length(max= 500,message="编码长度不能超过500")
    public String forwardUrl;
    /**
    * ת��ʱ��
    */
    @ApiModelProperty("ת��ʱ��")
    public Date forwardTime;
    /**
    * ����ת��״̬
    */
    @Size(max= 20,message="编码长度不能超过20")
    @ApiModelProperty("����ת��״̬")
    @Length(max= 20,message="编码长度不能超过20")
    public String forwardState;
    /**
    * ����ת��ʧ��ԭ��
    */
    @Size(max= 4000,message="编码长度不能超过4000")
    @ApiModelProperty("����ת��ʧ��ԭ��")
    @Length(max= 4000,message="编码长度不能超过4,000")
    public String forwardFailReason;
    /**
    * ������Ӧʱ��
    */
    @ApiModelProperty("������Ӧʱ��")
    public Date responseTime;
    /**
    * 
    */
    @Size(max= 50,message="编码长度不能超过50")
    @ApiModelProperty("")
    @Length(max= 50,message="编码长度不能超过50")
    public String responseOriginalHeader;
    /**
    * ԭʼ��Ӧ����
    */
    @Size(max= -1,message="编码长度不能超过-1")
    @ApiModelProperty("ԭʼ��Ӧ����")
    @Length(max= -1,message="编码长度不能超过-1")
    public String responseOriginalParam;
    /**
    * 
    */
    @Size(max= 50,message="编码长度不能超过50")
    @ApiModelProperty("")
    @Length(max= 50,message="编码长度不能超过50")
    public String responseHeader;
    /**
    * �������Ӧ����
    */
    @Size(max= -1,message="编码长度不能超过-1")
    @ApiModelProperty("�������Ӧ����")
    @Length(max= -1,message="编码长度不能超过-1")
    public String responseParam;
    /**
    * ������Ӧ״̬
    */
    @Size(max= 20,message="编码长度不能超过20")
    @ApiModelProperty("������Ӧ״̬")
    @Length(max= 20,message="编码长度不能超过20")
    public String responseState;
    /**
    * ����ʱ��
    */
    @ApiModelProperty("����ʱ��")
    public Date createTime;

    /**
    * ��ID,����
    */
    public void setId(String id){
    this.id = id;
    }

    /**
    * �û�ID
    */
    public void setUserId(String userId){
    this.userId = userId;
    }

    /**
    * Ӧ��ID
    */
    public void setAppId(String appId){
    this.appId = appId;
    }

    /**
    * ������Դ��ʶ
    */
    public void setServiceId(String serviceId){
    this.serviceId = serviceId;
    }

    /**
    * ����IP
    */
    public void setRequestIp(String requestIp){
    this.requestIp = requestIp;
    }

    /**
    * �����ַ
    */
    public void setRequestUrl(String requestUrl){
    this.requestUrl = requestUrl;
    }

    /**
    * ��������ʱ��
    */
    public void setRequestTime(Date requestTime){
    this.requestTime = requestTime;
    }

    /**
    * ����ʽ
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
    * ԭʼ�������
    */
    public void setRequestOriginalParam(String requestOriginalParam){
    this.requestOriginalParam = requestOriginalParam;
    }

    /**
    * ����ͷ����
    */
    public void setRequestHeadParam(String requestHeadParam){
    this.requestHeadParam = requestHeadParam;
    }

    /**
    * ������������
    */
    public void setRequestParam(String requestParam){
    this.requestParam = requestParam;
    }

    /**
    * ������ʵ�ַ,����ʵ����ת��ַ
    */
    public void setForwardUrl(String forwardUrl){
    this.forwardUrl = forwardUrl;
    }

    /**
    * ת��ʱ��
    */
    public void setForwardTime(Date forwardTime){
    this.forwardTime = forwardTime;
    }

    /**
    * ����ת��״̬
    */
    public void setForwardState(String forwardState){
    this.forwardState = forwardState;
    }

    /**
    * ����ת��ʧ��ԭ��
    */
    public void setForwardFailReason(String forwardFailReason){
    this.forwardFailReason = forwardFailReason;
    }

    /**
    * ������Ӧʱ��
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
    * ԭʼ��Ӧ����
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
    * �������Ӧ����
    */
    public void setResponseParam(String responseParam){
    this.responseParam = responseParam;
    }

    /**
    * ������Ӧ״̬
    */
    public void setResponseState(String responseState){
    this.responseState = responseState;
    }

    /**
    * ����ʱ��
    */
    public void setCreateTime(Date createTime){
    this.createTime = createTime;
    }


    /**
    * ��ID,����
    */
    public String getId(){
    return this.id;
    }

    /**
    * �û�ID
    */
    public String getUserId(){
    return this.userId;
    }

    /**
    * Ӧ��ID
    */
    public String getAppId(){
    return this.appId;
    }

    /**
    * ������Դ��ʶ
    */
    public String getServiceId(){
    return this.serviceId;
    }

    /**
    * ����IP
    */
    public String getRequestIp(){
    return this.requestIp;
    }

    /**
    * �����ַ
    */
    public String getRequestUrl(){
    return this.requestUrl;
    }

    /**
    * ��������ʱ��
    */
    public Date getRequestTime(){
    return this.requestTime;
    }

    /**
    * ����ʽ
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
    * ԭʼ�������
    */
    public String getRequestOriginalParam(){
    return this.requestOriginalParam;
    }

    /**
    * ����ͷ����
    */
    public String getRequestHeadParam(){
    return this.requestHeadParam;
    }

    /**
    * ������������
    */
    public String getRequestParam(){
    return this.requestParam;
    }

    /**
    * ������ʵ�ַ,����ʵ����ת��ַ
    */
    public String getForwardUrl(){
    return this.forwardUrl;
    }

    /**
    * ת��ʱ��
    */
    public Date getForwardTime(){
    return this.forwardTime;
    }

    /**
    * ����ת��״̬
    */
    public String getForwardState(){
    return this.forwardState;
    }

    /**
    * ����ת��ʧ��ԭ��
    */
    public String getForwardFailReason(){
    return this.forwardFailReason;
    }

    /**
    * ������Ӧʱ��
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
    * ԭʼ��Ӧ����
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
    * �������Ӧ����
    */
    public String getResponseParam(){
    return this.responseParam;
    }

    /**
    * ������Ӧ״̬
    */
    public String getResponseState(){
    return this.responseState;
    }

    /**
    * ����ʱ��
    */
    public Date getCreateTime(){
    return this.createTime;
    }

}
