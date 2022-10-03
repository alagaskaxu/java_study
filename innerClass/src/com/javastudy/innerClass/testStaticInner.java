package com.javastudy.innerClass;

//测试调用静态内部类
public class testStaticInner {
    public static void main(String[] args) {
        //调用静态内部类,静态类不需要实例化,可以直接调用
        //通过new 外部类名.内部类名() 来创建静态内部类的对象
        Outer2.Inner2 inner2 = new Outer2.Inner2();
        inner2.test();
    }

}
