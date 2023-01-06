<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2023/1/3
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除结果页面</title>
    <script>
        let rows = '${param.rows}';
        if (1==rows)
        {
            alert('删除成功');
        }else if (0==rows){
            alert('部门不存在或已被删除');
        }else if (-1==rows){
            alert('删除发生异常');
        }else{
            alert('未知操作状态');
        }
        //刷新主页面
        window.opener.location.reload();
        //关闭当前页面
        window.close();
    </script>
</head>
<body>

</body>
</html>
