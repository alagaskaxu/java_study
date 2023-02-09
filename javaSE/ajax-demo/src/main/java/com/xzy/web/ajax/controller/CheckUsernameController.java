package com.xzy.web.ajax.controller;

import com.alibaba.fastjson.JSONObject;
import com.xzy.web.ajax.service.IMemberUserService;
import com.xzy.web.ajax.service.impl.MemberUserServiceImpl;
import com.xzy.web.ajax.vo.ResponseData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckUsernameController" ,value = "/check_username")
public class CheckUsernameController extends BaseController {
    private IMemberUserService memberUserService = new MemberUserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        ResponseData data = memberUserService.checkUsername1(username);
        //向客户端响应JSON格式数据
        responseJSONData(data,resp);

    }
}
