package com.run.rshare.common.agreement.type;

//import com.run.rshare.entity.service_resource;

import java.util.List;

/**
 * @author 周凯
 * @version 1.0
 * @created 17-7月-2023 17:10:34
 */
public class SubServiceInfo {

	//private service_resource service;
	private String limit;
	private List<FieldInfo> input;
	private List<FieldInfo> output;
	private String timeout;

	public SubServiceInfo(){

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}
}//end SubServiceInfo