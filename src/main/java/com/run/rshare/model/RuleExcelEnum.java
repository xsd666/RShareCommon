package com.run.rshare.model;

/**
 * @ClassName RuleExcelEnum
 * @Description: 规则描述文件枚举
 * @Author xsd
 * @Date 2023/9/2
 * @Version V1.0
 **/
public enum RuleExcelEnum {
    /**
     * 接口规则
     */
    interfaceRule,
    /**
     * 响应规则
     */
    responseRule;

    RuleExcelEnum() {
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
