package com.xzy.web.ajax.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/ajax/test")
public class TestAJAXController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("name");
        System.out.println("你好!"+name);
        //响应请求,向客户端响应数据,发送对应格式html/xml的数据
        //resp.setContentType("text/html;charset=utf-8"); //数据类型与编码格式
        resp.setContentType("text/xml;charset=utf-8"); //数据类型与编码格式
        PrintWriter out = resp.getWriter();
        //out.println(name);    //text/html格式直接输出html文本 name的值

        //xml格式,输出xml文件
        StringBuffer xmlBuf = new StringBuffer();
        xmlBuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        xmlBuf.append("<root>\r\n");
        xmlBuf.append("<name>"+name+"</name>\r\n");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        xmlBuf.append("<time>"+time+"</time>\r\n");
        xmlBuf.append("</root>");
        out.println(xmlBuf.toString());
    }
}
