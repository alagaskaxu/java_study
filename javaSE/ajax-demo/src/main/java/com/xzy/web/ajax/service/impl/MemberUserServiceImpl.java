package com.xzy.web.ajax.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xzy.web.ajax.dao.IMemberUserDao;
import com.xzy.web.ajax.dao.impl.MemberUserDaoImpl;
import com.xzy.web.ajax.service.IMemberUserService;
import com.xzy.web.ajax.vo.ResponseData;

public class MemberUserServiceImpl implements IMemberUserService {
    private IMemberUserDao memberUserDao = new MemberUserDaoImpl();
    @Override
    public String checkUsername(String username) {
        int count = memberUserDao.countUsername(username);
        JSONObject jo = new JSONObject();
        jo.put("count",count);
        //{"count" : n}
        return jo.toJSONString();
    }

    @Override
    public ResponseData checkUsername1(String username) {
        int count = memberUserDao.countUsername(username);
        if (-1 == count)
        {
            //查询发送异常
            return ResponseData.FAIL(100500,"服务器查询发送异常");
        }
        if (count > 1)
        {
            //用户表数据错误
            return ResponseData.FAIL(100400,"表数据异常");
        }
        return ResponseData.SUCCESS(count);
    }
}
