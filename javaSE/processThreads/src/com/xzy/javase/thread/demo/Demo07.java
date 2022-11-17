package com.xzy.javase.thread.demo;

/**
 * java的内存模型JMM(java主内存)
 * 中间有类似缓冲的机制,将本地内存作为缓存,将数据拷贝到JVM主内存中
 * 使得不同步的多线程对共享资源修改时可能会出错,变量值无法判断是谁修改的(数据混乱)
 * Volatile 修饰符,表示 将本地内存中的变量值强制刷新到主内存中
 */
public class Demo07 {
    static int j = 0;
    public static void main(String[] args) {
        for (int c=1;c<=5;c++){
            Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    j++;
                    String name = Thread.currentThread().getName();
                    System.out.println(name+"线程,当前变量j的值为:"+j);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name+"线程,当前变量j的值为:"+j);
                }
            },"线程"+c);
            th.start();
        }
    }
}
