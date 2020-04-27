package com.blog.category.service.impl;


import com.blog.bbsApi.BlogBbsProxy;
import com.blog.category.dao.interf.CategoryDao;
import com.blog.category.service.interf.CategoryService;
import com.blog.category.util.GlobalConfJson;
import com.blog.category.util.JsonUtil;
import com.blog.category.util.StringUtil;
import com.blog.category.vo.CategoryVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Mario on 2015/10/1.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    private static final Logger logger = Logger.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private BlogBbsProxy blogBbsProxy;

    public Map<String, Object> saveCategory(String categoryName) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if (StringUtil.isNullOrBlank(categoryName)) {
                return GlobalConfJson.getErrMsgMap("-1", "类别名不能为空");
            }
            //封装实体
            CategoryVO vo = new CategoryVO();
            vo.setUuid(UUID.randomUUID().toString().replace("-", ""));
            vo.setName(categoryName);
            Timestamp curTime = new Timestamp(System.currentTimeMillis());
            vo.setCreateTime(curTime);

            //存入数据库
            categoryDao.saveCategory(vo);
            map = GlobalConfJson.getSuccessMsgMap("1", "添加类别成功");
        } catch (Exception e) {
            logger.error("添加类别异常[SERVICE]:", e);
            return GlobalConfJson.getErrMsgMap("-1", "添加失败");
        }
        return map;
    }

    public Map<String, Object> queryCategory() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            //获取类别列表
            List<CategoryVO> categoryList = categoryDao.queryCategory();

            for (CategoryVO vo : categoryList) {
                Map<String, Object> dataMap = new HashMap<String, Object>();
                dataMap.put("categoryId", vo.getUuid());
                dataMap.put("categoryName", vo.getName());

                //根据版块id获取版块列表
                Map<String, Object> reMap = new HashMap<String, Object>();
                Map<String, Object> paramMap = new HashMap<String, Object>();
                paramMap.put("categoryId", vo.getUuid());
                reMap.put("method", "itemAction.dubbo.queryItemByCategoryId");
                reMap.put("params", paramMap);

                String rs = blogBbsProxy.sayHello(JsonUtil.toJson(reMap));
                Map<String, Object> tempMap = new HashMap<String, Object>();
                tempMap = JsonUtil.toBean(rs, HashMap.class);
                dataMap.put("itemList", tempMap.get("data"));
                list.add(dataMap);
            }
            map = GlobalConfJson.getSuccessMsgMap("1", "获取类别列表成功");
            map.put("data", list);
        } catch (Exception e) {
            logger.error("获取类别列表异常[SERVICE]:", e);
            return GlobalConfJson.getErrMsgMap("-1", "获取类别列表失败");
        }
        return map;
    }

    public Map<String, Object> queryCategoryById(String categoryId) {
        Map<String, Object> map = new HashMap<String, Object>();
        CategoryVO categoryVO = new CategoryVO();
        try {
            //数据校验
            if (StringUtil.isNullOrBlank(categoryId)) {
                return GlobalConfJson.getErrMsgMap("-1", "输入categoryId不能为空");
            }
            //根据categoryId获取类别信息
            categoryVO = categoryDao.queryCategoryById(categoryId);
            if (categoryVO == null) {
                return GlobalConfJson.getErrMsgMap("-1", "获取失败");
            }

            map = GlobalConfJson.getSuccessMsgMap("1", "根据categoryId获取类别信息成功");
            map.put("data", categoryVO);
        } catch (Exception e) {
            logger.error("根据categoryId获取类别信息异常[service]", e);
            return GlobalConfJson.getErrMsgMap("-1", "根据categoryId获取类别信息失败");
        }
        return map;
    }


}
