package com.blog.bbs.service.impl;


import com.blog.bbs.dao.interf.ItemDao;
import com.blog.bbs.service.interf.ItemService;
import com.blog.bbs.util.GlobalConfJson;
import com.blog.bbs.util.JsonUtil;
import com.blog.bbs.util.StringUtil;
import com.blog.bbs.vo.ItemVO;
import com.blog.categoryApi.BlogCategoryProxy;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mario on 2015/9/10.
 */
@Service
public class ItemServiceImpl implements ItemService {

    private static final Logger logger = Logger.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private BlogCategoryProxy blogCategoryProxy;

    public Map<String,Object> queryItemByCategoryId(String categoryId) {

        Map<String,Object> categoryMap = null;
        List<ItemVO> list = null;
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            if(StringUtil.isNullOrBlank(categoryId)){
                return GlobalConfJson.getErrMsgMap("-1","输入类别id不能为空");
            }

            //根据类别id获取类别下的版块列表
            list = itemDao.queryItemByCategoryId(categoryId);

            //根据类别id获取类别名称
            Map<String,Object> dataMap = new HashMap<String, Object>();
            Map<String,Object> paramMap = new HashMap<String, Object>();
            paramMap.put("categoryId",categoryId);
            dataMap.put("method","categoryAction.dubbo.queryCategoryById");
            dataMap.put("params",paramMap);
            String categoryRequest = blogCategoryProxy.sayHello(JsonUtil.toJson(dataMap));
            categoryMap = JsonUtil.toBean(categoryRequest, HashMap.class);

            map = GlobalConfJson.getSuccessMsgMap("1", "获取数据成功");
            map.put("categoryName",categoryMap.get("name"));
            map.put("data",list);
        }catch (Exception e){
            logger.error("根据类别id获取版块列表异常",e);
            return GlobalConfJson.getErrMsgMap("-1","根据类别id获取版块错误");
        }
        return map;
    }

    public Map<String, Object> queryItemInfoById(int itemId) {

        Map<String,Object> map = new HashMap<String,Object>();
        Map<String,Object> categoryRequestMap = null;
        Map<String,Object> categoryMap = null;
        try {
            if(itemId<1){
                return GlobalConfJson.getErrMsgMap("-1","版块id不合法");
            }

            //获取版块信息
            ItemVO vo = itemDao.queryItemById(itemId);

            //获取版块对应的类别名字
            Map<String,Object> dataMap = new HashMap<String, Object>();
            Map<String,Object> paramMap = new HashMap<String, Object>();
            paramMap.put("categoryId",vo.getCategoryId());
            dataMap.put("method","categoryAction.dubbo.queryCategoryById");
            dataMap.put("params",paramMap);
            String categoryRequest = blogCategoryProxy.sayHello(JsonUtil.toJson(dataMap));

            categoryRequestMap = JsonUtil.toBean(categoryRequest,HashMap.class);
            categoryMap = (Map<String, Object>) categoryRequestMap.get("data");
            map = GlobalConfJson.getSuccessMsgMap("1","很据id获取版块信息成功");
            map.put("data",vo);
            map.put("categoryName", categoryMap.get("name"));
        }catch (Exception e ){
            logger.error("根据版块id查询版块信息异常",e);
            return GlobalConfJson.getErrMsgMap("-1","根据版块id查询版块信息失败");
        }
        return map;
    }
}
