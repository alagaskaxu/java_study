<%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2022/12/30
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //退出系统
    session.invalidate();   //手动结束当前会话,销毁服务器内对应客户端的session对象,即客户端状态数据销毁,连接数据销毁
    response.sendRedirect("/member/login.jsp");
%>
