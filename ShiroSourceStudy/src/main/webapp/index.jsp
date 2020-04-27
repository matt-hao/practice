<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="${pageContext.request.contextPath}/login/signIn" method="post">
    <p>
        <label>user name:</label>
        <input type="text" name="userName"/>
        <label>password:</label>
        <input type="text" name="password"/>
        <label>host:</label>
        <select name="host">
            <option value="TEACHER">teacher</option>
            <option value="STUDENT">student</option>
            <option value="ADMIN">admin</option>
        </select>
        <input type="reset" id="reset"/> <input type="submit" id="submit"/>
    </p>
</form>
</body>
</html>
