package com.xzy.javase.thread.test;

/**
 * Thread.sleep()方法与object对象中wait()方法的区别
 * 相同点:都可以使线程进入阻塞状态
 * 区别:
 * 1.sleep()方法休眠不会让出对象使用权(不释放对象锁),会占用资源不释放
 *  wait()方法等待会让出对象使用权,让出资源对象
 * 2.sleep()会自己醒来,即sleep时间结束后线程自己继续运行
 *  wait()可以自己醒来,或由其它线程唤醒
 */
public class Test04Thread extends Thread{

    /**
     * 共享资源
     */
    private Object ob;

    public Object getOb() {
        return ob;
    }

    public void setOb(Object ob) {
        this.ob = ob;
    }

    @Override
    public void run() {
        synchronized (ob){
            String name = Thread.currentThread().getName();
            System.out.println(name+"已运行");
            try {
                Thread.sleep(5000);
                //ob.wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
