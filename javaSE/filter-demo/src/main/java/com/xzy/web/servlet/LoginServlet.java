package com.xzy.web.servlet;

import com.xzy.web.dao.MemberUserDao;
import com.xzy.web.entity.MemberUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",value = "/member/login")
public class LoginServlet extends HttpServlet {
    MemberUserDao memberUserDao = new MemberUserDao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usename = req.getParameter("username");
        String password = req.getParameter("password");
        MemberUser memberUser = memberUserDao.memberLogin(usename,password);
        if (memberUser == null){
            //登陆异常
            resp.sendRedirect("/login.jsp?state=-1");
        }else if (memberUser.getMemberId() == null){
            //用户名或密码错误
            resp.sendRedirect("/login.jsp?state=0");
        }else{
            //登陆成功
            req.getSession().setAttribute("user",memberUser);
            //重定向到会员中心页面
            resp.sendRedirect("/member/member_info.jsp");
        }
    }
}
