<%--
  Created by IntelliJ IDEA.
  User: Mario
  Date: 2015/9/9
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="com.mario.blog.util.LogReadUtil" %>
<%
    String log = LogReadUtil.readFileByRandomAccess(1);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>日志信息</title>
</head>
<body>
<table border="1" cellspacing="3" cellspacing="1" class="tableBorder">
    <tr class="tr1">
        <td>Mario的<a href="?m=0">测试日志</a><br/>
    </tr>
    <tr>
        <td><textarea id="userId" class="text" cols="220" rows="50"
                      name="userId"><%=log%></textarea></td>
    </tr>
</table>
</body>
</html>