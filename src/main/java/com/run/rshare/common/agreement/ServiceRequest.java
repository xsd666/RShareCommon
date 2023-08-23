package com.run.rshare.common.agreement;


import javax.servlet.http.HttpServletRequest;

/**
 * >包含请求头和请求体
 * >保存原始的请求信息
 * @author 周凯
 * @version 1.0
 * @updated 17-7月-2023 17:11:32
 */
public class ServiceRequest {

	ServiceAgreement agreemnet = null;
	HttpServletRequest httpServletRequest = null;
	/**
	 * 涓存椂缁熻淇℃伅
	 */
	Long timeBegin = 0L;
	Long timeEnd = 0L;

	public ServiceRequest(){

	}

	public void finalize() throws Throwable {

	}
}//end ServiceRequest