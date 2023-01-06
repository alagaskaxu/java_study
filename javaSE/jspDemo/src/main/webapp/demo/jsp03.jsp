<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2022/12/29
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp基本语法</title>
</head>
<body>
<%--!声明全局变量--%>
<%! int count = 0;%>
<div>
    <span>本网页被访问</span>
    <span style="color: blue"><%=++count%></span>次
</div>
</body>
</html>
