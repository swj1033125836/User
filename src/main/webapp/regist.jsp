<%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2020/1/4
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>注册</h1>
    <p style="color: red; font-weight: 900" >${msg}</p>
    <form action="/User/RegistServlet" method="post">
        用户名：<input type="text" name="username"/></br>
        密  码：<input type="password" name="password"/></br>
    <input type="submit" value="注册"/></br>
    </form>
</body>
</html>
