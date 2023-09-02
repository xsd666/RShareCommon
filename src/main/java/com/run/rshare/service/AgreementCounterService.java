package com.run.rshare.service;

/**
 * @ClassName AgreementCounterService
 * @Description: 规约标识计数器
 * @Author xsd
 * @Date 2023/9/2
 * @Version V1.0
 **/
public interface AgreementCounterService {
    /**
     * 生成规约标识
     * @return
     */
    String generateAgreementIdentifier();
}
