package com.run.rshare.common.agreement.type;


import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author �ܿ�
 * @version 1.0
 * @created 17-7��-2023 17:10:33
 */
public class ServiceInfo {

	private List<SubServiceInfo> services;
	private List<FieldInfo> input;
	private List<FieldInfo> output;
	private JSONObject createor;

	public ServiceInfo(){

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}
}//end ServiceInfo