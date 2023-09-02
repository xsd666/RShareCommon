package com.run.rshare.service.impl;

import cn.hutool.core.util.IdUtil;
import com.run.rshare.config.SystemBizConfig;
import com.run.rshare.dao.AgreementCounterDao;
import com.run.rshare.entity.AgreementCounter;
import com.run.rshare.service.AgreementCounterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName AgreementCounterServiceImpl
 * @Description: 规约计数器
 * @Author xsd
 * @Date 2023/9/2
 * @Version V1.0
 **/
@Service
public class AgreementCounterServiceImpl implements AgreementCounterService {

    @Resource
    private AgreementCounterDao agreementCounterDao;

    /**
     * 系统业务配置
     */
    @Resource
    private SystemBizConfig systemBizConfig;

    /**
     * 生成规约标识
     *
     * @return
     */
    @Override
    public String generateAgreementIdentifier() {
        AgreementCounter agreementCounter = agreementCounterDao.queryById(1);
        int counter = agreementCounter.getCounter();
        String rulePrefix = agreementCounter.getRulePrefix();
        int substringLength = agreementCounter.getSubstringLength();
        int version = agreementCounter.getVersion();
        int updateCounter = counter + 1;
        while (agreementCounterDao.updateByIdAndVersion(new AgreementCounter(1, updateCounter, version)) < 1) {
            agreementCounter = agreementCounterDao.queryById(1);
            updateCounter = agreementCounter.getCounter() + 1;
            version = agreementCounter.getVersion();
        }
        String agreementIdentifier = rulePrefix + updateCounter;
        int endIndex = agreementIdentifier.length();
        int beginIndex = agreementIdentifier.length() - substringLength;
        String agreementSuffix = agreementIdentifier.substring(beginIndex, endIndex);
        String nextIdStr = IdUtil.getSnowflakeNextIdStr();
        return String.format(systemBizConfig.getAgreementIdentifierTemplate(), nextIdStr, agreementSuffix);
    }
}
