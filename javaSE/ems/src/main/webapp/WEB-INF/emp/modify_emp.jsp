<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2023/1/9
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改员工页面</title>
    <style>
        .required-input {
            color: red;
        }
    </style>
</head>
<body>
<div>
    <c:choose>
        <c:when test="${empty param.empId}">
            <span style="color: red">缺少员工ID</span>
        </c:when>
        <c:otherwise>
            <script src="/res/js/jquery.min.js"></script>
            <script src="/res/js/idCard.js"></script>

            <script>
                $(function () {
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
                            loadEmpById();
                        },
                        error: function () {
                            alert('加载部门数据失败');
                        }
                    });
                });

                /**
                 * 根据ID加载员工数据
                 */
                function loadEmpById(){
                    $.ajax({
                        url:'/emp/id',
                        type:'get',
                        data:{empId: ${param.empId}},
                        dataType: 'json',
                        cache: false,
                        success:function (jsonData){
                            console.info(jsonData);
                            if (0 != jsonData.status) {
                                alert(jsonData.message);
                                return;
                            }
                            let emp=jsonData.data;
                            if (emp.empId==0){
                                alert('员工不存在或已被删除');
                                window.close();
                                return;
                            }
                            //回填数据
                            $('#empCode').val(emp.empCode);
                            $('#empName').val(emp.empName);
                            $(':radio[name="sex"][value="'+emp.sex+'"]').prop({checked:true});
                            $('#idCard').val(emp.idCard);
                            $('#mobile').val(emp.mobile);
                            $('#birthday').val(emp.birthday);
                            $('#depSelect').val(emp.depId);
                            $('#money').val(emp.money);
                            //将员工对象挂载到window对象下,以便与修改后的值进行比较
                            window.emp = emp;
                        },
                        error:function (){
                            alert('加载部门数据失败');
                        }
                    });
                }

                /**
                 * 修改员工
                 */
                function modifyEmp(){
                    /**
                     * 获取form表单数据数组
                     *
                     * 格式:[{"name": "empCode","value": "220011"},{"name": "sex","value": "1"}...]
                     *
                     */
                    let formData = $('form:eq(0)').serializeArray();
                    console.info(formData);
                    //修改后的属性名称及属性值,JSON格式
                    let paramData = {};
                    formData.forEach(function (prop) {
                        let name = prop.name;
                        let newVal = prop.value;//form表单中某属性新值
                        let oldVal = window.emp[name];//某属性原来的值
                        if (newVal != oldVal) {
                            //当新值与旧值不相同时,说明已被修改
                            paramData[name] = newVal;
                        }
                    });
                    console.info(paramData);
                    //判断有没有属性被修改,如果一个属性都没有修改,则JSON对象为空(即没有一个key和value),就无需发送修改的业务请求
                    if ($.isEmptyObject(paramData)) {
                        alert('未对任何数据进行修改');
                        return;
                    }
                    //验证数据
                    if (paramData.hasOwnProperty('empCode')) {
                        //员工编号被修改了,需要验证
                        if ('' == paramData.empCode) {
                            alert('请填写员工编号!');
                            return;
                        }
                    }
                    if (paramData.hasOwnProperty('empName')) {
                        //员工姓名被修改了,需要验证
                        if ('' == paramData.empName) {
                            alert('请填写员工编号!');
                            return;
                        }
                    }
                    if (paramData.hasOwnProperty('idCard')) {
                        //身份证号码被修改了,需要验证
                        let idCard = paramData.idCard;
                        if ('' == idCard) {
                            alert('请填写身份证号码');
                            return;
                        }
                        if (!IdCardValidate(idCard)) {
                            alert('身份证号码错误');
                            return;
                        }
                    }
                    if (!window.confirm('确定要修改员工吗?')) {
                        return;
                    }
                    //设置员工ID
                    paramData.empId = $('#empId').val();
                    console.info(paramData);
                    $.ajax({
                        url: '/emp/modify',
                        type: 'post',
                        data: paramData,
                        cache: false,
                        dataType: 'json',
                        success: function (jsonData) {
                            if (0 != jsonData.status) {
                                alert(jsonData.message);
                                return;
                            }
                            let rows = jsonData.data;
                            console.info(jsonData);
                            if (1 == rows) {
                                alert('修改成功');
                                //刷新查询列表页面,即主页面
                                window.opener.location.reload(true);
                            } else if (0 == rows) {
                                alert('员工不存在或已被删除');
                            } else {
                                alert('修改员工,服务器返回未知的状态');
                            }
                        },
                        error: function () {
                            alert('修改员工失败!');
                        }
                    });

                }
            </script>
            <h3>修改员工</h3>
            <form action="#" method="post">
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
                    <input type="text" id="idCard" name="idCard">
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
                    <input type="hidden" id="empId" name="empId" value="${param.empId}">
                    <button type="button" onclick="modifyEmp()">修改员工</button>
                    <button type="reset">重新填写</button>
                    <button type="button" onclick="window.close()">关闭页面</button>
                </div>
            </form>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
