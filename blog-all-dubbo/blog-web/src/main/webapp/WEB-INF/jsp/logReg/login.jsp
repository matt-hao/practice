<%--
  Created by IntelliJ IDEA.
  User: Mario
  Date: 2015/9/7
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

    <title>登录</title>
    <!-- Bootstrap -->
    <link href="../../../bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body style="background-color:#3BB878">
<%@ include file="../common/topBar.jsp" %>
<div class="container">
    <!--jumbotron-->
    <div>
        <div class="jumbotron text-center" style="background-color:#3BB878;margin-top: 12%">
            <h1>Hello, world!</h1>

            <p>Let's ROCK IT</p>
        </div>
    </div>
    <!--jumbotron-->


    <div class="center-block">
        <!--form-->
        <form class="form-horizontal " id="login" action="<%=basepath%>v/user/login" method="post">
            <c:if test="${ not empty  validateMessage}">
            <div class="form-group">
                <div class="alert alert-warning alert-dismissible col-md-6 col-md-offset-3" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <strong>Warning!</strong> ${validateMessage}.
                </div>
            </div>
            </c:if>
            <div class="form-group form-group-lg">
                <label for="email" class="col-md-3  control-label">Email address</label>

                <div class="col-md-6">
                    <input type="email" class=" form-control" name="email" id="email"  value="${email}"   placeholder="Email">
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label for="password" class="col-md-3   control-label">Password</label>

                <div class="col-md-6">
                    <input type="password" class="form-control" name="password" id="password"  placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <div class="checkbox col-md-offset-3 col-md-2">
                    <label>
                        <input type="checkbox"> Check me out
                    </label>
                </div>
            </div>
            <div class="form-group">
                <div class="checkbox col-md-offset-3 col-md-6">
                    <button type="submit" class="btn btn-info btn-block">Submit</button>
                </div>
            </div>
        </form>
        <!--form-->
    </div>
</div>
<%@include file="../common/footBar.jsp" %>
</body>
</html>