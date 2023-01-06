<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2023/1/3
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建部门</title>
</head>
<body>
<div>
    <h3>创建部门</h3>
    <form action="/dep/create" method="post">
        <div><span>部门编号:</span><input type="text" name="depCode"></div>
        <div><span>部门名称:</span><input type="text" name="depName"></div>
        <div>
            <button>创建部门</button>
            <button type="reset">重新填写</button>
        </div>
    </form>
</div>
</body>
</html>
