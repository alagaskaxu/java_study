package com.xzy.web.ajax.test;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xzy.web.ajax.entity.MemberUser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FastjsonTest {
    @Test
    public void test01(){
        MemberUser user = new MemberUser(null,"tom2022","123456","/img/tom2022.png");
        String jsonStr = JSONObject.toJSONString(user, SerializerFeature.UseSingleQuotes,SerializerFeature.PrettyFormat,SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullNumberAsZero,SerializerFeature.WriteDateUseDateFormat);
        System.out.println(jsonStr);
        List<MemberUser> userList = new ArrayList<>();
        userList.add(new MemberUser(2,"jack","123","/img/2.png"));
        userList.add(new MemberUser(3,"marry","123","/img/3.png"));
        userList.add(new MemberUser(4,"daniel","123","/img/4.png"));
        String jsonStr2 = JSONObject.toJSONString(userList);
        System.out.println(jsonStr2);
        int i [] ={12,13,14,15,16};
        String jsonStr3 = JSONObject.toJSONString(i);
        System.out.println(jsonStr3);

    }

    @Test
    public void test02(){
        String jsonStr = "{'headImg':'/img/tom2022.png',memberId:1,\"password\":\"123456\",\"username\":\"tom2022\"}";
        MemberUser user = JSONObject.parseObject(jsonStr,MemberUser.class);
        System.out.println(user);
    }

}
