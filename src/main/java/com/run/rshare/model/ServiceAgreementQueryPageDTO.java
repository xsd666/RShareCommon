package com.run.rshare.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName ServiceAgreementQueryPageDTO
 * @Description: 规约列表查询参数
 * @Author xsd
 * @Date 2023/8/31
 * @Version V1.0
 **/
public class ServiceAgreementQueryPageDTO extends PageQuery{

    /**
     * 服务规约标识符号
     */
    private String serviceAgreementIdentifier;
    /**
     * 服务规约名称
     */
    private String serviceAgreementName;

    /**
     * 数据接口
     */
    private String dataService;

    /**
     * 规约语言
     */
    private String serviceAgreementLangType;
    /**
     * 创建时间开始
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTimeStart;
    /**
     * 创建时间结束
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTimeEnd;

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

    public String getDataService() {
        return dataService;
    }

    public void setDataService(String dataService) {
        this.dataService = dataService;
    }

    public String getServiceAgreementLangType() {
        return serviceAgreementLangType;
    }

    public void setServiceAgreementLangType(String serviceAgreementLangType) {
        this.serviceAgreementLangType = serviceAgreementLangType;
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

    @Override
    public String toString() {
        return "ServiceAgreementQueryPageDTO{" +
                "serviceAgreementIdentifier='" + serviceAgreementIdentifier + '\'' +
                ", serviceAgreementName='" + serviceAgreementName + '\'' +
                ", dataService='" + dataService + '\'' +
                ", serviceAgreementLangType='" + serviceAgreementLangType + '\'' +
                ", createTimeStart=" + createTimeStart +
                ", createTimeEnd=" + createTimeEnd +
                '}';
    }
}
