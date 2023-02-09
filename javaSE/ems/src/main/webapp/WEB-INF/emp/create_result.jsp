<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2023/1/9
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>创建结果</title>
</head>
<body>
<div>
    <c:choose>
        <c:when test="${1==param.rows}">
            <span style="color: blue">创建成功</span>
        </c:when>
        <c:when test="${-1==param.rows}">
            <span style="color: red">服务器异常</span>
        </c:when>
        <c:otherwise>
            <span style="color: gold">未知状态</span>
        </c:otherwise>
    </c:choose>
    <a href="/static/emp/create_emp.html">再次创建员工</a>
</div>
</body>
</html>
