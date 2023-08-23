package com.run.rshare.common.agreement.impl;

import com.run.rshare.common.agreement.type.FieldInfo;
import com.run.rshare.common.agreement.type.ServiceInfo;
import com.run.rshare.common.agreement.ServiceRequest;
import com.run.rshare.common.agreement.ServiceResponse;
import com.run.rshare.common.agreement.ServiceAgreement;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author 周凯
 * @version 1.0
 * @created 17-7月-2023 17:10:33
 */
@Component("OpenAPI30")
public class OpenAPI30 implements ServiceAgreement {

	@Override
	public void checkRequireSchema(){

	}

	@Override
	public void checkResponseSchema(){

	}

	/**
	 * 1、专注非嵌套的服务的参数
	 * 
	 * @param id    规约出参内容
	 */
	@Override
	public List<FieldInfo> getResponseParam(String id){
		return null;
	}

	@Override
	public void isValid(){

	}

	/**
	 * 1、专注非嵌套的服务的参数
	 * 
	 * @param id    规约入参内容
	 */
	@Override
	public List<FieldInfo> getRequestParam(String id){
		return null;
	}

	@Override
	public void tryRun(){

	}

	/**
	 * 创建成功后，返回规约数据 1、以OpenAPI3.0为标准创建 2、标准的单层输入输出参数
	 * 
	 * @param serviceConfig    编排的服务配置
	 */
	@Override
	public String createFromServiceConfig(ServiceInfo serviceConfig){
		return "";
	}

	/**
	 * 
	 * @param value    值设置
	 */
	@Override
	public ServiceRequest buildServiceRequest(Map<String,String> value){
		return null;
	}

	/**
	 * 
	 * @param result    响应结果
	 */
	@Override
	public ServiceResponse buildServiceResponse(String result){
		return null;
	}

	/**
	 * 
	 * @param req    请求体
	 */
	@Override
	public ServiceRequest buildServiceRequest(HttpServletRequest req){
		return null;
	}

	/**
	 * 
	 * @param resp    响应体
	 */
	@Override
	public ServiceResponse buildServiceResponse(HttpServletResponse resp){
		return null;
	}
}