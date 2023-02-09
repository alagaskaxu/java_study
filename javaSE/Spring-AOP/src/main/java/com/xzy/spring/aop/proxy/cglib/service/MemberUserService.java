package com.xzy.spring.aop.proxy.cglib.service;

public class MemberUserService {
    /**
     * 用户登陆
     * @param username
     * @param password
     * @return
     */
    public int login(String username,String password){
        System.out.println(username+"用户正在登陆...");
        return 1;
    }

}
