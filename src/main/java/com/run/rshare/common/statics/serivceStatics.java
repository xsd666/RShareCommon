package com.run.rshare.common.statics;

import com.run.rshare.common.statics.type.StaticsInfo;
//import com.run.rshare.entity.gw_request_logs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.ObjectMessage;
import java.util.List;

/**
 * @author �ܿ�
 * @version 1.0
 * @created 06-7��-2023 11:09:21
 */
@Component
public class serivceStatics {

	private StaticsInfo config;

	public serivceStatics(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * ֧����������
	 *
	 * @param log    ��־�б�
	 */
	//@JmsListener(destination = "${spring.activemq.topic}")
	public void requestLogListener(ObjectMessage log){
		System.out.println("aaa");
	}

	/**
	 * TODO:��Ҫ��ȷ����Ҫ�����ά�ȺͲ���ķ�����
	 * 
	 * @param log    ��־
	 */
//	public void supplementaryDimension(gw_request_logs log){
//
//	}

	public boolean cleanOldRequestLog(){
		return false;
	}

	/**
	 * ֧����������
	 * 
	 * @param logs    ��־�б�
	 */
//	public void requestLogListener(List<gw_request_logs> logs){
//
//	}
}//end serivceStatics