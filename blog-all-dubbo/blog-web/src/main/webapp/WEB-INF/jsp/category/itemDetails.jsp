<%--
  Created by IntelliJ IDEA.
  User: Mario
  Date: 2015/9/8
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

    <title>帖子列表页</title>
    <!-- Bootstrap -->
    <link href="../../../bootstrap/css/bootstrap.min.css" rel="stylesheet">

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
        <ol class="breadcrumb" style="background-color:#c1e2b3 ">
            <li><span class="glyphicon glyphicon-home" aria-hidden="true"></span></li>
            <li><a href="<%=basepath%>">Home</a></li>
            <li><a href="<%=basepath%>v/item/listItemByCategoryId?categoryId=${item.categoryId}">${categoryName}</a>
            </li>
            <li class="active">${item.itemName}</li>
        </ol>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h2>
                ${item.itemName}
            </h2>
        </div>
        <div class="panel-body ">
            <p>
                <label>版主:</label>
                <span>皮城女警</span>
            </p>

            <p>
                <label>简介:</label>
                <span>${item.summary}</span>
            </p>
        </div>
    </div>
    <!--友情分割线-->
    <hr/>
    <!--友情分割线结束-->

    <div class="row">
        <div class="col-md-2">
            <a href="<%=basepath%>v/card/toPostCard?itemId=${item.id}">
                <button class="btn btn-info btn-lg">
                    <span class="glyphicon glyphicon-book">我要发帖</span>
                </button>
            </a>
        </div>
    </div>

    <table class="table table-hover col-md-6">
        <thead>
        <tr>
            <th class="col-md-6">帖子标题</th>
            <th class="col-md-2">作者</th>
            <th class="col-md-2">回复数</th>
            <th class="col-md-2">发表时间</th>
        </tr>
        </thead>
        <tbody id="list">
        </tbody>
    </table>
    <ul id="example"></ul>
</div>
<%@include file="../common/footBar.jsp" %>
<script type="text/javascript" src="../../../mario/js/bootstrap-paginator.js"></script>
<script type="text/javascript">
    $(function () {
        var itemId = ${item.id};
        $.ajax({
            url: "<%=basepath%>v/card/getCardList",
            datatype: 'json',
            data: "itemId=" + itemId,
            type: "get",
            success: function (data) {
                if (data != null) {
                    $.each(eval("(" + data + ")").data, function (index, card) { //遍历返回的json
                        $("#list").append("<tr>" +
                                "<td class='col-md-6'><a href='<%=basepath%>v/card/toCardDetails?itemId=" + itemId + "&cardId=" + card.uuid + "'>" + card.title + "</a></td>" +
                                "<td class='col-md-2'><a href='#'>" + card.authorName + "</a></td>" +
                                "<td class='col-md-2'>" + 899 + "</td>" +
                                "<td class='col-md-2'>" + card.createTime + "</td>" +
                                "</tr>");
                    });
                    var pageCount = eval("(" + data + ")").pageCount; //取到pageCount的值(把返回数据转成object类型)
                    var currentPage = eval("(" + data + ")").CurrentPage; //得到urrentPage
                    var options = {
                        bootstrapMajorVersion: 3, //版本
                        currentPage: currentPage, //当前页数
                        totalPages: pageCount, //总页数
                        numberOfPages: 10,
                        itemTexts: function (type, page, current) {
                            switch (type) {
                                case "first":
                                    return "首页";
                                case "prev":
                                    return "上一页";
                                case "next":
                                    return "下一页";
                                case "last":
                                    return "末页";
                                case "page":
                                    return page;
                            }
                        },//点击事件，用于通过Ajax来刷新整个list列表
                        onPageClicked: function (event, originalEvent, type, page) {
                            $.ajax({
                                url: "<%=basepath%>v/card/getCardList",
                                datatype: 'json',
                                type: "get",
                                data: "curPage=" + page + "&itemId=" + itemId,
                                success: function (data1) {
                                    $("#list").html('');
                                    if (data1 != null) {
                                        $("#list").html('');
                                        $.each(eval("(" + data1 + ")").data, function (index, card) { //遍历返回的json
                                            $("#list").append("<tr>" +
                                                    "<td class='col-md-6'><a href='<%=basepath%>v/card/toCardDetails?itemId=" + itemId + "&cardId=" + card.uuid + "'>" + card.title + "</a></td>" +
                                                    "<td class='col-md-2'><a href='#'>" + card.authorName + "</a></td>" +
                                                    "<td class='col-md-2'>" + 899 + "</td>" +
                                                    "<td class='col-md-2'>" + card.createTime + "</td>" +
                                                    "</tr>");
                                        });
                                    }
                                }
                            });
                        }
                    };
                    $('#example').bootstrapPaginator(options);
                }
            }
        });
    })
</script>
</body>
</html>
