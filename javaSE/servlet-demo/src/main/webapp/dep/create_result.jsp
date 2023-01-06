<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2023/1/3
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建结果页面</title>
    <script>
        let  rows = ${param.rows};
        let page = '${param.page}';
        if (1==rows)
        {
            alert('创建成功');
        }else if (-1 == rows){
            alert('服务器异常');
        }else{
            alert('未知的操作状态');
        }
        if (page == "createDep"){
            window.location.href="/dep/create_dep.jsp";
        }
        if (page == "createEmp"){
            window.location.href="../emp/create_emp.jsp";
        }
    </script>
</head>
<body>

</body>
</html>
