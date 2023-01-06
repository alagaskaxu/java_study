package com.xzy.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    private Object ob = new Object();
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //一个会话被创建,标志一个用户上线
        HttpSession session = se.getSession();
        System.out.println("新用户上线:"+session.getId());
        ServletContext context = session.getServletContext();
        synchronized (ob)
        {
            Integer count = (Integer) context.getAttribute("count");
            if (count == null){
                count = 1;  //第一个用户
            }else
            {
                count++;    //第二个用户开始
            }
            System.out.println(count);
            //将计数器count保存到WEB全局应用application对象中,所有servlet都能访问到对应的键值对
            context.setAttribute("count",count);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("用户下线:"+session.getId());
        ServletContext context = session.getServletContext();
        synchronized (ob){
            Integer count = (Integer) context.getAttribute("count");
            count--;
            context.setAttribute("count",count);
        }
    }
}
