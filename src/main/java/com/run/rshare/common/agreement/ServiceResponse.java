package com.run.rshare.common.agreement;


import com.alibaba.fastjson.JSONObject;

/**
 * >包含响应头和响应体
 * >保存原始的响应信息
 *
 * @author 周凯
 * @version 1.0
 * @updated 17-7月-2023 17:11:32
 */
public class ServiceResponse {

    String msgStatus = null;

	JSONObject response;

	String msg = "";

	public ServiceResponse() {
	}

	public ServiceResponse(String msgStatus, String msg) {
		this.msgStatus = msgStatus;
		this.msg = msg;
	}

	public String getMsgStatus() {
		return msgStatus;
	}

	public void setMsgStatus(String msgStatus) {
		this.msgStatus = msgStatus;
	}

	public JSONObject getResponse() {
		return response;
	}

	public void setResponse(JSONObject response) {
		this.response = response;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}