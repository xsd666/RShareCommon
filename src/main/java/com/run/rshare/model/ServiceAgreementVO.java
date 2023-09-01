package com.run.rshare.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ClassName ServiceAgreementVO
 * @Description: 服务规约
 * @Author xsd
 * @Date 2023/8/31
 * @Version V1.0
 **/
public class ServiceAgreementVO {
    /**
     * 主键id
     */
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 接口定义规则文件名称
     */
    private String serviceFileName;
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
     * 规约语言
     */
    private String serviceAgreementLangType;

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

    public String getServiceAgreementLangType() {
        return serviceAgreementLangType;
    }

    public void setServiceAgreementLangType(String serviceAgreementLangType) {
        this.serviceAgreementLangType = serviceAgreementLangType;
    }
}
