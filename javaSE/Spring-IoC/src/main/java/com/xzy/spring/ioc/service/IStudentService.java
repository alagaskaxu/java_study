package com.xzy.spring.ioc.service;

import com.xzy.spring.ioc.entity.Student;

public interface IStudentService {

    /**
     * 创建学生
     * @param stu
     * @return
     */
    int createStudent(Student stu);
}
