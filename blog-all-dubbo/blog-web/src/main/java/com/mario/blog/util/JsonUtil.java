package com.mario.blog.util;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * JSON 工具类
 * @author zhandl (yuyoo zhandl@hainan.net)
 * @teme 2010-5-21 上午09:50:58
 * @since 1.6.0
 */
public final class JsonUtil {
 	 
	private static JsonFactory jsonFactory = new JsonFactory();
	
	private static ObjectMapper mapper = null;
	
	static {
		jsonFactory.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		jsonFactory.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		mapper = new ObjectMapper(jsonFactory);
	}
	
	/**
	 * 获取jackson json lib的ObjectMapper对象
	 * @return -- ObjectMapper对象
	 */
	public static ObjectMapper getMapper() {
		return mapper;
	}

	/**
	 * 获取jackson json lib的JsonFactory对象
	 * @return --  JsonFactory对象
	 */
	public static JsonFactory getJsonFactory() {
		return jsonFactory;
	}
 
	/**
	 * 将json转成java bean
	 * @param <T> -- 多态类型
	 * @param json -- json字符串
	 * @param clazz -- java bean类型(Class)
	 * @return -- java bean对象
	 */
	public static <T> T toBean(String json, Class<T> clazz) {
		
		T rtv = null;
		try {
			rtv = mapper.readValue(json, clazz); 
		} catch (Exception ex) {  
			throw new IllegalArgumentException("json字符串转成java bean异常", ex);
		}
		return rtv;		
	}
	
	/**
	 * 将java bean转成json
	 * @param bean -- java bean
	 * @return -- json 字符串
	 */
	public static String toJson(Object bean) {
		
		String rtv = null;
		try {
			rtv = mapper.writeValueAsString(bean);
		} catch (Exception ex) {  
			throw new IllegalArgumentException("java bean转成json字符串异常", ex);
		}
		return rtv;		
	}
}