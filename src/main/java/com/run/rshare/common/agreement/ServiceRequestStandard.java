package com.run.rshare.common.agreement;


/**
 * @author 周凯
 * @version 1.0
 * @created 17-7月-2023 17:10:33
 */
public class ServiceRequestStandard extends ServiceRequest {

	/**
	 * 璇锋眰浣撳唴鐨勫弬鏁颁俊鎭?    String msgFrom = null;
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