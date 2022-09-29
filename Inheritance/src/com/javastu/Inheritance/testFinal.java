package com.javastu.Inheritance;

/**
 * final关键字
 * 修饰变量:被修饰的变量不可改变.一旦赋了初值,不能被重新赋值. final int MAX_SPEED = 120;
 * 修饰方法:该方法不可被子类重写,但是可以被重载! final void study(){}
 * 修饰类:修饰的类不能被继承.如:Math,String等. final class A {}
 */
public class testFinal {
    public static void main(String[] args) {
        final int MAX_SPEED = 120;  //变量变常量,只能赋值一次,类似c语言的define
        // MAX_SPEED = 220; //没有fianl变量值能改变
    }
}
