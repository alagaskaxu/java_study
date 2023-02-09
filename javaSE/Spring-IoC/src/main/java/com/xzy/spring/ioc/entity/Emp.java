package com.xzy.spring.ioc.entity;

public class Emp {
    /**
     * 员工姓名
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;

    public Emp() {
        System.out.println("**创建员工Emp对象**");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("对姓名属性进行赋值:"+name);
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        System.out.println("对性别属性进行赋值:"+sex);
        this.sex = sex;
    }
    public void m1(){
        System.out.println("我是初始化方法");
    }
    public void m2(){
        System.out.println("我即将从spring容器中销毁");
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
