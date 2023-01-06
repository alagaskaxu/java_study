<%@ page import="com.xzy.web.dao.MemberUserDao" %>
<%@ page import="com.xzy.web.entity.MemberUser" %><%--
  Created by IntelliJ IDEA.
  User: pit
  Date: 2022/12/30
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //执行登陆
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    MemberUserDao memberUserDao = new MemberUserDao();
    MemberUser user = memberUserDao.memberLogin(username,password);
    if (user == null)
    {
        //登陆发生异常
        //forward请求转发,服务器跳转
        request.getRequestDispatcher("/WEB-INF/fail.jsp?state=1").forward(request,response);
    }else if (user.getMemberId() == null){
        //用户名或密码错误
        request.getRequestDispatcher("/WEB-INF/fail.jsp?state=2").forward(request,response);

    }else{
        //登陆成功
        //在请求处理完，响应结束时，服务器会销毁request和response对象,无法一直存放数据
        /**
         * 通过session可以在应用程序的Web页面间进行跳转时，
         * 保存用户的状态，使整个用户会话一直存在下去，直到关闭浏览器。
         * 但是，如果在一个会话中，客户端长时间不向服务器发出请求，
         * session对象就会自动消失。这个时间取决于服务器，
         * 例如，Tomcat服务器默认为30分钟
         */
        session.setAttribute("user",user);
        //重定向跳转到会员用户中心页面,重定向的request对象会改变,无法携带数据,请求转发的request对象为同一个,可以携带数据,但在响应结束后,数据也会消失
        response.sendRedirect("/member/center.jsp");
    }
%>