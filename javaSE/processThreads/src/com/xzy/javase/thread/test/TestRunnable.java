package com.xzy.javase.thread.test;

public class TestRunnable {
    public static void main(String[] args) {
        //匿名内部类,传Runnable接口的匿名内部类,直接重写run()方法
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                System.out.println(name+"正在运行");
            }
        },"线程名th1");
        th1.start();
    }
}
