package com.xzy.spring.ioc.dao.impl;

import com.xzy.spring.ioc.dao.IStudentDao;
import com.xzy.spring.ioc.entity.Student;
import org.springframework.stereotype.Repository;

//利用注解在spring上下文中配置StudentDaoImpl对象
@Repository("studentDao")
public class StudentDaoImpl implements IStudentDao {
    @Override
    public int insertStudent(Student stu) {
        System.out.println("insertStu");
        return 0;
    }
}
