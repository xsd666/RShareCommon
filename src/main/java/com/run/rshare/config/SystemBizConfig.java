package com.run.rshare.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SystemConfig
 * @Description: 系统配置
 * @Author xsd
 * @Date 2023/9/2
 * @Version V1.0
 **/
@Configuration
@ConfigurationProperties(prefix = "biz")
public class SystemBizConfig {

    private String ruleExcelStorePath;

    public String getRuleExcelStorePath() {
        return ruleExcelStorePath;
    }

    public void setRuleExcelStorePath(String ruleExcelStorePath) {
        this.ruleExcelStorePath = ruleExcelStorePath;
    }
}
