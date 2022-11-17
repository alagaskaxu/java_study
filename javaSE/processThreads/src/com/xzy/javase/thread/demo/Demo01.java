package com.xzy.javase.thread.demo;

import java.util.Stack;

/**
 * 多线程案例
 * 多线程同步
 * 多个顾客线程 抢购商品
 */
public class Demo01 {
    public static void main(String[] args) {
        //Stack 是 线程同步的
        Stack<String> productStack = new Stack<>();
        productStack.push("iphone");
        productStack.push("华为");
        productStack.push("小米");
        productStack.push("ipad");
        productStack.push("Thinkpad");
        //创建不同的顾客用户线程
        CustomerThread c1 = new CustomerThread("tom");
        CustomerThread c2 = new CustomerThread("jack");
        CustomerThread c3 = new CustomerThread("marry");
        CustomerThread c4 = new CustomerThread("cat");
        CustomerThread c5 = new CustomerThread("dog");
        CustomerThread c6 = new CustomerThread("xzy");
        CustomerThread c7 = new CustomerThread("007");
        CustomerThread c8 = new CustomerThread("小明");
        CustomerThread c9 = new CustomerThread("小王");
        CustomerThread c10 = new CustomerThread("小妹");

        //多个*进程*间不共享资源,每个进程都在单独的地址空间中
        //只有对应线程的栈区、程序计数器、栈指针以及函数运行使用的寄存器是线程私有的,其它资源线程共享
        //多个*线程*共享相同资源(堆区,代码区,数据区,部分共享栈区,相同的内存单元),即共享主方法中的商品栈productStack
        c1.setProductStack(productStack);
        c2.setProductStack(productStack);
        c3.setProductStack(productStack);
        c4.setProductStack(productStack);
        c5.setProductStack(productStack);
        c6.setProductStack(productStack);
        c7.setProductStack(productStack);
        c8.setProductStack(productStack);
        c9.setProductStack(productStack);
        c10.setProductStack(productStack);

        //启动线程
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
        c7.start();
        c8.start();
        c9.start();
        c10.start();
    }
}
