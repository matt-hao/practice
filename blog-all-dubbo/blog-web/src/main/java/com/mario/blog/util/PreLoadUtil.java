package com.mario.blog.util;

import com.mario.blog.service.interf.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mario on 2015/9/10.
 */
public class PreLoadUtil {

    private static final Logger logger = Logger.getLogger(PreLoadUtil.class);

    ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

    CategoryService categoryService = ctx.getBean(CategoryService.class);

    /*
    获取类别服务数据
     */
    public Map<String, Object> listCategory() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String back = categoryService.listCategory();
            map = JsonUtil.toBean(back, HashMap.class);
        } catch (Exception e) {
            logger.error("获取类别服务异常");
        }
        return map;
    }

}
