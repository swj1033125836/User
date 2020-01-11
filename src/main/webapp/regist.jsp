<%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2020/1/4
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>

    <script type="text/javascript">
        function _change() {
            var ele = document.getElementById("verifyCodeEleId");
            ele.src = "<c:url value='/VerifyCodeServlet'/>?time=" + new Date().getTime();
        }
    </script>
</head>
<body>
    <h1>注册</h1>
    <p style="color: red; font-weight: 900" >${msg}</p>
    <form action="/User/RegistServlet" method="post">
        用户名：<input type="text" name="username"/>${errors.username}</br>
        密  码：<input type="password" name="password"/>${errors.password}</br>
        验证码：<input type="text" name="verifyCode" size="3"/>${errors.verifycode}</br>
            <img id="verifyCodeEleId" src="<c:url value='/VerifyCodeServlet'/>" alt=""/>
        <a href="javascript: _change()">看不清，换一张</a>
    <input type="submit" value="注册"/></br>
    </form>
</body>
</html>
