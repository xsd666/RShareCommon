package com.run.rshare.common.utils;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>请求和响应参数生成器</p>
 * @author hexing
 *
 */
public class ReqAndRespUtil {

	public static JSONObject externalRegFile(String filename) {
		JSONObject result = new JSONObject(true);
		result.put("code", "200");
		result.put("msg", "ok");
		JSONObject reqAndRespData = new JSONObject(true);
		result.put("data", reqAndRespData);
		try {
			FileReader file = new FileReader(filename);
			//请求头说明
			ExcelReader reader = cn.hutool.poi.excel.ExcelUtil.getReader(file.getInputStream());
			//Sheet校验
			if(!validSheet(reader.getSheetNames())) {
				result.put("code", "500");
				result.put("msg", "上传的Excel文件不是标准的服务注册模板文件，请重新上传！");
				return result;
			}
			JSONArray reqHeaders = (JSONArray) JSON.toJSON(reader.setSheet(0).readAll());
			if(reqHeaders.size() > 0) {
				reqHeaders.stream().forEach(r -> {
					((JSONObject) r).put("desc", ((JSONObject) r).getString("请求头说明"));
				});
				Map<String, String> changeKeysMap = new HashMap<>();
				changeKeysMap.put("请求头名称", "arg");
				changeKeysMap.put("请求头说明", "name");
				changeKeysMap.put("数据类型", "type");
				changeKeysMap.put("是否必填", "required");
				changeKeysMap.put("默认值", "defaultValue");
				result.getJSONObject("data").put("service_req_headers", buildReqHeadersDef().fluentAddAll((JSONArray) removeOrRetainKeys(changeJsonArrayKeys(reqHeaders, changeKeysMap), true, "序号")));
			}else {
				result.getJSONObject("data").put("service_req_headers", buildReqHeadersDef());
			}
			//请求参数说明
			JSONArray reqArgs = (JSONArray) JSON.toJSON(reader.setSheet(1).readAll());
			if(reqArgs.size() > 0) {
				Map<String, String> changeKeysMap = new HashMap<>();
				changeKeysMap.put("参数名称", "arg");
				changeKeysMap.put("父级名称", "pArg");
				changeKeysMap.put("数据类型", "type");
				changeKeysMap.put("是否必填", "required");
				changeKeysMap.put("参数说明", "desc");
				changeKeysMap.put("path", "path");
				changeKeysMap.put("pathType", "pathType");
				changeKeysMap.put("默认值", "defaultValue");
				result.getJSONObject("data").put("service_req_args", removeOrRetainKeys(changeJsonArrayKeys(reqArgs, changeKeysMap), true, "序号"));
			}else {
				result.getJSONObject("data").put("service_req_args", new JSONArray());
			}
			//响应头说明
			JSONArray respHeaders = (JSONArray) JSON.toJSON(reader.setSheet(2).readAll());
			if(respHeaders.size() > 0) {
				respHeaders.stream().forEach(r -> {
					((JSONObject) r).put("desc", ((JSONObject) r).getString("响应头说明"));
				});
				Map<String, String> changeKeysMap = new HashMap<>();
				changeKeysMap.put("响应头名称", "arg");
				changeKeysMap.put("响应头说明", "name");
				changeKeysMap.put("数据类型", "type");
				changeKeysMap.put("默认值", "defaultValue");
				result.getJSONObject("data").put("service_resp_headers", ReqAndRespUtil.buildRespHeadersDef().fluentAddAll((JSONArray) removeOrRetainKeys(changeJsonArrayKeys(respHeaders, changeKeysMap), true, "序号")));
			}else {
				result.getJSONObject("data").put("service_resp_headers", ReqAndRespUtil.buildRespHeadersDef());
			}
			//响应参数说明
			JSONArray respArgs = (JSONArray) JSON.toJSON(reader.setSheet(3).readAll());
			if(respArgs.size() > 0) {
				Map<String, String> changeKeysMap = new HashMap<>();
				changeKeysMap.put("参数名称", "arg");
				changeKeysMap.put("父级名称", "pArg");
				changeKeysMap.put("数据类型", "type");
				changeKeysMap.put("参数说明", "desc");
				changeKeysMap.put("path", "path");
				changeKeysMap.put("pathType", "pathType");
				changeKeysMap.put("默认值", "defaultValue");
				result.getJSONObject("data").put("service_resp_args", removeOrRetainKeys(changeJsonArrayKeys(respArgs, changeKeysMap), true, "序号"));
			}else {
				result.getJSONObject("data").put("service_resp_args", new JSONArray());
			}
			//响应码说明
			JSONArray respCode = (JSONArray) JSON.toJSON(reader.setSheet(4).readAll());
			if(respCode.size() > 0) {
				Map<String, String> changeKeysMap = new HashMap<>();
				changeKeysMap.put("状态码", "code");
				changeKeysMap.put("状态码描述", "desc");
				result.getJSONObject("data").put("service_resp_code", removeOrRetainKeys(changeJsonArrayKeys(respCode, changeKeysMap), true, "序号"));
			}else {
				result.getJSONObject("data").put("service_resp_code", new JSONArray());
			}
			//请求响应示例
			JSONArray reqAndRespSample = (JSONArray) JSON.toJSON(reader.setSheet(5).readAll());
			if(reqAndRespSample.size() > 0) {
				JSONObject service_req_sample = new JSONObject(true);
				JSONObject reqHeader = new JSONObject();
				try {
					String reqHeaderString = reqAndRespSample.getJSONObject(0).getString("请求头示例");
					reqHeader = JSONObject.parseObject(StrUtil.isNotBlank(reqHeaderString) ? reqHeaderString : "{}");
				} catch (Exception e) {
					e.printStackTrace();
				}
				service_req_sample.put("header", reqHeader);
				//KK-0621-4.1： 去掉JSON判断，兼容GET模式
				JSONObject reqBody = new JSONObject();
				try {
					String reqBodyString = reqAndRespSample.getJSONObject(0).getString("请求体示例");
					String trimString = reqBodyString.trim();
					if(trimString.startsWith("{") && trimString.endsWith("}")) {
						//POST对象模式
						reqBody = JSONObject.parseObject(trimString);
						service_req_sample.put("body", reqBody);
					}else{
						//GET内容模式
						service_req_sample.put("body", trimString);
					}

				} catch (Exception e) {
					service_req_sample.put("body", reqBody);
					e.printStackTrace();
				}
				result.getJSONObject("data").put("service_req_sample", service_req_sample);
				JSONObject service_resp_sample = new JSONObject(true);
				JSONObject respHeader = new JSONObject();
				try {
					String respHeaderString = reqAndRespSample.getJSONObject(0).getString("响应头示例");
					respHeader = JSONObject.parseObject(StrUtil.isNotBlank(respHeaderString) ? respHeaderString : "{}");
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				service_resp_sample.put("header", respHeader);
				JSONObject respBody = new JSONObject();
				try {
					String respBodyString = reqAndRespSample.getJSONObject(0).getString("响应体示例");
					respBody = JSONObject.parseObject(StrUtil.isNotBlank(respBodyString) ? respBodyString : "{}");
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				service_resp_sample.put("body", respBody);
				result.getJSONObject("data").put("service_resp_sample", service_resp_sample);
			}else {
				result.getJSONObject("data").put("service_req_sample", new JSONObject());
				result.getJSONObject("data").put("service_resp_sample", new JSONObject());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	/**
	 * <p>构建Header</p>
	 * @param arg
	 * @param name
	 * @param desc
	 * @param type
	 * @param required
	 * @return
	 */
	private static JSONObject buildHeader(String arg, String name, String desc, String type, String required) {
		JSONObject header = new JSONObject(true);
		header.put("arg", arg);
		header.put("name", name);
		header.put("desc", desc);
		header.put("type", type);
		if(StrUtil.isNotBlank(required)){
			header.put("required", required);
		}
		return header;
	}

	/**
	 * <p>构建公共的请求头描述信息</p>
	 * @return
	 */
	public static JSONArray buildReqHeadersDef() {
		JSONArray jsonArray = new JSONArray();
		//jsonArray.add(buildHeader("Content-Type", "内容类型", "内容类型", "string", "1"));
		//jsonArray.add(buildHeader("SenderID", "应用ID", "应用ID", "string", "1"));
		//jsonArray.add(buildHeader("ServiceResourceId", "服务资源ID", "服务资源ID", "string", "1"));
		//jsonArray.add(buildHeader("UserID", "用户ID", "用户ID", "string", "1"));
		return jsonArray;
	}

	private static final String[] validSheetNames = {"请求头说明", "请求参数说明", "响应头说明", "响应参数说明", "响应码说明", "请求响应示例说明"};

	/**
	 * 校验Sheet
	 * @param sheetNames
	 * @return
	 */
	public static boolean validSheet(List<String> sheetNames) {
		boolean flag = true;
		if(Objects.isNull(sheetNames) || sheetNames.isEmpty() || sheetNames.size() != 6) flag = false;
		for(int i = 0; i < sheetNames.size(); i++) {
			if(!sheetNames.get(i).equalsIgnoreCase(validSheetNames[i])) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	public static JSON removeOrRetainKeys(JSON json, boolean isRemove, String...keys) {
		if(Objects.isNull(keys) || keys.length < 1) return json;
		if(json instanceof JSONArray) {
			JSONArray arrays = (JSONArray) json;
			for(int i = 0; i < arrays.size(); i++) {
				JSONObject json_ = arrays.getJSONObject(i);
				for(String key: ((JSONObject) json_.clone()).keySet()) {
					if(isRemove == Arrays.asList(keys).contains(key)) json_.remove(key);
				}
			}
			return arrays;
		}
		if(json instanceof JSONObject) {
			JSONObject json_ = (JSONObject) json;
			for(String key: ((JSONObject) json_.clone()).keySet()) {
				if(isRemove == Arrays.asList(keys).contains(key)) json_.remove(key);
			}
			return json_;
		}
		return json;
	}

	public static JSONObject changeJsonObjectKeys(JSONObject jsonObject, Map<String, String> changeKeysMap) {
		JSONObject resJson = new JSONObject(true);
		Set<String> keySet = jsonObject.keySet();
		for (String key : keySet) {
			String resKey = changeKeysMap.get(key) == null ? key : changeKeysMap.get(key);
			try {
				if (jsonObject.get(key) instanceof JSONObject) {
					JSONObject jsonobj1 = (JSONObject) jsonObject.get(key);
					resJson.put(resKey, changeJsonObjectKeys(jsonobj1, changeKeysMap));
				} else if (jsonObject.get(key) instanceof JSONArray) {
					JSONArray jsonArr = (JSONArray) jsonObject.get(key);
					resJson.put(resKey, changeJsonArrayKeys(jsonArr, changeKeysMap));
				}else {
					resJson.put(resKey, jsonObject.get(key));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resJson;
	}

	public static JSONArray changeJsonArrayKeys(JSONArray jsonArray, Map<String, String> changeKeysMap) {
		JSONArray resJson = new JSONArray();
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			resJson.add(changeJsonObjectKeys(jsonObj, changeKeysMap));
		}
		return resJson;
	}
	/**
	 * <p>构建公共的请求头样例数据</p>
	 * @param senderId
	 * @param ServiceResourceId
	 * @param UserID
	 * @return
	 */
	public static JSONObject buildReqHeadersSample(String senderId, String ServiceResourceId, String UserID) {
		JSONObject headerObject = new JSONObject(true);
		headerObject.put("Content-Type", "application/json");
		headerObject.put("SenderID", senderId);
		headerObject.put("ServiceResourceId", ServiceResourceId);
		headerObject.put("UserID", UserID);
		return headerObject;
	}

	/**
	 * <p>构建公共的请求体样例数据</p>
	 * @return
	 */
	public static JSONObject buildPostReqBodySample(String type, String dataResourceName, JSONArray reqArgs, JSONArray respArgs) {
		JSONObject bodyObject = new JSONObject(true);
		bodyObject.put("From", "370000000001");
		bodyObject.put("To", "110000000001");
		bodyObject.put("MessageSequence", new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + (int)(Math.random() * 90 + 10));
		JSONObject RequestParam = new JSONObject(true);
		StringBuffer Condition = new StringBuffer();
		reqArgs.forEach(o_ -> {
			JSONObject o = (JSONObject) o_;
			if(StrUtil.isNotBlank(o.getString("value"))) {
				Condition.append(" and " + o.getString("arg") + "='" + o.getString("value") + "'");
			}
		});
		//RequestParam参数试运行时，判定服务仅传递一项KEY1即可，查询服务和下载服务需要Condition、ResourceInfos、OtherCondition三项
		if("11".equals(type)) {
			RequestParam.put("KEY1", Condition.length() > 0 ? Condition.toString().substring(5) : "");
		}else {
			RequestParam.put("Condition", Condition.length() > 0 ? Condition.toString().substring(5) : "");
			JSONArray ResourceInfos = new JSONArray();
			JSONObject ResourceInfo = new JSONObject(true);
			ResourceInfo.put("ResourceName", dataResourceName);
			JSONArray DataItems = respArgs;
			DataItems.forEach(o_ -> {
				JSONObject o = (JSONObject) o_;
				o.put("Name", o.getString("arg"));
				o.put("Fmt", "");
			});
			ResourceInfo.put("DataItems", removeOrRetainKeys(DataItems, false, "Name", "Fmt"));
			ResourceInfos.add(ResourceInfo);
			RequestParam.put("ResourceInfos", ResourceInfos);
			JSONObject OtherCondition = new JSONObject(true);
			OtherCondition.put("PageSize", 10);
			OtherCondition.put("CurrentPage", 1);
			//数据下载服务试运行的回调地址
			if("4".equals(type)){
				OtherCondition.put("CallbackID", "http://192.168.15.56:9090/service/TrialRunController/downloadCallback");
			}
			RequestParam.put("OtherCondition", OtherCondition);
		}
		bodyObject.put("RequestParam", RequestParam);
		return bodyObject;
	}

	/**
	 * <p>构建公共的响应头描述信息</p>
	 * @return
	 */
	public static JSONArray buildRespHeadersDef() {
		JSONArray jsonArray = new JSONArray();
		return jsonArray;
	}

	/**
	 * <p>构建公共的响应头样例数据</p>
	 * @return
	 */
	public static JSONObject buildRespHeadersSample() {
		JSONObject headerObject = new JSONObject(true);
		return headerObject;
	}

	/**
	 * <p>构建公共的响应体样例数据</p>
	 * @return
	 */
	public static JSONObject buildRespBodySample(String type, String dataResourceName, JSONArray respArgs) {
		JSONObject bodyObject = new JSONObject(true);
		bodyObject.put("MessageStatus", "0200");
		bodyObject.put("Remark", "正常");
		bodyObject.put("MessageSequence", new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + (int)(Math.random() * 90 + 10));
		JSONObject ResponseParam = new JSONObject(true);
		switch (type) {
			case "4":
				bodyObject.clear();
				bodyObject.put("status", "0200");
				bodyObject.put("taskId", "trial_370000000000000002021101712345");
				bodyObject.put("filePath", "/home/ftp/trial_370000000000000002021101712345");
				bodyObject.put("username", "runtest");
				bodyObject.put("password", "12345");
				bodyObject.put("total", "15");
				break;
			case "11":
				ResponseParam.put("KEY1", "true");
				bodyObject.put("ResponseParam", ResponseParam);
				break;
			default:
				JSONArray ResourceInfos = new JSONArray();
				JSONObject ResourceInfo = new JSONObject(true);
				ResourceInfo.put("ResourceName", dataResourceName);
				JSONArray DataItems = respArgs;
				DataItems.forEach(o_ -> {
					JSONObject o = (JSONObject) o_;
					o.put("Name", o.getString("arg"));
					o.put("Fmt", "");
				});
				ResourceInfo.put("DataItems", removeOrRetainKeys(DataItems, false, "Name", "Fmt"));
				ResourceInfo.put("DataInfo", new JSONArray());
				ResourceInfos.add(ResourceInfo);
				ResponseParam.put("ResourceInfos", ResourceInfos);
				bodyObject.put("ResponseParam", ResponseParam);
				break;
		}
		return bodyObject;
	}

	public static JSONObject buildRespCode(String dataset) {
		JSONObject respCode = new JSONObject();
		respCode.put(dataset, JSONArray.parseArray("[{\"code\": \"0200\", \"desc\": \"正常\"}]"));
		return respCode;
	}

}