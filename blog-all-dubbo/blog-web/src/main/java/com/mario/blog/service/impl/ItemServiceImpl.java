package com.mario.blog.service.impl;


import com.mario.blog.dao.interf.ProxyDao;
import com.mario.blog.service.interf.ItemService;
import com.mario.blog.util.GlobalConfJson;
import com.mario.blog.util.JsonUtil;
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
public class ItemServiceImpl implements ItemService {
    private static final Logger logger = Logger.getLogger(ItemServiceImpl.class);

    @Autowired
    private ProxyDao proxyDao;

    public Map<String,Object> listItemByCategoryId(String categoryId) {
        String rs=null;
        Map<String,Object> resultMap = new HashMap<String, Object>();
        try {
            if(StringUtil.isNullOrBlank(categoryId)){
                return GlobalConfJson.getErrMsgMap("-1","输入类别id不能为空");
            }
            Map<String,Object> reqMap = new HashMap<String, Object>();
            Map<String,Object> paramMap = new HashMap<String, Object>();
            paramMap.put("categoryId",categoryId);
            reqMap.put("method","itemAction.dubbo.queryItemByCategoryId");
            reqMap.put("params",paramMap);
            rs = proxyDao.bbsDaoProxy(reqMap);
        }catch (Exception e){
            logger.error("根据类别id获取版块列表异常",e);
            return GlobalConfJson.getErrMsgMap("-1", "根据类别id获取版块错误");
        }
        return JsonUtil.toBean(rs,HashMap.class);
    }

    public Map<String, Object> getItemInfoById(int itemId) {
        String rs = null;
        Map<String,Object> resultMap = new HashMap<String,Object>();
        try {
            if(itemId<1){
                return GlobalConfJson.getErrMsgMap("-1","版块id不合法");
            }
            Map<String,Object> reqMap = new HashMap<String, Object>();
            Map<String,Object> paramMap = new HashMap<String, Object>();
            paramMap.put("itemId",itemId);
            reqMap.put("method","itemAction.dubbo.queryItemInfoById");
            reqMap.put("params",paramMap);
            rs = proxyDao.bbsDaoProxy(reqMap);
        }catch (Exception e ){
            logger.error("根据版块id查询版块信息异常",e);
            return GlobalConfJson.getErrMsgMap("-1", "根据版块id查询版块信息失败");
        }
        return JsonUtil.toBean(rs, HashMap.class);
    }
}
