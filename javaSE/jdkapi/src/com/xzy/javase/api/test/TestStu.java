package com.xzy.javase.api.test;

import com.xzy.javase.api.entity.Student;

public class TestStu {
    public static void main(String[] args) {
        Student stu1 = new Student("小明","220110",1,22);
        Student stu2 = new Student("小明","220110",1,22);
        Student stu3 = new Student("小美","220112",1,20);
        System.out.println(stu1 == stu2);
        System.out.println(stu1.equals(stu2));
        System.out.println(stu1.equals(stu3));
        System.out.println(stu1.toString());
        System.out.println(stu1);
        System.out.println(stu1.hashCode());
        System.out.println(stu2.hashCode());
        System.out.println(stu3.hashCode());
        stu3 = null;
        System.gc();    //gc是JVM的销毁程序,在程序运行时用来销毁没被使用的实例对象
        /**
         * getClass:
         * getClass()方法是获得(调用该方法的)对象的类
         * 通过getClass()方法得到该对象类Class后，可以通过Class获取这个类中的相关属性和方法
         */
        Class clas = stu1.getClass();
        System.out.println("clas: "+clas);
        System.out.println("1."+stu1.getClass());
        System.out.println("2."+stu1.getClass().getName());
        System.out.println("3."+clas.getName());
        System.out.println("4."+Student.class.getName());
        System.out.println("5."+Student.class);
        // 类名.class 表示获取这个类.(类似 对象.getClass 的用法),getName获取类名
    }
}
