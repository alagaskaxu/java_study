package com.xzy.web.ajax.dao;

/**
 * 会员DAO接口
 */
public interface IMemberUserDao {
    /**
     * 统计用户名,即验证用户名是否存在
     * @param username
     * @return
     */
    int countUsername(String username);
}
