<%@ page import="com.xzy.web.entity.MemberUser" %>
<%@ page import="com.xzy.web.dao.MemberUserDao" %><%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2022/12/30
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page errorPage="../demo/errorpage.jsp" %>
<%
    //执行注册页面
    //1.获取注册页面数据
    String username = request.getParameter("username"); //填对应标签的name属性名
    String password = request.getParameter("password");
    String headImg = request.getParameter("headImg");
    MemberUser user = new MemberUser();
    user.setUsername(username);
    user.setPassword(password);
    user.setHeadImg(headImg);
    MemberUserDao memberUserDao = new MemberUserDao();
    int rows = memberUserDao.registerMemberUser(user);
    //请求转发,服务器内部跳转
    //request.getRequestDispatcher("/member/registerResult.jsp?rows="+rows).forward(request,response);
    //重定向跳转到注册结果页面,客户端跳转
    response.sendRedirect("/member/registerResult.jsp?rows="+rows);
%>
<%=rows%>

