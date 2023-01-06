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
 * 修改部门
 */
@WebServlet(name = "UpdateDepServlet" ,value = "/dep/update")
public class UpdateDepServlet extends HttpServlet {
    DepDao depDao = new DepDao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String depCode = req.getParameter("depCode");
        String depName = req.getParameter("depName");
        int depState = Integer.parseInt(req.getParameter("depState"));
        int depId = Integer.parseInt(req.getParameter("depId"));
        Dep dep = new Dep(depId,depCode,depName,depState);
        int rows = depDao.updateDep(dep);
        //重定向到修改结果页面
        resp.sendRedirect("/dep/update_result.jsp?rows="+rows);
    }
}
