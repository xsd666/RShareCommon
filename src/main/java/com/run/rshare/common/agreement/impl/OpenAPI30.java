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
 * @author �ܿ�
 * @version 1.0
 * @created 17-7��-2023 17:10:33
 */
@Component("OpenAPI30")
public class OpenAPI30 implements ServiceAgreement {

	public void checkRequireSchema(){

	}

	public void checkResponseSchema(){

	}

	/**
	 * 1��רע��Ƕ�׵ķ���Ĳ���
	 * 
	 * @param id    ��Լ��������
	 */
	public List<FieldInfo> getResponseParam(String id){
		return null;
	}

	public void isValid(){

	}

	/**
	 * 1��רע��Ƕ�׵ķ���Ĳ���
	 * 
	 * @param id    ��Լ�������
	 */
	public List<FieldInfo> getRequestParam(String id){
		return null;
	}

	public void tryRun(){

	}

	/**
	 * �����ɹ��󣬷��ع�Լ���� 1����OpenAPI3.0Ϊ��׼���� 2����׼�ĵ��������������
	 * 
	 * @param serviceConfig    ���ŵķ�������
	 */
	public String createFromServiceConfig(ServiceInfo serviceConfig){
		return "";
	}

	/**
	 * 
	 * @param value    ֵ����
	 */
	public ServiceRequest buildServiceRequest(Map<String,String> value){
		return null;
	}

	/**
	 * 
	 * @param result    ��Ӧ���
	 */
	public ServiceResponse buildServiceResponse(String result){
		return null;
	}

	/**
	 * 
	 * @param req    ������
	 */
	public ServiceRequest buildServiceRequest(HttpServletRequest req){
		return null;
	}

	/**
	 * 
	 * @param resp    ��Ӧ��
	 */
	public ServiceResponse buildServiceResponse(HttpServletResponse resp){
		return null;
	}
}//end OpenAPI30