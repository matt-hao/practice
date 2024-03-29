<%--
  Created by IntelliJ IDEA.
  User: Mario
  Date: 2015/9/8
  Time: 16:48
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

    <title>发布帖子页</title>

    <!-- Bootstrap -->
    <link href="../../../bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../../../bootstrap/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="../../../bootstrap/css/font-awesome-ie7.min.css"/>
    <link rel="stylesheet" type="text/css" href="../../../mario/css/wangEditor-1.3.8.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<%@ include file="../common/topBar.jsp" %>
<div class="container" style="margin-top: 3%">
    <div class="row">
        <ol class="breadcrumb" style="background-color: #c1e2b3">
            <li><span class="glyphicon glyphicon-home" aria-hidden="true"></span></li>
            <li><a href="<%=basepath%>">Home</a></li>
            <li><a href="<%=basepath%>v/item/listItemByCategoryId?categoryId=${item.categoryId}">${categoryName}</a>
            </li>
            <li class="active">
                <a href="<%=basepath%>v/item/getItemInfoById?itemId=${item.id}">${item.itemName}</a>
            </li>
            <li class="active">我要发帖</li>
        </ol>
    </div>
    <div class="panel">
        <div class="panel-heading">
            <div class="panel-title">
                发布帖子
            </div>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" id="form" action="<%=basepath%>v/card/postCard" method="post">
                <c:if test="${not empty validateMessage}">
                    <div class="alert alert-danger" role="alert">${validateMessage} </div>
                </c:if>
                <div class="form-group">
                    <input type="hidden" name="itemId" value="${item.id}" id="itemId"/>
                </div>
                <div class="form-group ">
                    <label for="inputTitle" class="control-label">文章标题</label>

                    <div class="col-sm-4" style="padding-left: 0px">
                        <input type="text" class="form-control" id="inputTitle" name="title" value="${title}"
                               placeholder="insert your title...">
                    </div>
                </div>
                <div class="form-group">
                    <textarea id='textarea1' style='height:300px; width:100%;' name="content" value="${content}"></textarea>
                </div>

                <div style="margin-top: 10px;"  class="form-group ">
                    <div class="col-sm-1">
                        <button type="submit" class="btn btn-info btn-block" id='btn'>提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="../common/footBar.jsp" %>
<script src="../../../mario/js/wangEditor-1.3.8.min.js"></script>
<script type="text/javascript">
    $(function () {
        var editor = $('#textarea1').wangEditor();
    });
</script>
</body>
</html>
