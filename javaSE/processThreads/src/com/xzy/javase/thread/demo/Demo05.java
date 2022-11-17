package com.xzy.javase.thread.demo;

import com.xzy.javase.thread.test.Test04Thread;

/**
 * Thread.sleep()方法与object对象中wait()方法的区别
 */
public class Demo05 {
    public static void main(String[] args) {
        Object ob = new Object();
        Test04Thread th1 = new Test04Thread();
        Test04Thread th2 = new Test04Thread();
        th1.setOb(ob);
        th2.setOb(ob);
        th1.setName("tom");
        th2.setName("jack");
        th1.start();
        th2.start();
    }
}
