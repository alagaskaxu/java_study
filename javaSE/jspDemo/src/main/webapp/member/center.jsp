<%@ page import="com.xzy.web.entity.MemberUser" %><%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2022/12/30
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会员用户中心</title>
</head>
<body>

<%
    //从当前会话中获取用户数据
    MemberUser user = (MemberUser) session.getAttribute("user");
    if (user == null) {
        //会话中没有用户数据,重定向到会员登陆页面
        response.sendRedirect("/member/login.jsp");
    } else {
%>
<div>
    <%--   这个user是java代码里的user --%>
    <div>你好:<%=user.getUsername()%>
    </div>
    <%--  EL表达式user是  session 中的user--%>
    <div>你好:${user.username}</div>
    <div>
        <img src="${user.headImg}" width="150px">
    </div>
    <div>
        <a href="#" onclick="exit()">退出系统</a>
        <script>
            function exit() {
                if (window.confirm('是否确定退出?')) {
                    window.location.href='/member/exit.jsp';
                }
            }
        </script>
    </div>
</div>
<%}%>
</body>
</html>
