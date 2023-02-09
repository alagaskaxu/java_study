package com.xzy.spring.aop.test;

import com.xzy.spring.aop.proxy.cglib.interceptor.MemberUserServiceMethodInterceptor;
import com.xzy.spring.aop.proxy.cglib.service.MemberUserService;
import com.xzy.spring.aop.proxy.jdk.handler.StudentServiceInvocationHandler;
import com.xzy.spring.aop.proxy.jdk.service.IStudentService;
import com.xzy.spring.aop.proxy.jdk.service.impl.StudentServiceImpl;
import com.xzy.spring.aop.service.IMemberUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Spring-Aop.xml")
public class TestAOP {
    @Autowired
    IMemberUserService memberUserService;
    @Test
    public void testJDKProxy(){
        //创建目标对象
        IStudentService target = new StudentServiceImpl();
        //创建处理程序(Handler)对象
        StudentServiceInvocationHandler handler = new StudentServiceInvocationHandler();
        //创建代理对象
        IStudentService studentService = handler.createProxyInstance(target);
        System.out.println(studentService.getClass());
        int result = studentService.createStudent("xxx",3);
        System.out.println(result);
    }

    /**
     * 测试cglib代理
     */
    @Test
    public void testCglibProxy(){
        //增强字节码
        Enhancer enhancer = new Enhancer();
        //设置代理对象继承的父类
        enhancer.setSuperclass(MemberUserService.class);
        //设置方法拦截器
        enhancer.setCallback(new MemberUserServiceMethodInterceptor());
        //创建cglib代理对象
        MemberUserService memberUserService = (MemberUserService) enhancer.create();
        System.out.println(memberUserService.getClass());
        int result = memberUserService.login("null","12345");
        System.out.println(result);
    }
    @Test
    public void testAOPConfig(){
        memberUserService.login("tom","123456");
    }
    @Test
    public void testAOPConfig2(){
        memberUserService.setHeadImg(1,"123456");
    }
    @Test
    public void testAOPConfig3(){
        int result = memberUserService.modifyPassword(1,"123456");
        System.out.println(result);
    }
}
