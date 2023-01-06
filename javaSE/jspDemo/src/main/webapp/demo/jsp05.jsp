<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2022/12/29
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="errorpage.jsp" %>
<html>
<head>
    <title>jsp的注释</title>
</head>
<body>
<%-- 这是jsp中的注释,在客户端网页源码看不到 --%>
<!-- 这是HTML中的注释,在客户端网页源码能看到 -->
<% int i = 3/0; %>
</body>
</html>
