<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2022/12/30
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext对象常用方法</title>
</head>
<body>
<%=pageContext.getRequest()%>
<span>&nbsp&nbsp</span>
<%=pageContext.getPage()%>

<%
    /**
     * 用来在当前JSP页面进行存储值,每一个JSP都有一个pageContext对象
     * 存储值范围大小: pageContext < request < session < application
     */
    //当前页面上下文范围内添加数据、删除数据、获取数据
    pageContext.setAttribute("name","value");
    pageContext.getAttribute("name");
    pageContext.removeAttribute("name");
    //获取当前请求
    pageContext.getRequest();
    //获取当前会话
    pageContext.getSession();
    //获取当前JSP页面对象
    pageContext.getPage();
%>
</body>
</html>
