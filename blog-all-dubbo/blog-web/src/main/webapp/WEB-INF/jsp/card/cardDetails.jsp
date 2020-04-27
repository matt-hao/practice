<%--
  Created by IntelliJ IDEA.
  User: Mario
  Date: 2015/9/8
  Time: 17:56
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

    <title>帖子详情页</title>

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
<%@include file="../common/topBar.jsp" %>
<div class="container" style="margin-top: 3%">
    <div class="row">
        <ol class="breadcrumb" style="background-color: #c1e2b3">
            <li><span class="glyphicon glyphicon-home" aria-hidden="true"></span></li>
            <li><a href="<%=basepath%>">Home</a></li>
            <li><a href="<%=basepath%>v/item/listItemByCategoryId?categoryId=${item.categoryId}">${categoryName}</a>
            </li>
            <li><a href="<%=basepath%>v/item/getItemInfoById?itemId=${item.id}">${item.itemName}</a></li>
            <li class="active">${card.title}</li>
        </ol>
    </div>
    <div class="row">
        <div class="col-md-2 text-left" style="margin-top: 1.2%">
            <div class="btn-group">
                <a href="<%=basepath%>v/card/toPostCard?itemId=${item.id}">
                    <button class="btn btn-lg btn-info">我要发帖</button>
                </a>
            </div>
        </div>

        <div class=" col-md-6 col-md-offset-4 text-right">
            <ul id="example"></ul>
        </div>
    </div>

    <div class="row">
        <div class="col-md-2 bg-info" style="height: 35px;">
            <p style="margin-top: 8px">
                <label>查看:</label> <span class="badge">122</span>
                <label>回复数:</label> <span class="badge">122</span>
            </p>
        </div>
        <div class="col-md-10 bg-warning" align=" left center" style="height: 35px;">
            <p style="margin-top: 8px;font-weight: bold">
                ${card.title}
            </p>
        </div>
    </div>
    <div class="row">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th class="col-md-2">${card.authorName}</th>
                <th class="col-md-10">
                        发表于${card.createTime}
                </th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="col-md-2">
                    大楼主
                </td>
                <td class="col-md-10">
                    ${card.content  }
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <div id="list"></div>

    <div class="row">
        <div class="panel">
            <div class="panel-heading">
                <div class="panel-title">
                    我的回复
                </div>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" action="<%=basepath%>v/reply/insertReply" id="submitForm" method="post">
                    <div class="form-group">
                        <input type="hidden" name="cardId" value="${card.uuid}"/>
                    </div>
                    <div class="form-group">
                        <input type="hidden" name="itemId" value="${item.id}"/>
                    </div>

                    <div class="form-group">
                        <textarea id='textarea1' style='height:300px; width:100%;' name="content"></textarea>
                    </div>

                    <div class="form-group">
                        <div style='margin-top: 10px;' class="form-group col-sm-1">
                            <button type="button" class="btn btn-info btn-block" id='btnSubmit'>提交</button>
                        </div>
                        <div>
                            <span id="errorInfo"></span>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="../common/footBar.jsp" %>
<script type="text/javascript" src="../../../mario/js/bootstrap-paginator.js"></script>
<script src="../../../mario/js/wangEditor-1.3.8.min.js"></script>
<script type="text/javascript">
    $(function () {
        var cardId = '${card.uuid}';
        $.ajax({
            url: "<%=basepath%>v/reply/getReplyListById",
            datatype: 'json',
            data: "cardId=" + cardId,
            type: "get",
            success: function (data) {
                if (data != null) {
                    $.each(eval("(" + data + ")").data, function (index, reply) { //遍历返回的json
                        $("#list").append("<div class='row'>" +
                                "<table class='table table-bordered'>" +
                                "<thead>" +
                                "<tr>" +
                                "<th class='col-md-2'>" + reply.authorName + "</th>" +
                                "<th class='col-md-10'>" +
                                "发表于" + reply.createTime +
                                "</th>" +
                                "</tr>" +
                                "</thead>" +
                                "<tbody>" +
                                "<tr>" +
                                "<td class='col-md-2'>" +
                                "跟帖仔" +
                                "</td>" +
                                "<td class='col-md-2'>" +
                                reply.replyContent +
                                "</td>" +
                                "</tr>" +
                                "</tbody>" +
                                "</table>" +
                                "</div>");
                    });
                    var pageCount = eval("(" + data + ")").pageCount; //取到pageCount的值(把返回数据转成object类型)
                    var currentPage = eval("(" + data + ")").CurrentPage; //得到urrentPage
                    var options = {
                        bootstrapMajorVersion: 3, //版本
                        currentPage: currentPage, //当前页数
                        totalPages: pageCount, //总页数
                        numberOfPages: 20,
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
                                url: "<%=basepath%>v/reply/getReplyListById",
                                datatype: 'json',
                                type: "get",
                                data: "curPage=" + page + "&cardId=" + cardId,
                                success: function (data1) {
                                    $("#list").html('');
                                    if (data1 != null) {
                                        $("#list").html('');
                                        $.each(eval("(" + data1 + ")").data, function (index, reply) { //遍历返回的json
                                            $("#list").append("<div class='row'>" +
                                                    "<table class='table table-bordered'>" +
                                                    "<thead>" +
                                                    "<tr>" +
                                                    "<th class='col-md-2'>" + reply.authorName + "</th>" +
                                                    "<th class='col-md-10'>" +
                                                    "发表于" + reply.createTime +
                                                    "</th>" +
                                                    "</tr>" +
                                                    "</thead>" +
                                                    "<tbody>" +
                                                    "<tr>" +
                                                    "<td class='col-md-2'>" +
                                                    "跟帖仔" +
                                                    "</td>" +
                                                    "<td class='col-md-2'>" +
                                                    reply.replyContent +
                                                    "</td>" +
                                                    "</tr>" +
                                                    "</tbody>" +
                                                    "</table>" +
                                                    "</div>");
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
<script type="text/javascript">
    $(function () {
        var editor = $('#textarea1').wangEditor();
        $('#btnSubmit').click(function () {
            var contentCopy = $('#textarea1').val();
            contentCopy.replace("&nbsp;", "");
            contentCopy.replace("<br>", "");
            contentCopy.replace("<p>", "");
            contentCopy.replace("</p>", "");
            if (contentCopy == "") {
                $('#errorInfo')[0].innerHTML = '输入内容不能为空';
                return false;
            } else if (contentCopy.length > 250) {
                $('#errorInfo')[0].innerHTML = '输入内容不能超过250个字符';
                return false;
            } else {
                $('#submitForm').submit();
                return true;
            }
        });
    });
</script>
</body>
</html>
