<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2022/12/30
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>响应对象常用方法</title>
</head>
<body>
<%
    //向客户端抛出错误状态吗
    response.sendError(500, "业务错误");
    // 重定向(客户端跳转)
    response.sendRedirect("https://www.baidu.com");
    // 设置响应内容的编码格式
    response.setContentType("text/html;charset=UTF-8");
    //设置响应的编码格式
    request.setCharacterEncoding("UTF-8");
    // 获取响应字节输出流
    response.getOutputStream();
    // 获取响应字符输出流
    response.getWriter();
%>
</body>
</html>
