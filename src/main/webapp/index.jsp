<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h1>欢迎登录</h1>
<c:choose>
    <c:when test="${empty sessionScope.sessionUser}">请从正确路径进入！！！</c:when>
    <c:otherwise>
        ${sessionScope.sessionUser}
    </c:otherwise>
</c:choose>
</body>
</html>
