package com.xzy.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//urlPatterns={"完整路径","",""}在对应页面设置过滤器; value="/member.*" 用正则表达式找到匹配的页面设置过滤器
@WebFilter(filterName = "LoginCheckedFilter",urlPatterns = {"/member/member_info.jsp","/member/order.jsp","/member/update_password.jsp"})
public class LoginCheckedFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //具体过滤方法
        //转成HttpServlet对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if(request.getSession().getAttribute("user") == null){
            //未登录
            System.out.println("未登陆");
            response.sendRedirect("/login.jsp");
        }else{
            //已登陆,放行,将请求和响应原样传到对应资源
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

}
