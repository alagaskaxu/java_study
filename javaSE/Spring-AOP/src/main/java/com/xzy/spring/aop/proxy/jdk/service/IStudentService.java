package com.xzy.spring.aop.proxy.jdk.service;

/**
 * 学生业务层接口
 */
public interface IStudentService {
    /**
     * 添加学生
     * @param name
     * @return
     */
    int createStudent(String name,int sex);
}
