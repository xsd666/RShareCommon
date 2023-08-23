package com.run.rshare.common.agreement;


/**
 * @author ÖÜ¿­
 * @version 1.0
 * @created 17-7ÔÂ-2023 17:10:33
 */
public class ServiceRequestStandard extends ServiceRequest {

	/**
	 * è¯·æ±‚ä½“å†…çš„å‚æ•°ä¿¡æ?    String msgFrom = null;
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