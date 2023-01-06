<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2023/1/4
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改结果页面</title>
</head>
<body>
<div>
    <c:choose>
        <c:when test="${1==param.rows}">
            <span style="color:blue;">修改部门成功</span>
        </c:when>
        <c:when test="${-1==param.rows}">
            <span style="color:red;">修改失败,服务器异常</span>
        </c:when>
        <c:when test="${0==param.rows}">
            <span style="color:gray;">该部门不存在或被删除</span>
        </c:when>
        <c:otherwise>
            <span style="color:red;">修改操作，服务器未知异常</span>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
