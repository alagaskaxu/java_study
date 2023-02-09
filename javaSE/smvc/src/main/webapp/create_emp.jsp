<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2023/1/9
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建员工</title>
    <style>
        .required-input {
            color: red;
        }
    </style>

</head>
<body>
<div>
    <h3>创建员工</h3>
    <form action="/emp/create" method="post">
        <div>
            <span>员工编号:</span>
            <input type="text" id="empCode" name="empCode">
            <span class="required-input">*</span>
        </div>
        <div>
            <span>员工姓名:</span>
            <input type="text" id="empName" name="empName">
            <span class="required-input">*</span>
        </div>
        <div>
            <span>员工性别:</span>
            <label><input type="radio" name="sex" value="1">男</label>
            <label><input type="radio" name="sex" value="2">女</label>
        </div>
        <div>
            <span>身份证号码:</span>
            <input type="text" id="idCard" name="idCard">
            <span class="required-input">*</span>
        </div>
        <div>
            <span>手机号码:</span>
            <input type="text" id="mobile" name="mobile">
            <span class="required-input">*</span>
        </div>
        <%--<div>
            <span>出生日期:</span>
            <input type="date" id="birthday" name="birthday">
        </div>--%>
        <div>
            <span>所属部门:</span>
            <%--加载部门数据--%>
            <select name="depId" id="depSelect">
                <option disabled selected>----请选择部门----</option>
            </select>
        </div>
        <div>
            <span>月薪:</span>
            <input type="number" id="money" name="money">
        </div>
        <div>
            <button>创建员工</button>
            <button type="reset">重新填写</button>
        </div>
    </form>
</div>
</body>
</html>
