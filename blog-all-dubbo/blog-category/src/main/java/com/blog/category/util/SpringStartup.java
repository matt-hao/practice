package com.blog.category.util;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Mario on 2015/10/8.
 */
public class SpringStartup {
    private static ClassPathXmlApplicationContext applicationContext;
    private static final Logger logger = Logger.getLogger(SpringStartup.class);

    /**
     * 启动时自动加载spring配置文件并启动spring
     */
    public static void startup() {
        try {
            if(applicationContext == null){
                String[] configs = new String[]{"classpath:applicationContext.xml","classpath:blog-category-service.xml"};
                applicationContext = new ClassPathXmlApplicationContext(configs);
                ContextUtil.setAppContext(applicationContext);
            }
        } catch (BeansException e) {
            logger.error("初始化spring bean异常", e);
        }
    }
}
