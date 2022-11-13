package com.xzy.javase.file.entity;

import java.io.Serializable;

/**
 * 对象序列化
 * 实现Serializable接口就能将类进行序列化
 * Serializable接口里没有方法要实现,仅作为JVM判断标志:是否需要序列化
 * 利用ObjectOutputStream类来将被标记的类 转成 序列化 字节流 输出到对应服务器,文件等指定位置
 */
public class Student implements Serializable {
    /**
     * 姓名
     */
    private String name;
    /**
     * 学号
     */
    private String stuCode;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 年龄
     */
    private Integer age;

    public Student(String name, String stuCode, Integer sex, Integer age) {
        this.name = name;
        this.stuCode = stuCode;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStuCode() {
        return stuCode;
    }

    public void setStuCode(String stuCode) {
        this.stuCode = stuCode;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", stuCode='" + stuCode + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
