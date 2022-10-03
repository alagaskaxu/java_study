package com.javastudy.innerClass;

/**
 * 静态内部类
 * 用static修饰的内部类
 * 使用要点:
 * 1.静态内部类可以访问外部类的静态成员,不能访问外部类的普通成员
 * 2.静态内部类看做外部类的一个静态成员
 */
public class Outer2 {
    private int a = 10;
    private static int b = 20;

    //静态内部类
    static class Inner2{
        public void test(){
            //System.out.println(a);    //静态内部类不能访问外部类的普通属性/方法
            System.out.println(b);  //静态内部类可以访问外部类的静态属性/方法
        }
    }
}
