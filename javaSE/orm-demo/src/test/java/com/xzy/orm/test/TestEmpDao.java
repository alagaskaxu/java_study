package com.xzy.orm.test;

import com.xzy.orm.dao.impl.EmpDaoImpl;
import com.xzy.orm.entity.Emp;
import com.xzy.orm.dao.impl.EmpDaoImpl;
import com.xzy.orm.entity.Emp;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class TestEmpDao {
    private EmpDaoImpl empDao = new EmpDaoImpl();

    /**
     * 创建
     */
    @Test
    public void testInsert() {
        EmpDaoImpl empDao = new EmpDaoImpl();
        Emp emp = new Emp();
        emp.setEmpCode("230010");
        emp.setEmpName("张小强");
        emp.setMobile("13852211768");
        emp.setIdCard("320111200308041587");
        emp.setMoney(10000);
        emp.setSex(2);
        emp.setDepId(1);
        emp.setBirthday(new Date(2003 - 1900, 7, 4));
        int rows = empDao.insertEmp(emp);
        System.out.println("操作影响行数:" + rows);
    }

    /**
     * 删除
     */
    @Test
    public void testDeleteById() {
        int rows = empDao.deleteById(3);
        System.out.println("操作影响行数:" + rows);
    }

    /**
     * 修改
     */
    @Test
    public void testUpdateById() {
        Emp emp = new Emp();
        //emp.setEmpCode("230010");
        //emp.setEmpName("张小强");
        emp.setEmpId(4);
        emp.setMobile("13852212768");
        //emp.setIdCard("320111200308041587");
        emp.setMoney(30000);
        emp.setDepId(3);
        int rows = empDao.updateById(emp);
        System.out.println("操作影响行数:" + rows);
    }

    /**
     * 条件查询
     */
    @Test
    public void testSelectList() {
        Emp emp = new Emp();
        emp.setSex(1);
        emp.setDepId(2);
        emp.setEmpName("王小强");
        List<Emp> empList = empDao.selectList(emp);
        System.out.println(empList);
    }

    /**
     * 根据ID查询
     */
    @Test
    public void testSelectById() {
        Emp emp = empDao.selectById(4);
        System.out.println(emp);
    }
}
