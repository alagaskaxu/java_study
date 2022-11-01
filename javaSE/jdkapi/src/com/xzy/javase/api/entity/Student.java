package com.xzy.javase.api.entity;

/**
 * 学生实体类
 */
public class Student
{
    /**
     * 姓名
     */
    private String name;
    /**
     * 学号
     */
    private String stuCode;
    /**
     * 性别(1:男,2:女)
     */
    private int sex;

    /**
     * 年龄
     */
    private int age;

    //无参构造器
    public Student() {
    }

    public Student(String name, String stuCode, int sex, int age) {
        this.name = name;
        this.stuCode = stuCode;
        this.sex = sex;
        this.age = age;
    }
    /**
     * get方法与set方法,访问私有属性
     */
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 重写Object的基本方法
     */
    @Override
    public String toString() {
        return "姓名:'" + this.name + '\'' +
                ", 学号:'" + stuCode + '\'' +
                ", 性别" + sex +
                ", 年龄" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return name.hashCode()+stuCode.hashCode()+sex+age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
        {
            return false;
        }
        //判断传入的obj对象是不是学生类型
        //instanceof 判断前面的对象是否属于后面的类，或者属于其子类
        if (!(obj instanceof Student))
        {
            return false;
        }
        //比较学生对象的值是否相同
        Student stu =(Student) obj; //向下转换,强制转换,将父类转为子类引用
        //比较两个字符串是否相等用String里的equals方法
        if (!this.name.equals(stu.name))
        {
            return false;
        }
        if (!this.stuCode.equals(stu.stuCode))
        {
            return false;
        }
        if (this.sex != stu.sex)
        {
            return false;
        }
        if (this.age != stu.age)
        {
            return false;
        }
        return true;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.name+"对象正在销毁");
    }

}
