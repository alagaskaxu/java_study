package com.xzy.web.ems.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    public CharacterEncodingFilter() {
        System.out.println("CharacterEncodingFilter被实例化--->CharacterEncodingFilter()");
    }

    private String encoding;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //统一设置POST请求字符编码方式
        servletRequest.setCharacterEncoding(this.encoding);
        //获取当前请求路径
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        String url=request.getRequestURI();
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
          String encoding=filterConfig.getInitParameter("encoding");
          System.out.println(encoding);
          this.encoding=encoding;
          System.out.println("CharacterEncodingFilter被初始化--->init()");
    }

    @Override
    public void destroy() {
        System.out.println("CharacterEncodingFilter被销毁--->destroy()");
    }
}
