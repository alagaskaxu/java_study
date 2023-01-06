package com.xzy.web.servlet;


import com.xzy.jdbc.dao.EmpDao;
import com.xzy.jdbc.entity.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryEmpServlet",value = "/emp/queryEmp")
public class QueryEmpServlet extends HttpServlet {
    EmpDao empDao = new EmpDao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String $depId = req.getParameter("depId");
        int depId = Integer.parseInt($depId==""?"-1":$depId);
        List<Emp> empList = empDao.selectlistByDepId(depId);
        req.setAttribute("empList",empList);
        req.getRequestDispatcher("/emp/query_emp.jsp").forward(req,resp);
    }
}
