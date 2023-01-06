<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2022/12/30
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<html>
<head>
    <title>服务器运行发生异常</title>
</head>
<body>
<span style="color: red">服务器宕机</span>
<p>原因:<%=exception.getMessage()==null?'无':exception.getMessage()%></p>
<p>类型:<%=exception.getClass().getName()%></p>
</body>
</html>
