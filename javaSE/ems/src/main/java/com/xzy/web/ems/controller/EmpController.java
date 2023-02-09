package com.xzy.web.ems.controller;

import com.xzy.web.ems.entity.Emp;
import com.xzy.web.ems.service.IEmpService;
import com.xzy.web.ems.service.impl.EmpServiceImpl;
import com.xzy.web.ems.vo.ResponseData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 处理员工业务请求控制器,业务包括:创建,删除,查询列表,根据ID查询,修改,详细信息
 */
@WebServlet(name = "EmpController", urlPatterns = {"/emp/create", "/emp/remove", "/emp/list", "/emp/id", "/emp/modify", "/emp/detail"})
public class EmpController extends BaseController {

    public EmpController() {
    }

    private IEmpService empService = new EmpServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断当前是哪一个业务请求
        String path = req.getServletPath();
        System.out.println(path);
        if ("/emp/create".equals(path)) {
            //创建
            createEmp(req, resp);
        } else if ("/emp/remove".equals(path)) {
            //删除
            removeEmp(req, resp);
        } else if ("/emp/list".equals(path)) {
            //查询列表
            selectList(req, resp);
        } else if ("/emp/id".equals(path)) {
            //根据ID查询
            selectById(req, resp);
        } else if ("/emp/modify".equals(path)) {
            //修改
            modifyById(req, resp);
        } else if ("/emp/detail".equals(path)) {
            //根据id查询员工详细信息
            getEmpDetail(req, resp);
        } else {
            resp.sendError(403, "访问资源不存在");
        }
    }

    /**
     * 处理员工创建请求
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void createEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        if (!method.equals("POST")) {
            resp.sendError(405, "服务器不支持的请求方式" + method);
        }
        //获取form表单参数
        Emp emp = (Emp) getBean(req, Emp.class);
        /*String empCode = req.getParameter("empCode");
        String empName = req.getParameter("empName");
        Integer sex = getInt(req, "sex");
        String idCard = req.getParameter("idCard");
        String mobile = req.getParameter("mobile");
        Date birthday = getUtilDate(req, "birthday", "yyyy-MM-dd");
        Integer money = getInt(req, "money");
        Integer depId = getInt(req, "depId");

        Emp emp = new Emp();
        emp.setEmpCode(empCode);
        emp.setEmpName(empName);
        emp.setSex(sex);
        emp.setIdCard(idCard);
        emp.setMobile(mobile);
        emp.setBirthday(birthday);
        emp.setMoney(money);
        emp.setDepId(depId);*/

        int rows = empService.createEmp(emp);
        System.out.println(emp);
        //跳转创建结果页面
        resp.sendRedirect("/static/emp/create_result.html?rows=" + rows);
    }

    /**
     * 删除员工
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void removeEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer empId = getInt(req, "empId");
        ResponseData data;
        if (empId == null) {
            data = ResponseData.FAIL(100400, "缺少参数");
        } else {
            int rows = empService.deleteById(empId);
            if (-1 == rows) {
                data = ResponseData.FAIL(100500, "服务器异常");
            } else {
                data = ResponseData.SUCCESS(rows);
            }
        }
        responseJSONData(data, resp);
    }

    /**
     * 多条件查询员工
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void selectList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //用员工实体对象打包查询
        Emp emp = (Emp) getBean(req, Emp.class);
        List<Emp> empList = empService.selectList(emp);
        req.setAttribute("empList", empList);
        req.setAttribute("state", 1);
        req.getRequestDispatcher("/WEB-INF/emp/query_emp.jsp").forward(req, resp);
    }

    /**
     * 处理根据员工id查询
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void selectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer empId = getInt(req, "empId");
        if (empId == null) {
            ResponseData data = ResponseData.FAIL(100400, "缺少参数");
            responseJSONData(data, resp);
            return;
        }
        Emp emp = empService.selectById(empId);
        if (emp == null) {
            ResponseData data = ResponseData.FAIL(100500, "加载员工数据,服务器异常");
            responseJSONData(data, resp);
            return;
        }
        ResponseData data = ResponseData.SUCCESS(emp);
        responseJSONData(data, resp);
    }

    /**
     * 根据员工id修改数据
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void modifyById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        if (!method.equals("POST")) {
            responseJSONData(ResponseData.FAIL(100405, "服务器不支持的请求方式:" + method), resp);
            return;
        }
        Emp emp = (Emp) getBean(req, Emp.class);
        int rows = empService.updateById(emp);
        if (-1 == rows) {
            //异常
            responseJSONData(ResponseData.FAIL(100500, "修改员工失败,服务器异常"), resp);
            return;
        }
        responseJSONData(ResponseData.SUCCESS(rows), resp);
    }

    /**
     * 根据ID查询员工详细信息
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void getEmpDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer empId = getInt(req, "empId");
        if (empId == null) {
            req.getRequestDispatcher("/WEB-INF/emp/emp_detail.jsp").forward(req, resp);
            return;
        }
        Emp emp = empService.selectById(empId);
        req.setAttribute("emp", emp);
        req.getRequestDispatcher("/WEB-INF/emp/emp_detail.jsp").forward(req, resp);
    }
}
