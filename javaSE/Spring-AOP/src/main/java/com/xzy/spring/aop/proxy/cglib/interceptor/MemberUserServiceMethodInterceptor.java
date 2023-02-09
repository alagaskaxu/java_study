package com.xzy.spring.aop.proxy.cglib.interceptor;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法拦截器实现类
 */
public class MemberUserServiceMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String methodName = method.getName();
        System.out.println("当前执行的方法是:"+methodName);
        if (!"login".equals(methodName)){
            //调用代理方法
            return methodProxy.invokeSuper(o,objects);
        }
        String username = (String) objects[0];
        if ("".equals(username)||username==null){
            System.out.println("未传值用户名");
            return -1;
        }
        String password = (String) objects[1];
        if ("".equals(password)||password==null){
            System.out.println("未传值用户名");
            return -1;
        }
        return methodProxy.invokeSuper(o,objects);
    }
}
