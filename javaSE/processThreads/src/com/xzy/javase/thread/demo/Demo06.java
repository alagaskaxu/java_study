package com.xzy.javase.thread.demo;

import com.xzy.javase.thread.entity.PokerUtils;

public class Demo06 extends Thread{
    public static void main(String[] args) {
        PokerUtils pokerUtils = new PokerUtils();
        Player02Thread play01 = new Player02Thread();
        Player02Thread play02 = new Player02Thread();
        Player02Thread play03 = new Player02Thread();
        play01.setName("甲");
        play02.setName("乙");
        play03.setName("丙");
        play01.setPokerUtils(pokerUtils);
        play02.setPokerUtils(pokerUtils);
        play03.setPokerUtils(pokerUtils);
        //启动
        play01.start();
        try {
            Thread.sleep(10);  //主线程休眠一会使后面线程先不启动,避免后面的玩家线程抢占第一个玩家的线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        play02.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        play03.start();
        try {
            play01.join();  //等待play01线程结束再执行主线程该join()方法后的代码
            play02.join();
            play03.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发牌结束"); //join()使得主线程需要等待子线程运行结束后才运行改行代码
    }
}
