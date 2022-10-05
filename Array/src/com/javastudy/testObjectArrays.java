package com.javastudy;

import java.util.Arrays;

/**
 * 二维数组,利用Object数组存储表格信息,如员工信息表
 */
public class testObjectArrays {
    public static void main(String[] args) {
        //Object类数组,静态初始化
        Object[] a1 = {1001,"徐",22,"学生","2022-10-5"};
        Object[] a2 = {1002,"张三",23,"律师","2022-1-5"};
        Object[] a3 = {1003,"李四",23,"老师","2022-1-15"};

        System.out.println(Arrays.toString(a1));
        Object[][] emps = new Object[3][];  //3行的二维数组
        emps[0] = a1;   //一维数组Object类的a1数组赋值给二维数组emps的第一行
        emps[1] = a2;
        emps[2] = a3;
        //遍历数组输出
        System.out.println("---------------");
        for (int i = 0; i<emps.length; i++){
            System.out.println(Arrays.toString(emps[i]));
        }

        //方法二:利用class类实现员工表
        System.out.println("====================");
        Emp e1 = new Emp(2001,"王五",20,"老师","2022-9-1");
        Emp e2 = new Emp(2002,"xu",22,"助教","2022-9-2");
        Emp e3 = new Emp(2003,"zhangshan",23,"学生","2022-9-9");
        Emp[] employees = {e1,e2,e3};
        for (Emp temp:employees){
            System.out.println(temp);   //引用类默认使用toString方法(返回数组元素地址),重写toString方法返回数组信息
        }

    }
}

//方式二,定义一个对应数据的类(面向对象的表)
class Emp {
    private int id;
    private String name;
    private int age;
    private String job;
    private String date;

    //重写toString方法返回信息而不是默认的元素地址
    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    //构造器
    public Emp() {
    }

    public Emp(int id, String name, int age, String job, String date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.job = job;
        this.date = date;
    }

    //get和sett方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

