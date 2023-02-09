package com.xzy.javase.reflect;

import com.xzy.javase.annotation.WebServlet;
import com.xzy.javase.controller.DemoController;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/**
 * 利用反射读取注解
 */
public class Demo02 {
    public static void main(String[] args) {
        Class<DemoController> controllerClass = DemoController.class;
        //获取DemoController类使用的注解
        WebServlet webServlet = controllerClass.getDeclaredAnnotation(WebServlet.class);
        if (webServlet!=null) {
            System.out.println(webServlet);
            System.out.println(webServlet.value());
            System.out.println(webServlet.loadOnStarUp());
            System.out.println(webServlet.name());
        }

        try {
            Field f = controllerClass.getDeclaredField("url");
            WebServlet ws1 = f.getDeclaredAnnotation(WebServlet.class);
            if (ws1 !=null)
            {
                System.out.println(ws1.name());
                System.out.println(ws1.value());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        Method m = null;
        try {
            m = controllerClass.getDeclaredMethod("method");
            WebServlet ws2 = m.getDeclaredAnnotation(WebServlet.class);
            if (ws2 !=null)
            {
                System.out.println(ws2.name());
                System.out.println(ws2.value());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
