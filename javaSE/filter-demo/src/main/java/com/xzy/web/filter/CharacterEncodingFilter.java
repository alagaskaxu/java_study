package com.xzy.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    public CharacterEncodingFilter(){
        System.out.println("CharacterEncodingFilter被实例化--");
    }

    private String encoding;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("CharacterEncodingFilter开始过滤--doFilter()");
        //统一设置Post请求字符编码方式
        servletRequest.setCharacterEncoding(this.encoding);
        //获取当前请求路径
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getRequestURI();
        System.out.println("当前请求路径:"+url);
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter被初始化--");
        String encoding = filterConfig.getInitParameter("encoding");
        System.out.println("encoding:"+encoding);
        this.encoding = encoding;
    }

    @Override
    public void destroy() {
        System.out.println("CharacterEncodingFilter被销毁--");
        Filter.super.destroy();
    }
}
