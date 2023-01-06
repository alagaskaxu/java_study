package com.xzy.web.mvc.service;

import com.xzy.web.mvc.entity.MemberUser;

/**
 * 会员用户业务接口
 */
public interface IMemberUserService {
    /**
     * 会员用户登陆
     * @param username 用户名
     * @param password 密码
     * @return
     */
    MemberUser login(String username,String password);
}
