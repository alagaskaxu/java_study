<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2022/12/30
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会员登陆</title>
</head>
<body>
<div>
    <h3>会员登陆</h3>
    <form action="/member/login" method="post">
        <div>
            <span>用户名:</span>
            <input type="text" name="username">
        </div>
        <div>
            <span>密码</span>
            <input type="password" name="password">
        </div>
        <div>
            <button>登陆</button>
            <button type="reset">重新填写</button>
        </div>
    </form>
</div>
</body>
</html>
