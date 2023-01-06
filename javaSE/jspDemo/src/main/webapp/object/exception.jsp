<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2022/12/30
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<html>
<head>
    <title>exception对象</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
%>
<%--exception异常对象,只有异常处理页面才支持该对象--%>
<span style="color: red">服务器宕机</span>
<p>原因:<%=null == exception.getMessage() ? '无' : exception.getMessage()%>
</p>
<p>类型:<%=exception.getClass().getName()%>
</p>
</body>
</html>
