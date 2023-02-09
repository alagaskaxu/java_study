package com.xzy.spring.smvc.controller;

import com.xzy.spring.smvc.entity.Emp;
import com.xzy.spring.smvc.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 处理员工业务请求控制器
 */
@Controller
@RequestMapping("emp")
public class EmpController {
    @Autowired
    private IEmpService empService;

    /**
     * 创建员工
     * @param emp
     * @return
     */@PostMapping("create")
    public String createEmp(Emp emp){
        int rows = empService.createEmp(emp);
        return "redirect:/create_result.jsp?rows="+rows;
    }

    /**
     * 查询用户
     * @param map
     * @return
     */
    @RequestMapping("query")
    public String queryEmp(ModelMap map){
        List<Emp> empList = empService.selectList();
        map.addAttribute("empList",empList);
        return "emp_list";
    }
    /**
     * http://127.0.0.1:8080/emp/create
     * 创建员工
     * @param emp
     * @return
     *//*
    @PostMapping("create")
    public String createEmp(Emp emp){
        System.out.println(emp);
        //跳转结果页面
        return "create_result";
    }
    @RequestMapping("create1")
    public String createEmp(@RequestParam("emp_name") String empName, int sex, String empCode, Emp emp, Map<String,Object> paramMap, HttpServletRequest request){
        System.out.println(empCode+">"+empName+">"+sex+">"+request.getParameter("mobile"));
        return "/create_result.jsp";
    }

    *//**
     * 根据部门ID和性别查询(请求转发方法)
     * @param sex
     * @param depId
     * @return
     *//*
    @RequestMapping("query")
    public ModelAndView queryEmp(int sex,int depId){
        ModelAndView mv = new ModelAndView();
        mv.addObject("time",new Date());
        mv.setViewName("/emp_list.jsp");
        return mv;
    }

    *//**
     * 删除员工信息(重定向方法)
     * @param empId
     * @return
     *//*
    @RequestMapping("delete")
    public ModelAndView deleteEmp(int empId){
        ModelAndView mv = new ModelAndView();
        //设定重定向方法
        mv.setView(new RedirectView("/delete_result.jsp"));
        return mv;
    }
    @RequestMapping("query1")
    public String queryEmp1(int sex,int depId,Map<String,Object> map){
        map.put("name","tom");
        map.put("age",23);
        return "/emp_list.jsp";
    }
    @RequestMapping("query2")
    public String queryEmp(Model model){
        model.addAttribute("mobile","1385967465");
        return "/emp_list.jsp";
    }
    @RequestMapping("query3")
    public String queryEmp(ModelMap mm){
        mm.addAttribute("depName","开发部");
        return "/emp_list.jsp";
    }
    @RequestMapping("query4")
    public String queryEmp(HttpServletRequest request){
        request.setAttribute("birthday","2000-02-01");
        return "/emp_list.jsp";
    }*/

}
