package com.javapackage.test2;
/*
*有了package可以建相同名的类
 */
public class Car {
    public void stop(){
        System.out.println("Car.stop.2");
    }
    public static void destory(){
        System.out.println("静态方法导入测试destory1");
    }
}
