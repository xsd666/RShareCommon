package com.run.rshare.common.agreement;


import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpHeaders;

/**
 * >包含请求头和请求体
 * >保存原始的请求信息
 * @author 周凯
 * @version 1.0
 * @updated 17-7月-2023 17:11:32
 */
public class ServiceRequest {
	/**
	 * 请求头
	 */
	private HttpHeaders header;
	/**
	 * 请求方法
	 */
	private String httpMethod;
	/**
	 * 参数信息
	 */
	private JSONObject requestJsonParam;
	/**
	 * 表单参数
	 */
	private String requestFormParam;

	//临时统计信息
	Long timeBegin = 0L;
	Long timeEnd = 0L;

	public HttpHeaders getHeader() {
		return header;
	}

	public void setHeader(HttpHeaders header) {
		this.header = header;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public JSONObject getRequestJsonParam() {
		return requestJsonParam;
	}

	public void setRequestJsonParam(JSONObject requestJsonParam) {
		this.requestJsonParam = requestJsonParam;
	}

	public String getRequestFormParam() {
		return requestFormParam;
	}

	public void setRequestFormParam(String requestFormParam) {
		this.requestFormParam = requestFormParam;
	}

	public Long getTimeBegin() {
		return timeBegin;
	}

	public void setTimeBegin(Long timeBegin) {
		this.timeBegin = timeBegin;
	}

	public Long getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Long timeEnd) {
		this.timeEnd = timeEnd;
	}
}