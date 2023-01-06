package com.xzy.web.servlet;

import com.xzy.jdbc.dao.DepDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 根据部门ID删除部门
 */
@WebServlet(name = "DeleteDepServlet",value = "/dep/delete")
public class DeleteDepServlet extends HttpServlet {
    private DepDao depDao = new DepDao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String $depId = req.getParameter("depId");
        int depId = Integer.parseInt($depId);
        int rows = depDao.deleteById(depId);
        resp.sendRedirect("/dep/delete_result.jsp?rows="+rows);
    }
}
