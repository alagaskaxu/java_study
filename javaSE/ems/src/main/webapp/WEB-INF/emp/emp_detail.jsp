<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2023/1/10
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>员工详细</title>
</head>
<body>
<div>
    <c:choose>
        <c:when test="${empty param.empId}">
            <span style="color: red">缺少员工ID参数</span>
        </c:when>
        <c:otherwise>
            <c:choose>
                <c:when test="${requestScope.emp==null}">
                    <span style="color: red">加载员工数据时,服务器异常</span>
                </c:when>
                <c:when test="${requestScope.emp.empId==null}">
                    <span style="color: gray">未查询到数据,员工不存在或已被删除</span>
                </c:when>
                <c:otherwise>
                    <div>
                        <h3>员工详细信息</h3>
                        <div><span>员工编号:</span><span>${requestScope.emp.empCode}</span></div>
                        <div><span>员工姓名:</span><span>${requestScope.emp.empName}</span</div>
                        <div>
                            <span>性别:</span>
                            <c:choose>
                                <c:when test="${1==requestScope.emp.sex}">
                                    <span>男</span>
                                </c:when>
                                <c:when test="${2==requestScope.emp.sex}">
                                    <span>女</span>
                                </c:when>
                                <c:otherwise>
                                    <span style="color: red">未知</span>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div>
                            <span>身份证号:</span>
                            <span>${requestScope.emp.idCard}</span>
                        </div>
                        <div>
                            <span>手机号:</span>
                            <span>${requestScope.emp.mobile}</span>
                        </div>
                        <div>
                            <span>出生日期:</span>
                                <c:choose>
                                    <c:when test="${requestScope.emp.birthday==null}">
                                        <span style="color: gold">未填写出生日期</span>
                                    </c:when>
                                    <c:otherwise>
                                        <%-- 格式化输出 --%>
                                        <span>
                                            <fmt:formatDate value="${requestScope.emp.birthday}"
                                                            pattern="yyyy-MM-dd"></fmt:formatDate>
                                        </span>
                                    </c:otherwise>
                                </c:choose>
                        </div>
                        <div>
                            <span>月薪:</span>
                            <c:choose>
                                <c:when test="${requestScope.emp.money==null}">
                                    <span style="color: gold">月薪未知</span>
                                </c:when>
                                <c:otherwise>
                                    <span>${requestScope.emp.money}</span>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div>
                            <span>所属部门:</span>
                            <c:choose>
                                <c:when test="${requestScope.emp.dep==null}">
                                    <span style="color: gold">未知</span>
                                </c:when>
                                <c:when test="${requestScope.emp.dep.depId==null}">
                                    <span style="color: gold"> 未查询到部门信息</span>
                                </c:when>
                                <c:otherwise>
                                    <span>${requestScope.emp.dep.depName}</span>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
