package com.xzy.web.ajax.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.Map;

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
    /**
     * 测试属性
     */
    private Map<String,Object> map;
    /**
     * 登陆时间
     */
    @JSONField(format = "yyy-MM-dd")    //json日期的格式
    private Date loginTime = new Date();

    public MemberUser(Integer memberId, String username, String password, String headImg) {
        this.memberId = memberId;
        this.username = username;
        this.password = password;
        this.headImg = headImg;
    }
}
