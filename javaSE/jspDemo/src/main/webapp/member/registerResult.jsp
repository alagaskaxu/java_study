<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2022/12/30
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册结果页面</title>
    <script>
        let rows = '${param.rows}';
        if (1==rows)
        {
            alert("注册成功");
        }else if (-1 == rows)
        {
            alert('注册失败,服务器异常');
        }else if (2 == rows)
        {
            alert('注册失败,用户名已被占用');
        }else{
            alert('服务器返回未知状态');
        }
    </script>
</head>
<body>

</body>
</html>
