package com.run.rshare.common.agreement;

import com.run.rshare.common.agreement.type.FieldInfo;
import com.run.rshare.common.agreement.type.ServiceInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author 周凯
 * @version 1.0
 * @created 17-7月-2023 17:10:33
 */
public interface ServiceAgreement {

	public void checkRequireSchema();

	public void checkResponseSchema();

	/**
	 * 1、专注非嵌套的服务的参数
	 * 
	 * @param id    规约出参内容
	 */
	public List<FieldInfo> getResponseParam(String id);

	public void isValid();

	/**
	 * 1、专注非嵌套的服务的参数
	 * 
	 * @param id    规约入参内容
	 */
	public List<FieldInfo> getRequestParam(String id);

	public void tryRun();

	/**
	 * 创建成功后，返回规约数据 1、以OpenAPI3.0为标准创建 2、标准的单层输入输出参数
	 * 
	 * @param serviceConfig    编排的服务配置
	 */
	public String createFromServiceConfig(ServiceInfo serviceConfig);

	/**
	 * 
	 * @param value    值设置
	 */
	public ServiceRequest buildServiceRequest(Map<String,String> value);

	/**
	 * 
	 * @param result    响应结果
	 */
	public ServiceResponse buildServiceResponse(String result);

	/**
	 * 
	 * @param req    请求体
	 */
	public ServiceRequest buildServiceRequest(HttpServletRequest req);

	/**
	 * 
	 * @param resp    响应体
	 */
	public ServiceResponse buildServiceResponse(HttpServletResponse resp);

}