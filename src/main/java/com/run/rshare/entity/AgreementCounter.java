package com.run.rshare.entity;

import java.io.Serializable;

/**
 * 规约标识计数表(AgreementCounter)实体类
 *
 * @author makejava
 * @since 2023-09-02 11:34:58
 */
public class AgreementCounter implements Serializable {
    private static final long serialVersionUID = 880837229829568517L;

    private Integer id;
    /**
     * 规则前缀
     */
    private String rulePrefix;
    /**
     * 计数器
     */
    private Integer counter;
    /**
     * 从后面开始截取多少长度
     */
    private Integer substringLength;
    /**
     * 版本号
     */
    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRulePrefix() {
        return rulePrefix;
    }

    public void setRulePrefix(String rulePrefix) {
        this.rulePrefix = rulePrefix;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Integer getSubstringLength() {
        return substringLength;
    }

    public void setSubstringLength(Integer substringLength) {
        this.substringLength = substringLength;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public AgreementCounter() {
    }

    public AgreementCounter(Integer id, Integer counter, Integer version) {
        this.id = id;
        this.counter = counter;
        this.version = version;
    }
}
