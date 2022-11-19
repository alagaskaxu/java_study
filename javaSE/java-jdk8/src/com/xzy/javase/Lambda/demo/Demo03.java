package com.xzy.javase.Lambda.demo;

import com.xzy.javase.Lambda.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Demo03 {
    public static void main(String[] args) {
        //使用无参构造方法和生产型函数接口创建学生对象
        //Supplier<Student> supplier = ()->new Student();
        Supplier<Student> supplier = Student::new;  //本质同上
        Student stu = supplier.get();
        stu.setName("tom");
        stu.setAge(18);
        stu.setSex(1);
        stu.setStuCode("001");
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("tom","001",1,18));
        studentList.add(new Student("jack","002",1,19));
        studentList.add(new Student("marry","003",2,28));
        studentList.add(new Student("小王","004",1,21));
        studentList.add(new Student("小明","005",1,25));
        //调用静态方法(printStudent()需要有一个Student类型的参数)
        //studentList.forEach((student -> Student.printStudent(student)));
        studentList.forEach(Student::printStudent);
        System.out.println("======");
        //调用成员方法(showStudent无参的方法)
        studentList.forEach(Student::showStudent);

        //调用成员方法(equalStudent()有参的方法)
        //将列表里的所有实例对象与 stu对象进行比较
        studentList.forEach(stu::equalStudent); //效果同下
        //studentList.forEach(student -> stu.equalStudent(student));
    }
}
