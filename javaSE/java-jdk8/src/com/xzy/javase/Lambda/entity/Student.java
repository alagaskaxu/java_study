package com.xzy.javase.Lambda.entity;

/**
 * 学生类
 */
public class Student {
    /**
     * 学生姓名
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

    public Student() {
    }

    public Student(String name, String stuCode) {
        this.name = name;
        this.stuCode = stuCode;
    }

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

    /**
     * 静态方法打印指定学生对象信息
     * @param stu
     */
    public static void printStudent(Student stu){
        if (stu!=null)
        {
            System.out.println(stu);
        }
    }

    /**
     * 无参的打印当前学生信息
     */
    public void showStudent(){
        System.out.println(this);
    }
    public void equalStudent(Student stu){
        if (stu == null)
        {
            System.out.println("false");
        }
        System.out.println(this.toString().equals(stu.toString()));
    }
}
