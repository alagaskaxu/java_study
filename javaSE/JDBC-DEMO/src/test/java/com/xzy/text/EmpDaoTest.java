package com.xzy.text;

import com.xzy.jdbc.dao.EmpDao;
import com.xzy.jdbc.entity.Emp;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class EmpDaoTest {
    @Test
    public void testInsert(){
        EmpDao empDao = new EmpDao();
        Emp emp = new Emp();
        emp.setEmpCode("200001");
        emp.setEmpName("王小二");
        emp.setSex(1);
        emp.setMobile("13987655895");
        emp.setMoney(7000);
        emp.setBirthday(new Date(2000,9,9));
        emp.setDepId(1);
        emp.setIdCard("00000000");
        int rows =  empDao.insertEmp(emp);
        System.out.println(rows);
    }
    @Test
    public void selectTest(){
        EmpDao empDao = new EmpDao();
        List<Emp> empList = empDao.selectlist(4000,10000,1);
        for (Emp emp:empList) {
            System.out.println(emp);
        }
    }
}
