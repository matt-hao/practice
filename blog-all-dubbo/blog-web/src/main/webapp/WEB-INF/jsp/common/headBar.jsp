<%--
  Created by IntelliJ IDEA.
  User: Mario
  Date: 2015/9/12
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.mario.blog.util.PreLoadUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%
  String contextPath = request.getContextPath();
  String basepath = request.getScheme() + "://"
          + request.getServerName() + ":" + request.getServerPort()
          + contextPath + "/";
%>
<%
  /**
   * 导入类别数据和版块数据
   */
  PreLoadUtil preLoadUtil = new PreLoadUtil();
  Map<String, Object> map = preLoadUtil.listCategory();
  List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("data");

  /**
   * 获取用户数据
   */
//    UserVO vo = request.getSession().getAttribute(SystemConstant.CURRENT_USER);
//    System.out.println();
%>