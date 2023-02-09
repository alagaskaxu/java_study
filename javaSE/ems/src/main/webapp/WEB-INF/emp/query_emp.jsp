<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2023/1/10
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询员工</title>
    <script src="/res/js/jquery.min.js"></script>
</head>
<body>
<div>
    <form action="/emp/list" method="post">
        <div>
            <span>员工编号</span>
            <input type="text" name="empCode" value="${param.empCode}">
        </div>
        <div>
            <span>员工姓名</span>
            <input type="text" name="empName" value="${param.empName}">
        </div>
        <div>
            <span>身份证号码:</span>
            <input type="text" name="idCard" value="${param.idCard}">
        </div>
        <div>
            <span>手机号码:</span>
            <input type="text" name="mobile" value="${param.mobile}">
        </div>
        <div>
            <button>查询</button>
        </div>
    </form>
    <c:if test="${requestScope.state == 1}">
        <div>
            <table>
                <thead>
                <th>序号</th>
                <th>编号</th>
                <th>姓名</th>
                <th>身份证号码</th>
                <th>手机号</th>
                <th>其它操作</th>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${requestScope.empList==null}">
                        <tr>
                            <td colspan="6" style="text-align: center;color: red">查询发送异常</td>
                        </tr>
                    </c:when>
                    <c:when test="${empty requestScope.empList}">
                        <tr>
                            <td colspan="6" style="text-align: center;color: gold">未查询到数据</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${requestScope.empList}" var="emp" varStatus="s">
                            <tr>
                                <td>${s.count}</td>
                                <td>${emp.empCode}</td>
                                <td>${emp.empName}</td>
                                <td>${emp.idCard}</td>
                                <td>${emp.mobile}</td>
                                <td>
                                    <button type="button" onclick="showEmpDetail(${emp.empId})">详情</button>
                                    <button type="button" onclick="modifyEmp(${emp.empId})">修改</button>
                                    <button type="button" onclick="deleteEmp(${emp.empId},'${emp.empName}')">删除</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
                </tbody>

            </table>
        </div>
        <script>
            /**
             * 显示详细信息页面
             * @param empId
             */
            function showEmpDetail(empId){
                window.open('/emp/detail?empId='+empId);
            }

            /**
             * 根据ID删除员工记录
             * @param empId
             * @param empName
             */
            function deleteEmp(empId,empName){
                if (!window.confirm("是否确认删除员工:["+empName+"]的数据吗?")){
                    return;
                }
                //利用ajax请求删除员工
                $.ajax({
                    url:'/emp/remove',
                    type:'get',
                    data:{empId:empId},
                    cache:false,
                    dataType:'json',
                    success: function (jsonData){
                        if (0!=jsonData.status){
                            alert(jsonData.message);
                            return;
                        }
                        let rows=jsonData.data;
                        if (1==rows)
                        {
                            alert('删除员工成功');
                            window.location.reload();
                        }else if (0==rows)
                        {
                            alert('员工不存在或已被删除');
                        }
                        else{
                            alert('删除员工,服务器返回未知状态');
                        }
                    },
                    error: function (){
                        alert('删除员工失败!');
                    }
                });
            }

            /**
             * 根据id打开修改员工页面
             * @param empId
             */
            function modifyEmp(empId){
                window.open('/static/emp/modify_emp.html?empId='+empId);
            }
        </script>
    </c:if>
</div>
</body>
</html>
