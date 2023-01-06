package com.xzy.web.servlet;

import com.xzy.jdbc.dao.EmpDao;
import com.xzy.jdbc.entity.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 新增员工
 */
@WebServlet(name = "CreateEmpServlet",value = "/emp/createEmp")
public class CreateEmpServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String empCode = req.getParameter("empCode");
        String empName = req.getParameter("empName");
        String $sex = req.getParameter("sex");
        int sex = Integer.parseInt($sex);
        String idCard = req.getParameter("idCard");
        String mobile = req.getParameter("mobile");
        String $birthday = req.getParameter("birthday");
        System.out.println($birthday);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            birthday = sdf.parse($birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String $money = req.getParameter("money");
        int money = Integer.parseInt($money==""?"0":$money);
        String $depId = req.getParameter("depId");
        int depId = Integer.parseInt($depId==""?"-1":$depId);
        Emp emp = new Emp();
        emp.setEmpCode(empCode);
        emp.setEmpName(empName);
        emp.setSex(sex);
        emp.setIdCard(idCard);
        emp.setMobile(mobile);
        emp.setBirthday(birthday);
        emp.setMoney(money);
        emp.setDepId(depId);

        EmpDao empDao = new EmpDao();
        int rows = empDao.insertEmp(emp);
        resp.sendRedirect("/dep/create_result.jsp?page=createEmp&rows="+rows);
    }
}
