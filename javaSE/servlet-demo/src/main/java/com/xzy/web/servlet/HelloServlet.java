package com.xzy.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", value = "/servlet/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //向客户端返回静态HTML
        resp.setContentType("text/html;charset=utf-8");
        //获取响应字符输出流
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>欢迎使用和学习servlet</title></head>");
        out.println("<body>");
        String name = req.getParameter("name");
        out.println("<div>你好,"+name+"</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
