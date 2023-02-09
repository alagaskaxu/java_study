package com.xzy.javase.controller;

import com.xzy.javase.annotation.WebServlet;

@WebServlet(value = "/demo",name="DemoController")
public class DemoController {
    @WebServlet(value = "/url",name = "field url")
    private String url;

    @WebServlet(value = "/service",name = "method service")
    public void method(){

    }
}
