package com.encapsulation.a;

/**
 * 封装的简单规则:
 * 1.属性一般使用private访问权限
 * 2.属性私有后,提供相应的get/set方法来访问相关属性,
 * get/set方法通常是public修饰的,以提供对属性的赋值与读取操作
 * (注意:boolean变量的get方法是 is 开头的)
 * 方法:一些只用于本类的辅助方法可以用private修饰,
 * 希望其它类 调用的方法用public修饰
 */
public class Users {
    private int id;
    private String name;
    private String pwd;
    private boolean admin;  //判断用户是否是超级管理员

    //get和set方法,可以附加条件,而且保证属性不会被直接乱改
    public int getId() {
        return id;
    }
    public void setId(int id) {
        if (id >0) {
            this.id = id;       //id>0才会给属性赋值
        }
    }

    //name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //get,setpwd
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    //boolean类型的get,set方法,get方法是is开头的
    public boolean isAdmin() {
        return admin;
    }   //set方法一样
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void login(){
        System.out.println(this.name+" 用户登录");
    }

}
