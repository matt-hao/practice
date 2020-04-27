package com.mario.blog.dao.impl;

import com.blog.bbsApi.BlogBbsProxy;
import com.blog.categoryApi.BlogCategoryProxy;
import com.blog.userApi.BlogUserProxy;
import com.mario.blog.dao.interf.ProxyDao;
import com.mario.blog.util.JsonUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;


/**
 * Created by Mario on 2015/10/9.
 */
@Repository
public class ProxyDaoImpl implements ProxyDao {
    private static final Logger logger = Logger.getLogger(ProxyDaoImpl.class);

    @Autowired
    private BlogUserProxy blogUserProxy;

    @Autowired
    private BlogCategoryProxy blogCategoryProxy;

    @Autowired
    private BlogBbsProxy blogBbsProxy;

    public String userDaoProxy(Map<String, Object> reqMap) {
        String rs = null;
        try{
            rs = blogUserProxy.sayHello(JsonUtil.toJson(reqMap));
        }catch (Exception e){
            logger.error("reMap:" + JsonUtil.toJson(reqMap));
            logger.error("proxy异常",e);
        }
        return rs;
    }

    public String categoryDaoProxy(Map<String, Object> reqMap) {
        String rs = null;
        try{
            rs = blogCategoryProxy.sayHello(JsonUtil.toJson(reqMap));
        }catch (Exception e){
            logger.error("reMap:" + JsonUtil.toJson(reqMap));
            logger.error("proxy异常",e);
        }
        return rs;
    }

    public String bbsDaoProxy(Map<String, Object> reqMap) {
        String rs = null;
        try{
            rs = blogBbsProxy.sayHello(JsonUtil.toJson(reqMap));
        }catch (Exception e){
            logger.error("reMap:" + JsonUtil.toJson(reqMap));
            logger.error("proxy异常",e);
        }
        return rs;
    }
}
