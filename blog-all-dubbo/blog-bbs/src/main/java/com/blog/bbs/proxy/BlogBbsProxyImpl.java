package com.blog.bbs.proxy;


import com.blog.bbs.facade.ActionFacade;
import com.blog.bbs.util.*;
import com.blog.bbsApi.BlogBbsProxy;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mario on 2015/10/8.
 */
public class BlogBbsProxyImpl implements BlogBbsProxy {

    private static final Logger logger = Logger.getLogger(BlogBbsProxyImpl.class);

    static {
        //运行初始化环境
        logger.error("...dubbo..start");
        SpringStartup.startup();
        logger.error("...dubbo..end");
    }

    /**
     * @param request
     * @return
     */
    public String sayHello(String request) {
        String response = null;
        try {
            Map<String, Object> requestMap = JsonUtil.toBean(request, HashMap.class);
            String method = (String) requestMap.get("method");
            if (StringUtil.isNullOrBlank(method)) {
                response = GlobalConfJson.getErrMsgString("-1", "请求方法名为空");
                return response;
            }

            Map<Object, Object> header = (Map<Object, Object>) requestMap.get("header");
            if (header == null) {
                header = new HashMap<Object, Object>();
            }

            Map<Object, Object> params = (Map<Object, Object>) requestMap.get("params");
            ActionFacade actionFacade = (ActionFacade) ContextUtil.getBean("actionFacade");

            response = actionFacade.callService(method, header, params);

        } catch (Exception e) {
            logger.error("请求服务出错!request=" + request, e);
            response = GlobalConfJson.getErrMsgString("-1", "请求服务出错");
        }
        return response;
    }
}
