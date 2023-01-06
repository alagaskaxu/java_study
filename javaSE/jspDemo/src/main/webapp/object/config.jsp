<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2022/12/30
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>config对象</title>
</head>
<body>

<%-- 表示JSP(Servlet)配置相关信息--%>
<%=config.getServletName()%>
<span>&nbsp&nbsp&nbsp</span>
<%=config.getServletContext()%>
</body>
</html>
