package com.xzy.web.mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 会员用户
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberUser {
    /**
     * 会员id
     */
    private Integer memberId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 头像url链接
     */
    private String headImg;
}
