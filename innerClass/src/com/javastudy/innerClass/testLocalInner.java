package com.javastudy.innerClass;

/**
 * 局部内部类:
 * 定义在方法内部的类,作用域只限于本方法,称为局部内部类
 * 局部内部类在实际开发中应用很少
 */
public class testLocalInner {
    //局部内部类:定义在方法内部的类
    public void show (){
        System.out.println("------");
        //局部内部类:作用域仅限于该方法,只能该方法内使用
        class LocalInner{
            public void run(){
                System.out.println("LocalInner.run");
            }
        }
        //在本方法中直接使用局部内部类
        new LocalInner().run(); //创建LocalInner对象(未命名对象)直接调用其run方法

    }

    public static void main(String[] args) {
        new testLocalInner().show();    //不创建实例对象,直接调用testLocaalInner类里的show方法
    }
}
