package com.run.rshare.common.agreement.type;

//import com.run.rshare.entity.sjzy_field;

/**
 * @author 周凯
 * @version 1.0
 * @created 17-7月-2023 17:10:32
 */
public class FieldInfo {

	/**
	 * 1、自定义参数 2、调用方提供 3、服务参数
	 */
	private String type;
	private String value;
	private String serviceResource;
	//private SjzyField inputParam;
	private String CNName;
	private String ENName;

	public FieldInfo(){

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}
}//end FieldInfo