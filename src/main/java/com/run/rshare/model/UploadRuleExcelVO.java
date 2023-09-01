package com.run.rshare.model;

/**
 * @ClassName UploadRuleExcel
 * @Description: 上传规则文件返回
 * @Author xsd
 * @Date 2023/9/2
 * @Version V1.0
 **/
public class UploadRuleExcelVO {
    /**
     * 规则文件类型
     */
    private String ruleExcelType;
    /**
     * 规约excel存储路径
     */
    private String excelStoreFileName;
    /**
     * 规约json存储路径
     */
    private String jsonStoreFileName;


    public UploadRuleExcelVO() {
    }

    public UploadRuleExcelVO(String ruleExcelType, String excelStoreFileName, String jsonStoreFileName) {
        this.ruleExcelType = ruleExcelType;
        this.excelStoreFileName = excelStoreFileName;
        this.jsonStoreFileName = jsonStoreFileName;
    }

    public String getRuleExcelType() {
        return ruleExcelType;
    }

    public void setRuleExcelType(String ruleExcelType) {
        this.ruleExcelType = ruleExcelType;
    }

    public String getExcelStoreFileName() {
        return excelStoreFileName;
    }

    public void setExcelStoreFileName(String excelStoreFileName) {
        this.excelStoreFileName = excelStoreFileName;
    }

    public String getJsonStoreFileName() {
        return jsonStoreFileName;
    }

    public void setJsonStoreFileName(String jsonStoreFileName) {
        this.jsonStoreFileName = jsonStoreFileName;
    }
}
