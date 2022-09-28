package com.javapackage.test;   //package位于类的第一个非注释性的语句
/*
*package包机制,用来管理类
* 在不同的package包里,可以建立相同名字的class类
 */
public class Car {
    public void run() {
        System.out.println("Car.run.1");
    }
    public static void build(){
        System.out.println("静态方法导入测试build1");
    }
}
