package com.run.rshare.common.agreement;


import javax.servlet.http.HttpServletRequest;

/**
 * >��������ͷ��������
 * >����ԭʼ��������Ϣ
 * @author �ܿ�
 * @version 1.0
 * @updated 17-7��-2023 17:11:32
 */
public class ServiceRequest {

	ServiceAgreement agreemnet = null;
	HttpServletRequest httpServletRequest = null;
	/**
	 * 临时统计信息
	 */
	Long timeBegin = 0L;
	Long timeEnd = 0L;

	public ServiceRequest(){

	}

	public void finalize() throws Throwable {

	}
}//end ServiceRequest