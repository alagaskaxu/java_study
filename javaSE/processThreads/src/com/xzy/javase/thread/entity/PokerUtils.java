package com.xzy.javase.thread.entity;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class PokerUtils {

    private List<String> pokerList = new ArrayList<>();
    /**
     * true公平锁,多个线程按第一次申请锁的顺序固定启动,类似排队,循环时也按第一次排队的顺序继续循环
     */
    private ReentrantLock lock = new ReentrantLock(true);   //true:公平锁,false:非公平锁

    public PokerUtils() {
        for (int count=1;count<=52;count++)
        {
            pokerList.add("扑克"+count);
        }
        Collections.shuffle(pokerList);
    }

    /**
     * 获取一张扑克,手动加上公平锁,线程按JVM安排的固定顺序执行
     * @return
     */
    public String getOnePoker(){
        lock.lock();
        if (pokerList == null||pokerList.isEmpty()){
            lock.unlock();  //加锁
            return null;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String poker = pokerList.remove(0);
        lock.unlock();  //解锁
        return poker;
    }
}
