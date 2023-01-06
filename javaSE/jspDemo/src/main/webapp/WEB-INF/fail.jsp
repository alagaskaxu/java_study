<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2022/12/30
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆失败</title>
    <script>
        let state = '${param.state}';
        if (1 == state)
        {
            alert('服务异常');
        }else if (2 == state){
            alert('用户名或密码错误');
        }else{
            alert('未知状态');
        }
        window.location.href='/member/login.jsp';
    </script>
</head>
<body>

</body>
</html>
