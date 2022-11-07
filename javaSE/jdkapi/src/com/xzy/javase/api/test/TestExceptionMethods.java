package com.xzy.javase.api.test;

/**
 * 异常类的一些方法
 */
public class TestExceptionMethods {
    public static void main(String[] args) {
        try {
            m3();
        }catch (Exception e)
        {
            System.out.println(e.getMessage()); //得到异常的信息
            System.out.println(e.getClass().getName());  //得到异常的类名
            e.printStackTrace();    //打印运行栈即在命令行打印异常信息在程序中出错的位置及原因
        }
    }
    public static void m1(){
        int i = 3/0;
    }
    public static void m2(){
        m1();
    }
    public static void m3(){
        m2();
    }
}
