package com.xzy.spring.aop.service;

public interface IMemberUserService {
    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    int login(String username,String password);

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    int register(String username,String password);

    /**
     * 修改密码
     * @param userId
     * @param newPwd
     * @return
     */
    int modifyPassword(int userId,String newPwd);

    /**
     * 设置头像
     * @param userId
     * @param HeadImg
     * @return
     */
    int setHeadImg(int userId,String HeadImg);
}
