package com.xzy.spring.ioc.test;

import com.xzy.spring.ioc.dao.IStudentDao;
import com.xzy.spring.ioc.entity.Car;
import com.xzy.spring.ioc.entity.Dep;
import com.xzy.spring.ioc.entity.Emp;
import com.xzy.spring.ioc.entity.Student;
import com.xzy.spring.ioc.service.IStudentService;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    /**
     * 从Spring(上下文)中获取一个对象(bean)
     */
    @Test
    public void test01() {
        //创建Spring上下文的对象
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:Spring-IoC.xml");
        //从spring上下文中获取StudentDao的对象
        IStudentDao studentDao = (IStudentDao) context.getBean("studentDao");
        studentDao.insertStudent(null);
        //关闭上下文
        context.close();
    }

    @Test
    public void test02() {
        //创建Spring上下文的对象
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:Spring-IoC.xml");
        //从spring上下文中获取StudentDao的对象
        IStudentService studentService = (IStudentService) context.getBean("studentService");
        studentService.createStudent(null);
        //关闭上下文
        context.close();
    }

    @Test
    public void test03() {
        //创建Spring上下文的对象
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:Spring-IoC.xml");
        //从spring上下文中获取StudentDao的对象
        IStudentService studentService = (IStudentService) context.getBean("studentService2");
        studentService.createStudent(null);
        //关闭上下文
        context.close();
    }

    @Test
    public void test04() {
        //创建Spring上下文的对象
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:Spring-IoC.xml");
        //从spring上下文中获取对象
        Student student = (Student) context.getBean("xiaoming");
        System.out.println(student);
        //关闭上下文
        context.close();
    }

    @Test
    public void test05() {
        //创建Spring上下文的对象
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:Spring-IoC.xml");
        //从spring上下文中获取对象
        Car car = (Car) context.getBean("car1");
        System.out.println(car);
        //关闭上下文
        context.close();
    }

    @Test
    public void test06() {
        //创建Spring上下文的对象
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:Spring-IoC.xml");
        //从spring上下文中获取对象
        Car car = (Car) context.getBean("car2");
        System.out.println(car);
        //关闭上下文
        context.close();
    }

    @Test
    public void test07() {
        //创建Spring上下文的对象
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:Spring-IoC.xml");
        //从spring上下文中获取对象
        Emp emp = (Emp) context.getBean("emp");
        System.out.println(emp);
        //关闭上下文
        context.close();
    }

    @Test
    public void test08() {
        //创建Spring上下文的对象
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:Spring-IoC2.xml");
        Emp emp = (Emp) context.getBean("emp");
        System.out.println(emp);
        Emp emp1 = (Emp) context.getBean("emp");
        System.out.println(emp1 == emp);
        context.close();
    }

    @Test
    public void test09() {
        //创建Spring上下文的对象
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:Spring-IoC2.xml");
        Dep dep = (Dep) context.getBean("dep");
        Dep dep1 = (Dep) context.getBean("dep");
        System.out.println(dep==dep1);
        context.close();
    }
    @Test
    public void test10() {
        //创建Spring上下文的对象
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:Spring-IoC3.xml");
        //从spring上下文中获取StudentDao的对象
        IStudentService studentService = (IStudentService) context.getBean("studentService");
        studentService.createStudent(null);
        //关闭上下文
        context.close();
    }
}
