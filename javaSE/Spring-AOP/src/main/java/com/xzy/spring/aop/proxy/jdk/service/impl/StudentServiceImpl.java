package com.xzy.spring.aop.proxy.jdk.service.impl;

import com.xzy.spring.aop.proxy.jdk.service.IStudentService;

public class StudentServiceImpl implements IStudentService {
    @Override
    public int createStudent(String name, int sex) {
        System.out.println("正在添加学生,姓名:"+name+",性别:"+sex);
        return 1;
    }
}
