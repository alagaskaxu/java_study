<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2023/1/3
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新建员工数据</title>
</head>
<body>
<div>
    <h3>新建员工数据</h3>
    <form action="/emp/createEmp" method="post">
        <div><span>员工编号:</span><input type="text" name="empCode"></div>
        <div><span>员工名称:</span><input type="text" name="empName"></div>
        <div><span>员工性别:</span>
            <label><input type="radio" name="sex" value="1" checked>男</label>
            <label><input type="radio" name="sex" value="2">女</label>
        </div>
        <div><span>员工身份证号:</span><input type="text" name="idCard"></div>
        <div><span>员工手机号:</span><input type="text" name="mobile"></div>
        <div><span>员工生日:</span><input type="date" name="birthday"></div>
        <div><span>员工月薪:</span><input type="text" name="money"></div>
        <div><span>员工所在部门ID:</span><input type="text" name="depId"></div>
        <div>
            <button>新建员工</button>
            <button type="reset">重新填写</button>
        </div>
    </form>
</div>
</body>
</html>
