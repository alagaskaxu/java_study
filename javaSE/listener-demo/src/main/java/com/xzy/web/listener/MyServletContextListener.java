package com.xzy.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("***contextInitialized servlet上下文监听器实例化***");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("***contextDestroyed servlet上下文监听器销毁***");

    }
}
