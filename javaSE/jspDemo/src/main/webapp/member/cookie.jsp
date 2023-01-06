<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2023/1/3
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cookie的使用</title>
</head>
<body>
<%
    Cookie cookie = new Cookie("tag","xzy");
    cookie.setMaxAge(-1);
    //向客户端cookie写
    response.addCookie(cookie);
%>
</body>
</html>
