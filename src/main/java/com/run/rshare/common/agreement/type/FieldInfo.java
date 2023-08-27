package com.run.rshare.common.agreement.type;

/**
 * @author 周凯
 * @version 1.0
 * @created 17-7月-2023 17:10:32
 */
public class FieldInfo {

	private String type ="string";
	private String value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public FieldInfo() {
	}

	public FieldInfo(String type, String value) {
		this.type = type;
		this.value = value;
	}
}