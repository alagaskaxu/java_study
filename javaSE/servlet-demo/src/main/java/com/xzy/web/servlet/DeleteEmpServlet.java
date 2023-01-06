package com.xzy.web.servlet;

import com.xzy.jdbc.dao.EmpDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteEmpServlet",value = "/emp/deleteEmp")
public class DeleteEmpServlet extends HttpServlet {
    EmpDao empDao = new EmpDao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String $empId = req.getParameter("empId");
        int empId = Integer.parseInt($empId);
        int rows = empDao.deleteEmpById(empId);
        resp.sendRedirect("/emp/delete_result.jsp?rows="+rows);
    }
}
