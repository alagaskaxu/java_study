<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2023/1/3
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询员工</title>
</head>
<body>
<form action="/emp/queryEmp" method="post">
    <input type="text" name="depId">部门id:
    <button>查询部门员工</button>
</form>
<table>
    <thead>
    <th>序号</th>
    <th>员工编号</th>
    <th>员工名称</th>
    <th>员工性别</th>
    <th>员工手机号</th>
    <th>员工月薪</th>
    <th>部门id</th>
    <th>操作</th>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${requestScope.empList==null}">
            <tr>
                <td colspan="8" style="text-align: center; color: red">查询时,服务器异常</td>
            </tr>
        </c:when>
        <c:when test="${empty requestScope.empList}">
            <tr>
                <td colspan="8" style="text-align: center; color: gray">未查询到任何部门数据</td>
            </tr>
        </c:when>
        <c:otherwise>
            <%--otherwise 其它情况--%>
            <c:forEach items="${requestScope.empList}" var="emp" varStatus="s">
                <tr>
                    <td>${s.count}</td>
                    <td>${emp.empCode}</td>
                    <td>${emp.empName}</td>
                    <td>
                        <c:choose>
                            <c:when test="${1==emp.sex}">
                                <span>男</span>
                            </c:when>
                            <c:when test="${2==emp.sex}">
                                <span>女</span>
                            </c:when>
                            <c:otherwise>
                                <span style="color:red;">未知状态</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${emp.mobile}</td>
                    <td>${emp.money}</td>
                    <td>${emp.depId}</td>

                    <td>
                        <a href="#" onclick="deleteEmp(${emp.empId},'${emp.empName}')">删除</a>
                        <a href="#">修改</a>
                        <a href="#">详情</a>
                    </td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>
<script>
    /**
     * 删除对应员工的信息
     * @param empId
     * @param empName
     */
    function deleteEmp(empId,empName){
        if (window.confirm('确实要删除员工['+empName+']的信息吗?'))
        {
            window.open('/emp/deleteEmp?empId='+empId);
        }
    }
</script>
</body>
</html>
