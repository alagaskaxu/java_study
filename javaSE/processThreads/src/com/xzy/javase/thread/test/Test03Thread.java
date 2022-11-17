package com.xzy.javase.thread.test;

/**
 * 测试线程优先级
 * setPriority(int):设置线程优先级,最低为1,最高为10
 */
public class Test03Thread extends Thread{
    @Override
    public void run() {
        String name = this.getName();
        System.out.println(name+"正在运行中...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"运行结束");
    }

    public static void main(String[] args) {
        Test03Thread th1 = new Test03Thread();
        Test03Thread th2 = new Test03Thread();
        Test03Thread th3 = new Test03Thread();
        //setName()设置线程名字
        th1.setName("tom"); //10
        th2.setName("jack");//5
        th3.setName("marry");//1
        //setPriority(int)设置优先级,最低为1,最高为10
        th1.setPriority(Thread.MAX_PRIORITY);    //最高优先级 10
        th2.setPriority(Thread.NORM_PRIORITY);  //默认优先级 5
        th3.setPriority(Thread.MIN_PRIORITY);  //最低优先级 1

        //实际运行时,JVM会尽肯根据优先级来安排进程,但不会每次都完全按优先级来
        //JVM只会将设置的优先级 作为 *用户意愿的参考* ,不会作为命令运行
        //实际运行,JVM还是会按照线程资源分配,JVM自己调度安排线程顺序
        th1.start();    //10 tom 理论上第一运行,实际可能最先运行
        th2.start();    //5 jack 理论上第二运行,实际可能最后运行
        th3.start();    //1 marry理论上最后运行,实际可能第二运行
    }
}
