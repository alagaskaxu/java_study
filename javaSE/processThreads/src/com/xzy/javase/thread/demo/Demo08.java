package com.xzy.javase.thread.demo;
/**
 * java的内存模型JMM(java主内存)
 * 中间有类似缓冲的机制,将本地内存作为缓存,
 * 主内存会将母体数据复制给 各线程的本地内存, 各线程的本地内存会将修改的数据拷贝到JVM主内存中 , 线程未修改的变量数值不会去刷新主内存
 * 使得不同步的多线程对共享资源修改时可能会出错,变量值无法判断是否修改(数据混乱)
 * Volatile 修饰符,表示 将本地内存中的变量值强制刷新到主内存中,时时刷新主内存和本地内存的数据
 */
public class Demo08 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                try {
                    Thread.sleep(100);   //先让主线程把主内存的count数值复制完,再修改子线程的本地内存count,子线程修改完自动去刷新主内存
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter.count = 10; //子线程修改自己本地内存中的值,再将其值复制刷新给JVM主内存中
                System.out.println(name+"线程把其主内存中count改成"+counter.count);
            }
        },"tom").start();
        while(1 == counter.count){
            //主线程未修改count的值时,主线程不会去刷新(复制)主内存的值导致判断一直成功,造成死循环
            //System.out.println("主线程的本地内存中count=="+counter.count);   //print方法可能会去主内存更新新的数据,导致跳出循环
        }
        //出循环则表明主线程的本地内存的值改变了
        System.out.println("end,主线程本地内存中count:"+counter.count);
    }
    static class Counter{
        //Volatile 修饰符,表示 该变量是可变的,不稳定的
        //功能:当一个线程修改一个共享变量时,另外一个线程能读到这个修改的值,
        // 即时时刷新主内存和本地内存的数据,保持两者数据的同步
        volatile int count = 1; //volatile 使得 count的值在主内存和各线程的本地内存中保持刷新与同步
        //避免了上面代码中 因主内存修改后,主线程本地内存一直处在判断中未更新数据导致的死循环
    }
}
