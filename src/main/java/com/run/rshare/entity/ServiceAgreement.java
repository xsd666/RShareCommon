package com.run.rshare.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 服务规约(ServiceAgreement)实体类
 *
 * @author makejava
 * @since 2023-08-31 17:57:56
 */
public class ServiceAgreement implements Serializable {
    private static final long serialVersionUID = -62083905679227118L;
    
    private Long id;
    /**
    * 服务规约标识符号
    */
    private String serviceAgreementIdentifier;
    /**
    * 服务规约名称
    */
    private String serviceAgreementName;
    /**
    * 服务规约描述
    */
    private String serviceAgreementDesc;
    /**
    * 服务规约版本号
    */
    private String serviceAgreementVersion;
    /**
    * 规约单位代码
    */
    private String serviceAgreementOrg;
    /**
    * 规约单位名称
    */
    private String serviceAgreementOrgName;
    /**
    * 数据接口代码
    */
    private String dataServiceCode;
    /**
    * 数据接口
    */
    private String dataService;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 接口定义规则文件名称
    */
    private String serviceFileName;
    /**
    * 接口定义规则文件存储位置
    */
    private String serviceFileStoreUrl;
    /**
    * 接口url
    */
    private String serviceInterfaceUrl;
    /**
    * 接口方法,get,post等
    */
    private String serviceInterfaceHttpMethod;
    /**
    * 接口响应规则文件名称
    */
    private String serviceRespFileName;
    /**
    * 接口响应规则文件存储位置
    */
    private String serviceRespFileStoreUrl;
    /**
    * 规约语言
    */
    private String serviceAgreementLangType;
    /**
    * 规约xml
    */
    private String wsdlXml;
    /**
    * 规约json
    */
    private String openApiJson;
    /**
    * 删除标准
    */
    private Integer deleted;

    private Date createTimeStart;

    private Date createTimeEnd;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceAgreementIdentifier() {
        return serviceAgreementIdentifier;
    }

    public void setServiceAgreementIdentifier(String serviceAgreementIdentifier) {
        this.serviceAgreementIdentifier = serviceAgreementIdentifier;
    }

    public String getServiceAgreementName() {
        return serviceAgreementName;
    }

    public void setServiceAgreementName(String serviceAgreementName) {
        this.serviceAgreementName = serviceAgreementName;
    }

    public String getServiceAgreementDesc() {
        return serviceAgreementDesc;
    }

    public void setServiceAgreementDesc(String serviceAgreementDesc) {
        this.serviceAgreementDesc = serviceAgreementDesc;
    }

    public String getServiceAgreementVersion() {
        return serviceAgreementVersion;
    }

    public void setServiceAgreementVersion(String serviceAgreementVersion) {
        this.serviceAgreementVersion = serviceAgreementVersion;
    }

    public String getServiceAgreementOrg() {
        return serviceAgreementOrg;
    }

    public void setServiceAgreementOrg(String serviceAgreementOrg) {
        this.serviceAgreementOrg = serviceAgreementOrg;
    }

    public String getServiceAgreementOrgName() {
        return serviceAgreementOrgName;
    }

    public void setServiceAgreementOrgName(String serviceAgreementOrgName) {
        this.serviceAgreementOrgName = serviceAgreementOrgName;
    }

    public String getDataServiceCode() {
        return dataServiceCode;
    }

    public void setDataServiceCode(String dataServiceCode) {
        this.dataServiceCode = dataServiceCode;
    }

    public String getDataService() {
        return dataService;
    }

    public void setDataService(String dataService) {
        this.dataService = dataService;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getServiceFileName() {
        return serviceFileName;
    }

    public void setServiceFileName(String serviceFileName) {
        this.serviceFileName = serviceFileName;
    }

    public String getServiceFileStoreUrl() {
        return serviceFileStoreUrl;
    }

    public void setServiceFileStoreUrl(String serviceFileStoreUrl) {
        this.serviceFileStoreUrl = serviceFileStoreUrl;
    }

    public String getServiceInterfaceUrl() {
        return serviceInterfaceUrl;
    }

    public void setServiceInterfaceUrl(String serviceInterfaceUrl) {
        this.serviceInterfaceUrl = serviceInterfaceUrl;
    }

    public String getServiceInterfaceHttpMethod() {
        return serviceInterfaceHttpMethod;
    }

    public void setServiceInterfaceHttpMethod(String serviceInterfaceHttpMethod) {
        this.serviceInterfaceHttpMethod = serviceInterfaceHttpMethod;
    }

    public String getServiceRespFileName() {
        return serviceRespFileName;
    }

    public void setServiceRespFileName(String serviceRespFileName) {
        this.serviceRespFileName = serviceRespFileName;
    }

    public String getServiceRespFileStoreUrl() {
        return serviceRespFileStoreUrl;
    }

    public void setServiceRespFileStoreUrl(String serviceRespFileStoreUrl) {
        this.serviceRespFileStoreUrl = serviceRespFileStoreUrl;
    }

    public String getServiceAgreementLangType() {
        return serviceAgreementLangType;
    }

    public void setServiceAgreementLangType(String serviceAgreementLangType) {
        this.serviceAgreementLangType = serviceAgreementLangType;
    }

    public String getWsdlXml() {
        return wsdlXml;
    }

    public void setWsdlXml(String wsdlXml) {
        this.wsdlXml = wsdlXml;
    }

    public String getOpenApiJson() {
        return openApiJson;
    }

    public void setOpenApiJson(String openApiJson) {
        this.openApiJson = openApiJson;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
}