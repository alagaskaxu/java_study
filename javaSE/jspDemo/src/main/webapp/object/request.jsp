<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2022/12/30
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求对象常用方法</title>
</head>
<body>
<%--设置请求数据的编码格式是UTF-8避免乱码--%>
<%request.setCharacterEncoding("UTF-8");%>
<%--获取请求的参数--%>
<%=request.getParameter("name")%>
<%--获取请求的参数名枚举的数组--%>
<%=Arrays.toString(request.getParameterValues("name"))%>
<div>
    <%--获取请求路径--%>
    <%=request.getRequestURI()%>
</div>
</body>
</html>
