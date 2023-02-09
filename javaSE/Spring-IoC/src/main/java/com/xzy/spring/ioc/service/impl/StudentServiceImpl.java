package com.xzy.spring.ioc.service.impl;

import com.xzy.spring.ioc.dao.IStudentDao;
import com.xzy.spring.ioc.dao.impl.StudentDaoImpl;
import com.xzy.spring.ioc.entity.Student;
import com.xzy.spring.ioc.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//在spring上下文中配置StudentServiceImpl对象
@Service("studentService")
public class StudentServiceImpl implements IStudentService {
    //注解式自动装配,依赖注入
    @Autowired
    private IStudentDao studentDao;

    public StudentServiceImpl() {
    }

    public StudentServiceImpl(IStudentDao studentDao) {
        System.out.println("***StudentServiceImpl***");
        this.studentDao = studentDao;
    }

    @Override
    public int createStudent(Student stu) {
        //IStudentDao studentDao = new StudentDaoImpl();
        System.out.println("createStu");
        return studentDao.insertStudent(stu);
    }

    public IStudentDao getStudentDao() {
        return studentDao;
    }

    //spring自动设置Dao的实体化; DI 依赖注入原理,利用set方法设置studentDao
    public void setStudentDao(IStudentDao studentDao) {
        System.out.println("****setStudentDao***");
        this.studentDao = studentDao;
    }
}
