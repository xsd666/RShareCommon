package com.run.rshare.common.statics;

import com.run.rshare.common.statics.type.StaticsInfo;
//import com.run.rshare.entity.gw_request_logs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.ObjectMessage;
import java.util.List;

/**
 * @author 周凯
 * @version 1.0
 * @created 06-7月-2023 11:09:21
 */
@Component
public class serivceStatics {

	private StaticsInfo config;

	public serivceStatics(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 支持批量处理
	 *
	 * @param log    日志列表
	 */
	//@JmsListener(destination = "${spring.activemq.topic}")
	public void requestLogListener(ObjectMessage log){
		System.out.println("aaa");
	}

	/**
	 * TODO:需要明确具体要补充的维度和补充的方法。
	 *
	 * @param log    日志
	 */
//	public void supplementaryDimension(gw_request_logs log){
//
//	}

	public boolean cleanOldRequestLog(){
		return false;
	}

	/**
	 * 支持批量处理
	 *
	 * @param logs    日志列表
	 */
//	public void requestLogListener(List<gw_request_logs> logs){
//
//	}
}//end serivceStatics