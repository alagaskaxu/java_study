package com.xzy.spring.aop.proxy.jdk.handler;

import com.xzy.spring.aop.proxy.jdk.service.IStudentService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StudentServiceInvocationHandler implements InvocationHandler {
    //目标对象
    private IStudentService target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        System.out.println("当前执行的方法是:" + methodName);
        if (!"createStudent".equals(methodName)) {
            //动态调用目标对象中的方法
            return method.invoke(target, args);
        }
        //对createStudent方法参数进行验证
        String name = (String) args[0];
        if ("".equals(name) || name == null) {
            System.out.println("未传学生姓名...");
            return -1;
        }
        int sex = (Integer)args[1];
        if (!(1==sex||2==sex)){
            System.out.println("性别状态错误...");
            return -1;
        }
        //动态调用目标对象中的方法
        return method.invoke(target, args);
    }
        /**
         * 根据目标对象动态创建代理对象
         * @param target
         * @return
         */
        public IStudentService createProxyInstance (IStudentService target){
            this.target = target;
            Class<? extends IStudentService> studentServiceClass = target.getClass();
            //获取目标对象的类加载器
            ClassLoader loader = target.getClass().getClassLoader();
            //获取目标对象实现的接口数组
            Class<?> interfaces[] = studentServiceClass.getInterfaces();
            //创建代理对象
            return (IStudentService) Proxy.newProxyInstance(loader, interfaces, this);
        }
    }
