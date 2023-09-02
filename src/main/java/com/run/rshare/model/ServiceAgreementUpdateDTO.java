package com.run.rshare.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @ClassName ServiceAgreementUpdateDTO
 * @Description: 规约修改
 * @Author xsd
 * @Date 2023/9/2
 * @Version V1.0
 **/
public class ServiceAgreementUpdateDTO {

    /**
     * 主键id
     */
    @NotNull(message = "修改id不能为空")
    @Min(value = 1,message = "id必须大于等于1")
    private Long id;

    /**
     * 服务规约标识符号
     */
    @NotBlank(message = "服务规约标识符号不能为空")
    @Length(max = 50,message = "服务规约标识符号最大长度支持50")
    private String serviceAgreementIdentifier;


    /**
     * 服务规约名称
     */
    @NotBlank(message = "服务规约名称不能为空")
    @Length(max = 100,message = "服务规约名称最大长度支持100")
    private String serviceAgreementName;
    /**
     * 服务规约描述
     */
    @Length(max = 4000,message = "服务规约描述最大长度支持4000")
    private String serviceAgreementDesc;
    /**
     * 服务规约版本号
     */
    @NotBlank(message = "服务规约版本号不能为空")
    @Length(max = 10,message = "服务规约版本号最大长度支持10")
    private String serviceAgreementVersion;
    /**
     * 规约单位代码
     */
    @Length(max = 50,message = "规约单位代码最大长度支持50")
    @NotBlank(message = "规约单位代码不能为空")
    private String serviceAgreementOrg;
    /**
     * 规约单位名称
     */
    @Length(max = 100,message = "规约单位名称最大长度支持100")
    @NotBlank(message = "规约单位名称不能为空")
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
     * 接口定义规则文件名称
     */
    @Length(max = 100,message = "接口定义规则文件名称最大长度支持100")
    @NotBlank(message = "接口定义规则文件名称不能为空")
    private String serviceFileName;
    /**
     * 接口定义规则文件存储位置
     */
    @NotBlank(message = "接口定义规则文件存储位置不能为空")
    private String serviceFileStoreUrl;
    /**
     * 规约json存储位置
     */
    private String serviceFileJsonStoreUrl;
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
    @Length(max = 100,message = "接口响应规则文件名称最大长度支持100")
    @NotBlank(message = "接口响应规则文件名称不能为空")
    private String serviceRespFileName;
    /**
     * 接口响应规则文件存储位置
     */
    @NotBlank(message = "接口响应规则文件存储位置不能为空")
    private String serviceRespFileStoreUrl;
    /**
     * 规约语言
     */
    @Pattern(regexp = "^(WSDL2\\.0|OpenAPI3\\.0)$", message = "只支持 WSDL2.0 或 OpenAPI3.0")
    @NotBlank(message = "规约接口语言不能为空")
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

    public String getServiceFileJsonStoreUrl() {
        return serviceFileJsonStoreUrl;
    }

    public void setServiceFileJsonStoreUrl(String serviceFileJsonStoreUrl) {
        this.serviceFileJsonStoreUrl = serviceFileJsonStoreUrl;
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
}
