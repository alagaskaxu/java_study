package com.xzy.web.mvc.service.impl;

import com.xzy.web.mvc.dao.IMemberUserDao;
import com.xzy.web.mvc.dao.impl.MemberUserDaoImpl;
import com.xzy.web.mvc.entity.MemberUser;
import com.xzy.web.mvc.service.IMemberUserService;

public class MemberUserServiceImpl implements IMemberUserService {
    private IMemberUserDao memberUserDao = new MemberUserDaoImpl();
    @Override
    public MemberUser login(String username, String password) {
        return memberUserDao.login(username, password);
    }
}
