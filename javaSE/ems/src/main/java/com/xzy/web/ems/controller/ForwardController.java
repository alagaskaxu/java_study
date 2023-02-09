package com.xzy.web.ems.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "ForwardController", value = "/static/*")
public class ForwardController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取当前请求的相对路径
        String url = req.getRequestURI();
        System.out.println(url);
        if (!url.endsWith(".html")) {
            resp.sendError(404, "资源不存在");
            return;
        }
        //服务器本地jsp相对路径
        String path = "/WEB-INF" + url.replace("/static", "").replace(".html", ".jsp");
        //由相对路径得到JSP绝对路径
        String realPath = req.getServletContext().getRealPath(path);
        System.out.println(realPath);
        File jspFile = new File(realPath);
        if (jspFile.isFile()){
            req.getRequestDispatcher(path).forward(req, resp);
        }else {
            resp.sendError(404, "资源不存在");
            return;
        }
    }
}
