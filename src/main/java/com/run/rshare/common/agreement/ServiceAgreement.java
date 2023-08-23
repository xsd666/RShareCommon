package com.run.rshare.common.agreement;

import com.run.rshare.common.agreement.type.FieldInfo;
import com.run.rshare.common.agreement.type.ServiceInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author �ܿ�
 * @version 1.0
 * @created 17-7��-2023 17:10:33
 */
public interface ServiceAgreement {

	public void checkRequireSchema();

	public void checkResponseSchema();

	/**
	 * 1��רע��Ƕ�׵ķ���Ĳ���
	 * 
	 * @param id    ��Լ��������
	 */
	public List<FieldInfo> getResponseParam(String id);

	public void isValid();

	/**
	 * 1��רע��Ƕ�׵ķ���Ĳ���
	 * 
	 * @param id    ��Լ�������
	 */
	public List<FieldInfo> getRequestParam(String id);

	public void tryRun();

	/**
	 * �����ɹ��󣬷��ع�Լ���� 1����OpenAPI3.0Ϊ��׼���� 2����׼�ĵ��������������
	 * 
	 * @param serviceConfig    ���ŵķ�������
	 */
	public String createFromServiceConfig(ServiceInfo serviceConfig);

	/**
	 * 
	 * @param value    ֵ����
	 */
	public ServiceRequest buildServiceRequest(Map<String,String> value);

	/**
	 * 
	 * @param result    ��Ӧ���
	 */
	public ServiceResponse buildServiceResponse(String result);

	/**
	 * 
	 * @param req    ������
	 */
	public ServiceRequest buildServiceRequest(HttpServletRequest req);

	/**
	 * 
	 * @param resp    ��Ӧ��
	 */
	public ServiceResponse buildServiceResponse(HttpServletResponse resp);

}