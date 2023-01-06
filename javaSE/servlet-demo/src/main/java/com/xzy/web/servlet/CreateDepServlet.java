package com.xzy.web.servlet;

import com.xzy.jdbc.dao.DepDao;
import com.xzy.jdbc.entity.Dep;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 创建部门
 */
@WebServlet(name = "CreateDepServlet",value = "/dep/create")
public class CreateDepServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取创建部门form表单数据
        req.setCharacterEncoding("utf-8");
        String depCode = req.getParameter("depCode");
        String depName = req.getParameter("depName");
        Dep dep = new Dep();
        dep.setDepState(1);
        dep.setDepName(depName);
        dep.setDepCode(depCode);
        DepDao depDao = new DepDao();
        int rows = depDao.insertDep(dep);
        //重定向创建结果的页面
        resp.sendRedirect("/dep/create_result.jsp?page=createDep&rows="+rows);
    }
}
