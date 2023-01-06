package com.xzy.web.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//loadOnStartup 设置servlet什么时候实例化,默认为-1:访问servlet时实例化与初始化; >=0:tomcat服务器启动时实例化与初始化servlet
@WebServlet(name = "TestServlet",value = "/test" ,loadOnStartup = 0)
public class TestServlet extends HttpServlet {
    public TestServlet(){
        System.out.println("TestServlet被实例化--TestServlet()");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("TestServlet被初始化---init()");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //获取初始化参数
        String name = config.getInitParameter("name");
        String version = config.getInitParameter("version");
        System.out.println("name:"+name+",version:"+version);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TestServlet正在服务---service()");
        String method = req.getMethod();
        System.out.println("当前请求方式:"+method);
        super.service(req,resp);    //让父类service判断用doGet方法还是doPost方法
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet方法");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost方法");
    }

    @Override
    public void destroy() {
        System.out.println("TestServlet将要被移除---destroy()");
    }
}
