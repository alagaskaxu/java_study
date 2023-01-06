<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2022/12/30
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application对象</title>
</head>
<body>
<%
    /**
     * WEB应用全局对象(Servlet上下文对象)在整个WEB应用或项目中是唯一,
     * 每一个WEB应用或项目都有一个这样的对象,
     * 该对象在启动WEB容器或服务器(如:Tomcat)时被创建,
     * 关闭时被销毁.每个会话或用户都可以操作该对象,
     * 可用于在整个WEB应用或项目中进行"共享数据
     */
    //获取WEB应用根目录名称
    application.getContextPath();
//获取WEB资源在服务器中实际的路径
    application.getRealPath("test_application.jsp");
//整个WEB应用范围内添加数据、获取数据、删除数据
    application.setAttribute("name","value")
    application.getAttribute("name");
    application.removeAttribute("name");
%>
</body>
</html>
