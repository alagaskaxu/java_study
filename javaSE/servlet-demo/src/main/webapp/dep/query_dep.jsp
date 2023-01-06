<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2023/1/3
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询部门</title>
</head>
<body>
<form action="/dep/query" method="post">
    <label>
        <input type="radio" name="depState" value="0" ${0==param.depState?'checked':''}>全部
    </label>
    <label>
        <input type="radio" name="depState" value="1" ${1==param.depState?'checked':''}>使用中
    </label>
    <label>
        <input type="radio" name="depState" value="9" ${9==param.depState?'checked':''}>已停用
    </label>
    <button>查询</button>
</form>
<table>
    <thead>
    <th>序号</th>
    <th>部门编号</th>
    <th>部门名称</th>
    <th>部门状态</th>
    <th>操作</th>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${requestScope.depList==null}">
            <tr>
                <td colspan="5" style="text-align: center; color: red">查询时,服务器异常</td>
            </tr>
        </c:when>
        <c:when test="${empty requestScope.depList}">
            <tr>
                <td colspan="5" style="text-align: center; color: gray">未查询到任何部门数据</td>
            </tr>
        </c:when>
        <c:otherwise>
            <%--otherwise 其它情况--%>
            <c:forEach items="${requestScope.depList}" var="dep" varStatus="s">
                <tr>
                    <td>${s.count}</td>
                    <td>${dep.depCode}</td>
                    <td>${dep.depName}</td>
                    <td>
                        <c:choose>
                            <c:when test="${1==dep.depState}">
                                <span style="color:blue;">使用中</span>
                            </c:when>
                            <c:when test="${9==dep.depState}">
                                <span style="color:red;">已停用</span>
                            </c:when>
                            <c:otherwise>
                                <span style="color:gray;">未知状态</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <a href="#" onclick="deleteDep(${dep.depId},'${dep.depName}')">删除</a>
                        <a href="#" onclick="updateDep(${dep.depId})">修改</a>
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
     * 删除部门
     * @param depId
     * @param depName
     */
    function deleteDep(depId,depName){
        if (window.confirm('确实要删除部门['+depName+']吗?'))
        {
            window.open('/dep/delete?depId='+depId);
        }
    }

    function updateDep(depId){
        window.open('/dep/update/load_by_id?depId='+depId);
    }
</script>
</body>
</html>
