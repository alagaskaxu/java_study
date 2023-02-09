package com.xzy.sm.test;

import com.xzy.sm.entity.Emp;
import com.xzy.sm.service.IEmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:sm.xml")
public class TestSm {
    @Autowired
    private IEmpService empService;

    @Test
    public void testInsert() {
        Emp emp = new Emp();
        emp.setEmpName("jackk");
        emp.setEmpCode("230102");
        emp.setSex(1);
        emp.setDepId(2);
        emp.setMobile("13846586132");
        emp.setMoney(15000);
        int rows = empService.createEmp(emp);
        System.out.println(rows);
    }

    @Test
    public void testDelete() {
        int rows = empService.deleteById(39);
        System.out.println(rows);
    }

    @Test
    public void testUpdate() {
        Emp emp = new Emp();
        emp.setEmpId(40);
        emp.setMoney(20000);
        emp.setMobile("15933840234");
        int rows = empService.updateById(emp);
        System.out.println(rows);
    }

    @Test
    public void testSelectById() {
        Emp emp = empService.selectById(41);
        System.out.println(emp);
    }

    @Test
    public void testSelectList() {
        List<Emp> empList = empService.selectList(1,1);
        System.out.println(empList);
    }

    @Test
    public void testCount() {
        long count = empService.selectCount(2);
        System.out.println(count);
    }
    @Test
    public void testSelectEmpById() {
        Emp emp = empService.selectEmpById(40);
        System.out.println(emp);
    }
}
