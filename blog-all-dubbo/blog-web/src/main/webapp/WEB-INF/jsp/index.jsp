<%--
  Created by IntelliJ IDEA.
  User: Mario
  Date: 2015/9/7
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String contextPath1 = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <!--设置编码格式-->
    <meta charset="utf-8">

    <!--让ie浏览器运行最新的渲染模式-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- 为了确保适当的绘制和触屏缩放,在移动设备浏览器上，通过为视口（viewport）设置 meta 属性为 user-scalable=no 可以禁用其缩放（zooming）功能 -->
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">

    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

    <!-- 让部分国产浏览器默认采用高速模式渲染页面 -->
    <meta name="renderer" content="webkit">

    <title>首页</title>
    <!-- Bootstrap -->
    <link href="<%=contextPath1%>/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<%@include file="./common/topBar.jsp" %>
<div class="container-fluid" style="margin-top: 3%">
    <div class="row">
        <ol class="breadcrumb" style="background-color: #c1e2b3">
            <li><span class="glyphicon glyphicon-home" aria-hidden="true"></span></li>
            <li class="active">Home</li>
        </ol>
    </div>
    <div class="panel panel-group panel-success">
        <c:if test="${not empty categoryList}">
            <c:forEach items="${categoryList}" var="category">
                <div class="panel-heading" style="background-color: #3BB878">
                    <h2 class="panel-title">
                        <a href="<%=basepath%>v/item/listItemByCategoryId?categoryId=${category.categoryId}"> ${category.categoryName}</a>
                    </h2>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <c:forEach items="${category.itemList}" var="item">
                            <div class="col-md-3 well-lg">
                                <a href="<%=basepath%>v/item/getItemInfoById?itemId=${item.id}">
                                    <button type="button" class="btn btn-lg btn-info" aria-label="Left Align">
                                            ${item.itemName}
                                    </button>
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>
</div>
<%@include file="./common/footBar.jsp" %>
</body>
</html>
