package com.run.rshare.common.agreement.document;

/**
 * @ClassName RSharePath
 * @Description: 需要取的参数对应的jsonpath
 * @Author xsd
 * @Date 2023/8/26
 * @Version V1.0
 **/
public class RSharePath {

    private String position;

    private String type;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RSharePath() {
    }

    public RSharePath(String position, String type) {
        this.position = position;
        this.type = type;
    }
}
