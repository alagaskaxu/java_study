package com.xzy.web.ajax.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 检查验证码
 */
@WebServlet(name = "CheckCodesController", value = "/check_codes")
public class CheckCodesController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int status; //状态
        //获取页面填写的验证码
        String codes = req.getParameter("codes");
        if (codes == null) {
            status = -1;    //客户端未传值验证码
        } else {
            //从会话中获取验证码
            String originCodes = (String) req.getSession().getAttribute(GenerateCodesServlet.RANDOM_CODE_KEY);
            if (originCodes == null) {
                status = -2;
            }else {
                //不区分大小写检查验证码是否正确
                if (originCodes.equalsIgnoreCase(codes)) {
                    status = 1; //正确
                } else {
                    status = 0;//错误
                }
                //验证码使用后作废,删除会话中的原验证码
                req.getSession().removeAttribute(GenerateCodesServlet.RANDOM_CODE_KEY);
            }

        }
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println(status);
    }

}
