package com.xzy.web.mvc.controller;

import com.xzy.web.mvc.entity.MemberUser;
import com.xzy.web.mvc.service.IMemberUserService;
import com.xzy.web.mvc.service.impl.MemberUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController",value = "/member/login")
public class LoginController extends HttpServlet {
    private IMemberUserService memberUserService = new MemberUserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        MemberUser user = memberUserService.login(username,password);

    }
}
