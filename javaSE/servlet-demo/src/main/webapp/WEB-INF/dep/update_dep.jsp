<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2023/1/3
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改部门页面</title>

</head>
<body>
<div>
    <c:choose>
    <c:when test="${requestScope.dep == null}">
        <span style="color:red;">加载部门数据异常</span>
    </c:when>
    <c:when test="${requestScope.dep.depId == null}">
        <span style="color:red;">部门不存在或已被删除</span>
    </c:when>
    <c:otherwise>
    <h3>修改部门</h3>
    <form action="/dep/update" method="post">
        <div><span>部门编号:</span><input type="text" name="depCode" value="${requestScope.dep.depCode}"></div>
        <div><span>部门名称:</span><input type="text" name="depName" value="${requestScope.dep.depName}"></div>
        <div>
            <span>部门状态:</span>
            <label><input type="radio" name="depState" value="1" ${1==requestScope.dep.depState?'checked':''}>使用中</label>
            <label><input type="radio" name="depState" value="9" ${9==requestScope.dep.depState?'checked':''}>停用</label>
        </div>
        <div>
            <%-- 隐藏部门ID --%>
            <input type="hidden" name="depId" value="${requestScope.dep.depId}">
            <button type="button" onclick="update()">修改部门</button>
            <button type="reset">重新填写</button>
        </div>
    </form>
    <script>
        function update(){
            if (window.confirm('确实要修改部门吗?'))
            {
                //提交表单
                document.forms[0].submit();
            }
        }
    </script>
</div>
</c:otherwise>
</c:choose>

</body>
</html>
