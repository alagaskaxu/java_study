<%@ page import="com.xzy.jdbc.dao.DepDao" %>
<%@ page import="com.xzy.jdbc.entity.Dep" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2022/12/29
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>部门表</title>
</head>
<body>
<%
    DepDao depDao = new DepDao();
    List<Dep> depList = depDao.selectlist(1);
%>
<table>
    <thead>
    <tr>
        <th>部门id</th>
        <th>部门编号</th>
        <th>部门名称</th>
        <th>部门状态</th>
    </tr>
    </thead>
    <tbody>
    <%
        if (depList == null) {
    %>
    <tr>
        <td colspan="5" style="color: red;text-align: center">查询发送异常</td>
    </tr>
    <%} else if (depList.isEmpty()) {%>
    <td colspan="5" style="color: gray;text-align: center">未查询到数据</td>
    <%
    } else {
        int count = 1;
        for (Dep dep : depList) {
    %>
    <tr>
        <td><%=count++%>
        </td>
        <td><%=dep.getDepCode()%>
        </td>
        <td><%=dep.getDepName()%>
        </td>
        <td><%=dep.getDepState()%>
        </td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
