package com.blog.category.util;

import com.alibaba.dubbo.common.utils.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

/**
 * ContextUtil存放JVM级变量
 *
 */
public class ContextUtil {
	
	public static final long ONLINE_TIME = System.currentTimeMillis();
	
	private static final Logger logger = Logger.getLogger(ContextUtil.class);
    private static ApplicationContext appContext;

/**
 * @return the appContext
 */
public static ApplicationContext getAppContext() {
	if(appContext==null){
		logger.error("Spring applicationContext is not initalized");
	}
	 return appContext;
}

/**
 * @param appContext the appContext to set
 */
public static void setAppContext(ApplicationContext appContext) {
	ContextUtil.appContext = appContext;
}

/**
 * 根据bean的名称获取springbean
 * @param name bean名称
 * @return bean对象
 */
public static Object getBean(String name){
	if(StringUtils.isNotEmpty(name)){
		if(appContext==null){
			SpringStartup.startup();
		}
		return appContext.getBean(name);
	}else{
		return null;
	}
}
  
}
