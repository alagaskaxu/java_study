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
    <script src="/res/js/jquery.min.js"></script>
    <script src="/res/js/idCard.js"></script>
    <script>
        $(function () {
            //加载部门数据
            $.ajax({
                url: '/dep/list_data',
                type: 'get',
                data: {depState: 1},
                dataType: 'json',
                cache: false,
                success: function (jsonData) {
                    if (0 != jsonData.status) {
                        alert(jsonData.message);
                        return;
                    }
                    let depList = jsonData.data;
                    if ($.isEmptyObject(depList)) {
                        alert('未能加载到部门数据')
                        return;
                    }
                    depList.forEach(function (dep) {
                        let depId = dep.depId;
                        let depName = dep.depName;
                        $('#depSelect').append('<option value="' + depId + '">' + depName + '</option>')
                    });
                },
                error: function () {
                    alert('加载部门数据失败');
                }
            });
            $('button[type="button"]').click(function () {
                createEmp();
            });
        });

        /**
         * 创建员工
         */
        function createEmp() {
            //验证数据
            let empCode=$('#empCode').val();
            if (''==empCode)
            {
                alert('请填写员工编号!');
                return;
            }
            let empName=$('#empName').val();
            if (''==empName)
            {
                alert('请填写员工姓名!');
                return;
            }
            let sexLength=$(':radio[name="sex"]:checked').length();
            if (0==sexLength)
            {
                alert('请填写员工性别!');
                return;
            }
            let idCard=$('#idCard').val();
            if (''==idCard)
            {
                alert('请填写身份证号码!');
                return;
            }
            if (!IdCardValidate(idCard)){
                alert('身份证号码错误!');
                return;
            }
            if (window.confirm('确定要创建员工吗')) {
                //提交表单
                $('form:eq(0)').submit();
            }
        }
    </script>
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
            <span>员工姓名号:</span>
            <input type="text" id="empName" name="empName">
            <span class="required-input">*</span>
        </div>
        <div>
            <span>性别:</span>
            <label>
                <input type="radio" name="sex" value="1">男
            </label>
            <label>
                <input type="radio" name="sex" value="2">女
            </label>
            <span class="required-input">*</span>
        </div>
        <div>
            <span>身份证号:</span>
            <input type="text" id=idCard" name="idCard">
            <span class="required-input">*</span>
        </div>
        <div>
            <span>手机号:</span>
            <input type="text" id="mobile" name="mobile">
            <span class="required-input">*</span>
        </div>
        <div>
            <span>出生日期:</span>
            <input type="date" id="birthday" name="birthday">
        </div>
        <div>
            <span>所属部门:</span>
            <%--加载部门数据--%>
            <select name="depId" id="depSelect">
                <option selected>---请选择部门---</option>
            </select>
        </div>
        <div>
            <span>月薪:</span>
            <input type="number" id="money" name="money">
        </div>
        <div>
            <button type="button">创建员工</button>
            <button type="reset">重新填写</button>
        </div>
    </form>
</div>
</body>
</html>
