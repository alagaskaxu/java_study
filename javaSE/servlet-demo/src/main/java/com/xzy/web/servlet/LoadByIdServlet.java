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
 * 根据部门id加载数据
 */
@WebServlet(name = "LoadByIdServlet",value = "/dep/update/load_by_id")
public class LoadByIdServlet extends HttpServlet {
    DepDao depDao = new DepDao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String $depId = req.getParameter("depId");
        int depId = Integer.parseInt($depId);
        Dep dep = depDao.selectById(depId);
        req.setAttribute("dep",dep);
        //请求转发跳转修改页面
        req.getRequestDispatcher("/WEB-INF/dep/update_dep.jsp").forward(req,resp);
    }
}
