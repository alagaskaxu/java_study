package com.xzy.javase.thread.test;

/**
 *用户进程和守护进程
 * 用户线程(User Thread):通常定义的线程都是用户线程
 * 守护线程(Daemon Thread):指在程序运行的时候在后台提供一种通用服务的线程
 * 比如垃圾回收线程就是一个很称职的守护者,又称”后台线程”
 *
 *用户线程与守护线程关系
 * 1.守护线程为用户线程提供某种后台服务
 * 2.当所有的非守护线程结束时,程序立刻终止,
 *   同时会杀死进程中的所有守护线程,虚拟机退出执行
 *   守护线程不一定能完整执行完
 *
 * 注意:
 * 守护线程的创建:先创建一个线程对象,然后调用线程对象的setDaemon(true)方法来实现
 * thread.setDaemon(true)必须在thread.start()之前设置
 * 在Daemon线程中产生的新线程也是Daemon的
 * 守护线程应该永远不去访问固有资源,如文件、数据库,因为它会在任何时候甚至在一个操作的中间发生中断
 */
public class Test02Thread extends Thread{
    public Test02Thread() {
    }

    public Test02Thread(Runnable target) {
        super(target);
    }

    public Test02Thread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public Test02Thread(String name) {
        super(name);
    }

    public Test02Thread(ThreadGroup group, String name) {
        super(group, name);
    }

    public Test02Thread(Runnable target, String name) {
        super(target, name);
    }

    public Test02Thread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public Test02Thread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }

    @Override
    public void run() {
        String name = this.getName();
        //判断是否是用户进程
        if (this.isDaemon())
        {
            System.out.println("守护进程["+name+"]正在运行");
        }else
        {
            System.out.println("用户进程"+name+"正在结束");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (this.isDaemon())
        {
            /**
             * 当所有的非守护线程结束时,程序立刻终止,
             * 同时会杀死进程中的所有守护线程,虚拟机退出执行
             * 所以守护线程不一定会执行完整
             */
            System.out.println("守护进程["+name+"]正在结束");
        }else
        {
            System.out.println("用户进程"+name+"正在结束");
        }
    }

    public static void main(String[] args) {
        System.out.println("主线程开始");
        Test02Thread th1 = new Test02Thread("守护服务001");
        //th1设置为守护线程(后台线程)
        th1.setDaemon(true);
        //thread.setDaemon(true)必须在thread.start()之前设置
        th1.start();
        System.out.println("主线程结束");
        /**
         * 当所有的非守护线程结束时,程序立刻终止,
         * 同时会杀死进程中的所有守护线程,虚拟机退出执行
         * 所以守护线程不一定会执行完整
         */
    }
}
