package com.xzy.spring.aop.service.impl;

import com.xzy.spring.aop.service.IMemberUserService;
import org.springframework.stereotype.Service;

@Service("memberUserService")
public class MemberUserServiceImpl implements IMemberUserService {
    @Override
    public int login(String username, String password) {
        return 0;
    }

    @Override
    public int register(String username, String password) {
        return 0;
    }

    @Override
    public int modifyPassword(int userId, String newPwd) {
        System.out.println("修改密码");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int setHeadImg(int userId, String HeadImg) {
        int i = 3/0;    //测试报错日志
        return 0;
    }
}
