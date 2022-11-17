package com.xzy.javase.thread.test;

/**
 * 多线程的使用方法
 * 1.自定义线程类 xxxxThread 继承Thread类
 * 2.重写run()方法
 * 3.在主线程(主方法)创建子线程对象
 * 4.在主线程用start()方法 启动子线程
 *
 * 主线程能启动子线程,子线程还可以启动新的子线程
 * 线程常用方法:
 * start():启动线程,java虚拟机调用该线程的run方法
 * run():运行线程,执行线程所要实现的具体代码
 * Thread.sleep(long millis):在指定毫秒数内让当前正在执行的线程休眠
 * join():等待该线程终止,即让该子线程先开始运行,运行结束后继续join()后面的代码
 * yield():暂停当前正在执行的线程对象,并执行其他线程
 * interrupt():中断线程
 * wait(),wait(long timeout):释放当前线程所占用资源导致当前线程等待
 * notify(),notifyAll():唤醒等待资源的线程
 * setPriority(int):设置线程优先级,最低为1,最高为10
 */
public class Test01Thread extends Thread{
    //自定义线程类 Test01Thread类
    @Override
    public void run() {
        //线程对象需要完成的事情
        System.out.println("子线程开始");
        String name = this.getName();   //获取当前线程的名字,JVM会默认自动取名,也可以自己构造时设定
        System.out.println(Thread.currentThread().getName() == name);
        System.out.println(name+"正在运行...");
        System.out.println(Thread.currentThread().getName());
        for (int n=1;n<=10;n++)
        {
            //每间隔1秒打印一次
            System.out.println("n="+n);
            //Thread.sleep() 线程睡眠()毫秒,线程暂停运行()毫秒后再运行
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("子线程结束");
    }

    public static void main(String[] args) {
        //主线程 == main
        System.out.println("主线程开始");
        //currentThread()获取当前正在运行的线程对象
        Thread mainThread = Thread.currentThread(); //当前运行的线程对象:主线程
        String mainTName = mainThread.getName();
        System.out.println(mainTName+"正在运行");
        //创建子线程对象的几种方法
        Test01Thread th1 = new Test01Thread();
        Thread th2 = new Test01Thread();    //启动效果同上
        Thread th3 = new Thread(new Test01Thread());    //效果本质上还是启用Test01Thread线程,new了两个线程
        Thread th4 = new Thread(new Test01Thread(),"线程4");  //效果同上,自定义Thread的名字
        th4.start();    //启动子线程,主线程结束后子线程运行
        /**
         * run()是子线程要运行代码的调用方法,不是启动线程的方法,直接调用run方法,还是在主线程运行run(),非多线程
         * run()方法是由线程内部自己调用的,而不是main主线程调用的
         * start()才是启动子线程的方法
         */
        try {
            //join()该方法会让主线程等待子线程运行结束后,再执行join()后的主线程代码
            th4.join(); //等待该线程终止,即让该子线程先开始运行,运行结束后继续主线程下面的代码
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程结束");
    }
}
