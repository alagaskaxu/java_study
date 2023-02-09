package com.xzy.spring.ioc.test;

import com.xzy.spring.ioc.service.IStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//spring单元测试类的注解,测试在Spring上下文容器环境下执行
@RunWith(SpringJUnit4ClassRunner.class)
//spring上下文配置文件
@ContextConfiguration("classpath:Spring-IoC4.xml")
public class TestSpringIoC2 {
    //测试注解方式自动配置依赖注入
    @Autowired
    @Qualifier("studentService")    //指定对应的名字的同一类型依赖
    private IStudentService studentService1;
    @Autowired
    //private IStudentService studentService1;
    private IStudentService studentService2;    //自动根据变量名字找到指定依赖
    @Test
    public void test01(){
        studentService2.createStudent(null);
    }
}
