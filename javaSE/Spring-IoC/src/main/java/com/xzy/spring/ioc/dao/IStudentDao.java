package com.xzy.spring.ioc.dao;

import com.xzy.spring.ioc.entity.Student;

public interface IStudentDao {
    /**
     * 添加学生
     * @param stu
     * @return
     */
    int insertStudent(Student stu);
}
