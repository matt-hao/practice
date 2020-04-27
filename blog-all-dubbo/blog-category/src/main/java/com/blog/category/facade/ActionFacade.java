package com.blog.category.facade;

import com.blog.category.util.ContextUtil;
import com.blog.category.util.GlobalConfJson;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by Mario on 2015/10/8.
 */
@Component("actionFacade")
public class ActionFacade {
    private static Logger logger = Logger.getLogger(ActionFacade.class);

    /**
     * 调用Action方法
     *
     * @param method 方法名称
     * @param header header信息
     * @param params 参数信息
     * @return 返回调用结果
     */
    private String invokeAction(String method, Map<Object, Object> header, Map<Object, Object> params) {
        String response = null;
        try {
            Object action = getAction(method);
            //logger.info("action is ={}",action);
            if (null != action) {
                long bTime = System.currentTimeMillis();
                Class<?> parmTypes[] = new Class[]{Map.class, Map.class};
                int beginIndex = method.lastIndexOf('.') + 1;
                int endIndex = method.length();
                String methodName = StringUtils.defaultString(method.substring(beginIndex, endIndex), "");
                methodName = methodName.trim();
                //logger.info("action methodName is {} ",methodName);
                Method invokMethod = action.getClass().getMethod(methodName, parmTypes);
                Object args[] = new Object[2];
                args[0] = header;
                args[1] = params;
                response = (String) invokMethod.invoke(action, args);
                long eTime = System.currentTimeMillis();

            } else {
                response = GlobalConfJson.getErrMsgString("-1", "指定的服务不存在！");
            }
        } catch (Exception e) {
            logger.error("调用服务出错", e);
            response =  GlobalConfJson.getErrMsgString("-1", "调用服务出错！");
        }
        return response;
    }

    /**
     * 调用服务
     *
     * @param method 方法名称
     * @param params 参数
     * @param header 参数
     * @return json字符串
     */
    public String callService(String method, Map<Object, Object> header,
                              Map<Object, Object> params) {
        return invokeAction(method, header, params);
    }

    /**
     * 获取ActionBean
     *
     * @param method ice调用方法名称
     * @return 返回action bean
     */
    public Object getAction(String method) {
        Object obj = null;
        if (StringUtils.isNotEmpty(method)) {
            obj = ContextUtil.getBean(method.substring(0, method.indexOf('.')));
            //logger.info("find bean from spring contrianer {}",method);
        }
        return obj;
    }
}
