package com.mario.blog.interceptor;

import com.mario.blog.conf.SystemConstant;
import com.mario.blog.vo.UserVO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * 登陆拦截器
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 拦截例外
     *
     * @param excludedUrl
     */
    private static Set excludeUrl = null;

    {
        excludeUrl = new HashSet();

        /**用户**/
        excludeUrl.add("/user/toLogin");
        excludeUrl.add("/user/register");
        excludeUrl.add("/user/saveUser");
        excludeUrl.add("/user/login");
        excludeUrl.add("/user/validateEmail");
        excludeUrl.add("/user/validateName");
        excludeUrl.add("/user/backToNoLogin");

        /**类别**/
        excludeUrl.add("/category/listCategory");

        /**版块**/
        excludeUrl.add("/item/listItemByCategoryId");
        excludeUrl.add("/item/getItemInfoById");

        /**帖子**/
        excludeUrl.add("/card/getItemInfoById");
        excludeUrl.add("/card/getCardList");
        excludeUrl.add("/card/toCardDetails");

        /**回复**/
        excludeUrl.add("/reply/getReplyListById");
    }

    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
     * 在进入Controller之前执行
     *
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        //跳过拦截例外
        String requestUri = request.getRequestURI();
        Iterator<String> it = excludeUrl.iterator();
        while (it.hasNext()) {
            if (requestUri.contains(it.next())) {
                return true;
            }
        }
        //判断session内有没有用户登陆记录
        Map<String,Object> userMap = (Map<String, Object>) request.getSession().getAttribute(SystemConstant.CURRENT_USER);
        if (userMap == null) {
            System.out.println("requestUrl==" + requestUri);
            System.out.println("===Login Interceptor===");
            String contextPath = request.getContextPath();
            String basepath = request.getScheme() + "://"
                    + request.getServerName() + ":" + request.getServerPort()
                    + contextPath + "/";
            response.sendRedirect(basepath + "v/user/toLogin");
//			request.getRequestDispatcher(basepath+"logReg/login").forward(request, response);
            return false;
        } else
            return true;
    }

}
