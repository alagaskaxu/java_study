<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2023/1/3
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取客户端cookie</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    for (Cookie c:cookies) {
        out.println("<div>");
        out.println("name:"+c.getName()+",value:"+c.getValue());
        out.println("</div>");
    }
%>
</body>
</html>
