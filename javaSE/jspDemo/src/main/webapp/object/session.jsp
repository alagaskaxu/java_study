<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2022/12/30
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session常用方法</title>
</head>
<body>
<%
    //是否是新的Session，一般在第一次访问的时候出现
    session.isNew();
    //获取会话ID
    session.getId();
    //手动杀死会话
    session.invalidate();
    //获取WEB全局应用对象(Servlet上下文对象)
    session.getServletContext();
    //会话范围内添加数据、获取数据、删除数据
    session.setAttribute("name","value");   //属性名,属性值
    session.getAttribute("name");
    session.removeAttribute("name");
%>
</body>
</html>
