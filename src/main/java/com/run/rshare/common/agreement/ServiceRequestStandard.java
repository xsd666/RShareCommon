package com.run.rshare.common.agreement;


/**
 * @author �ܿ�
 * @version 1.0
 * @created 17-7��-2023 17:10:33
 */
public class ServiceRequestStandard extends ServiceRequest {

	/**
	 * 请求体内的参数信�?    String msgFrom = null;
	 */
	String msgTo = null;
	String msgSequence = null;
	Long timeQueryCountBefore = 0L;
	Long timeQueryCountAfter = 0L;
	Long timeQueryDataBefore = 0L;
	Long timeQueryDataAfter = 0L;

	public ServiceRequestStandard(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}//end ServiceRequestStandard