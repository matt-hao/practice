package com.blog.user.util;

import java.util.HashMap;
import java.util.Map;

public class GlobalConfJson {
	public static Map<String, Object> getErrMsgMap(String code, String msg) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		result.put("success", 0);
		result.put("code", code);
		result.put("message", msg);
		result.put("data", data);
		return result;
	}

	public static Map<String, Object> getSuccessMsgMap(String code, String msg) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		result.put("success", 1);
		result.put("code", code);
		result.put("message", msg);
		result.put("data", data);
		return result;
	}

	public static String getFailedResponseString(String message,
			Map<String, Object> data) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", 0);
		result.put("code", "-1");
		result.put("message", message);
		result.put("data", data);
		return JsonUtil.toJson(result);
	}

	public static String getSuccessResponseString(String message,
			Map<String, Object> data) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", 1);
		result.put("code", "0");
		result.put("message", message);
		result.put("data", data);
		return JsonUtil.toJson(result);
	}

	public static String getErrMsg() {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		result.put("success", 0);
		result.put("code", "-1");
		result.put("message", "操作失败");
		result.put("data", data);
		return JsonUtil.toJson(result);
	}
	public static String getSuccessMsg() {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		result.put("success", 1);
		result.put("code", "0");
		result.put("message", "操作成功");
		result.put("data", data);
		return JsonUtil.toJson(result);
	}
	
	public static String getErrMsgString(String code, String msg) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		result.put("success", 0);
		result.put("code", code);
		result.put("message", msg);
		result.put("data", data);
		return  JsonUtil.toJson(result);
	}

	public static String getSuccessMsgString(String code, String msg) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		result.put("success", 1);
		result.put("code", code);
		result.put("message", msg);
		result.put("data", data);
		return  JsonUtil.toJson(result);
	}
}
