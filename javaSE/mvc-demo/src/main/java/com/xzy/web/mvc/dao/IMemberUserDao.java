package com.xzy.web.mvc.dao;

import com.xzy.web.mvc.entity.MemberUser;

/**
 * 会员用户DAO接口
 */
public interface IMemberUserDao {
    /**
     * 会员登陆
     * @param username 用户名
     * @param password 密码
     * @return
     */
    MemberUser login(String username, String password);
}
