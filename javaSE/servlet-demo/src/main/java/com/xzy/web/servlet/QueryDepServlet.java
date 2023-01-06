package com.xzy.web.servlet;

import com.xzy.jdbc.dao.DepDao;
import com.xzy.jdbc.entity.Dep;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 部门查询
 */
@WebServlet(name = "QueryDepServlet", value = "/dep/query")
public class QueryDepServlet extends HttpServlet {
    DepDao depDao = new DepDao();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String depState$ = req.getParameter("depState");
        int depState = Integer.parseInt(depState$);
        //根据部门状态查询部门
        List<Dep> depList = depDao.selectlist(depState);
        //将查询的数据保存到请求对象中
        req.setAttribute("depList",depList);
        //请求转发,跳转到查询结果的JSP页面
        req.getRequestDispatcher("/dep/query_dep.jsp").forward(req,resp);
    }
}
