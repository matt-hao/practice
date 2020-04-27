package com.blog.bbs.util;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class MapUtil {

	private static final Logger logger = Logger.getLogger(MapUtil.class);
	/**
	 * 取boolean参数值
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static boolean getBooleanParameter(Map params, String name,
			boolean defaultVal) {
		boolean value = defaultVal;
		try {
			Object temp = params.get(name);
			if ("true".equals(temp) || "on".equals(temp)) {
				return true;
			} else if ("false".equals(temp) || "off".equals(temp)) {
				return false;
			}
		} catch (Exception e) {
		}
		return value;
	}

	/**
	 * 取double参数值
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static double getDoubleParameter(Map params, String name,
			double defaultNum) {
		double num = defaultNum;
		try {
			Object temp = params.get(name);
			if (temp != null && !temp.equals("")) {
				num = Double.parseDouble(temp.toString());
			}
		} catch (Exception e) {
		}
		return num;
	}

	/**
	 * 取int参数值
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static int getIntParameter(Map params, String name, int defaultNum) {
		int num = defaultNum;
		try {
			Object temp = params.get(name);
			if (temp != null) {
				num = Integer.parseInt(temp.toString());
			}
		} catch (Exception ignored) {
		}
		return num;
	}

	/**
	 * 取long参数值
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static long getLongParameter(Map params, String name, long defaultNum) {
		long num = defaultNum;
		try {
			Object temp = params.get(name);
			if (temp != null) {
				num = Long.parseLong(temp.toString());
			}
		} catch (Exception ignored) {
		}
		return num;
	}

	/**
	 * 取string 参数值
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static String getParameter(Map params, String name,
			String defaultValue) {
		String value = defaultValue;
		try {
			Object temp = params.get(name);
			if (temp != null) {
				value = temp.toString();
			}
		} catch (Exception e) {
		}
		return value;
	}

	/**
	 * 取参数值
	 * 
	 * @param <T>
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getTParameter(Map params, String name, T defaultValue) {
		T value = defaultValue;
		try {
			Object temp = params.get(name);
			if (temp != null) {
				value = (T) temp;
			}
		} catch (Exception e) {
		}
		return value;
	}

	/**
	 * 参数Map
	 * 
	 *
	 */
	public static Map<String, Object> transMaps(Map<String, String[]> paramMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Set<Map.Entry<String, String[]>> set = paramMap.entrySet();
		for (Iterator<Map.Entry<String, String[]>> it = set.iterator(); it
				.hasNext();) {
			Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>) it
					.next();
			map.put(entry.getKey(), entry.getValue()[0]);
		}
		return map;
	}

	/**
	 * 提取request中参数装入HashMap
	 * 
	 * @param
	 * 
	 */
	public static Map<String, Object> transReqToMap(HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			Map<String, String[]> map = request.getParameterMap();
			Set<Map.Entry<String, String[]>> set = map.entrySet();
			for (Iterator<Map.Entry<String, String[]>> it = set.iterator(); it
					.hasNext();) {
				Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>) it
						.next();
				resultMap.put(entry.getKey(), entry.getValue()[0]);
			}
		} catch (Exception e) {
			logger.error("转换出错！", e);
		}
		return resultMap;
	}
}
