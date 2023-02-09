package com.xzy.web.ajax.service;

import com.xzy.web.ajax.vo.ResponseData;

/**
 * 会员用户service接口,返回json数据
 */
public interface IMemberUserService {
    String checkUsername(String username);

    /**
     * 会员用户service接口,返回指定的响应数据类型
     * @param username
     * @return
     */
    ResponseData checkUsername1(String username);
}
