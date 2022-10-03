package com.javastudy.innerClass;
//测试调用内外部类
public class testInnerClass {
    public static void main(String[] args) {
        //非静态内部类的对象必须寄存在一个外部类对象里
        //创建一个内部类对象,先创建一个外部类对象再利用外部类对象创建内部类对象
        Outer1.Inner1 inner1 = new Outer1().new Inner1();
        inner1.test1();

    }
}
