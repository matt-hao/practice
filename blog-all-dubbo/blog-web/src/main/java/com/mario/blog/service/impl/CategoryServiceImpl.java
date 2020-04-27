package com.mario.blog.service.impl;

import com.mario.blog.dao.interf.ProxyDao;
import com.mario.blog.service.interf.CategoryService;
import com.mario.blog.util.GlobalConfJson;
import com.mario.blog.util.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mario on 2015/9/10.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private static final Logger logger = Logger.getLogger(CategoryServiceImpl.class);

    @Autowired
    private ProxyDao proxyDao;

    public String addCategory(String name) {
        Map<String,Object> resultMap = new HashMap<String, Object>();
        String rs = null;
        try {
            if (StringUtil.isNullOrBlank(name)) {
                return GlobalConfJson.getErrMsgString("-1", "类别名不能为空");
            }

            Map<String,Object> reqMap = new HashMap<String, Object>();
            Map<String,Object> paramMap = new HashMap<String, Object>();
            paramMap.put("name",name);
            reqMap.put("method","categoryAction.dubbo.saveCateGory");
            reqMap.put("params",paramMap);
            rs = proxyDao.categoryDaoProxy(reqMap);
        } catch (Exception e) {
            logger.error("添加类别异常[SERVICE]:", e);
            return GlobalConfJson.getErrMsgString("-1", "添加失败");
        }
        return rs;
    }

    public String listCategory() {
        String rs = null;
        try {
            Map<String,Object> reqMap = new HashMap<String, Object>();
            Map<String,Object> paramMap = new HashMap<String, Object>();
            reqMap.put("method","categoryAction.dubbo.queryCategory");
            reqMap.put("params",paramMap);

            rs = proxyDao.categoryDaoProxy(reqMap);
        } catch (Exception e) {
            logger.error("获取类别列表异常[SERVICE]:", e);
        }
        return rs;
    }

}
