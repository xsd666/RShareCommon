package com.run.rshare.common.statics.type;


import java.util.List;

/**
 * @author 周凯
 * @version 1.0
 * @created 06-7月-2023 11:45:08
 */
public class StaticsInfo {

	private int defaultSavePeriod = 30;
	private boolean defaultSaveResponse = false;
	private List<String> saveResponse = null;

	public StaticsInfo(){

	}

	public void finalize() throws Throwable {

	}
}//end StaticsInfo