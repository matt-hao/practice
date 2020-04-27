<%--
  Created by IntelliJ IDEA.
  User: Mario
  Date: 2015/9/7
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
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
<nav class="navbar navbar-inverse navbar-fixed-top ">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<%=basepath%>">清水河畔</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">招聘信息<span class="sr-only">(current)</span></a></li>
                <c:set var="categoryList" value="<%=list%>"></c:set>
                <c:if test="${not empty categoryList}">
                    <c:forEach items="${categoryList}" var="category">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                               aria-expanded="false">${category.categoryName}<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <c:if test="${not empty category.itemList}">
                                    <c:forEach items="${category.itemList}" var="item">
                                        <li>
                                            <a href="<%=basepath%>v/item/getItemInfoById?itemId=${item.id}">${item.itemName}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                            </ul>
                        </li>
                    </c:forEach>
                </c:if>
            </ul>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${ not empty user}">
                    <li><a href="#">${ user.name}</a></li>
                </c:if>
                <c:if test="${ empty user}">
                    <li><a href="<%=basepath %>v/user/register">注册</a></li>
                    <li><a href="<%=basepath %>v/user/toLogin">登录</a></li>
                </c:if>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">其他<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <c:if test="${not empty user}">
                            <li><a href="<%=basepath %>v/user/backToNoLogin">退出</a></li>
                        </c:if>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>


