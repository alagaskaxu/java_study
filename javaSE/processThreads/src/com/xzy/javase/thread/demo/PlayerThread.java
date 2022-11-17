package com.xzy.javase.thread.demo;

import com.xzy.javase.thread.entity.PokerLib;

/**
 * 玩家线程
 */
public class PlayerThread extends Thread{
    /**
     * 玩家编号
     */
    private int playerNub;
    /**
     * 一组扑克牌
     */
    private PokerLib pokerLib;

    public PlayerThread() {
    }

    public PlayerThread(int playerNub) {
        this.playerNub = playerNub;
    }

    public PlayerThread(PokerLib pokerLib) {
        this.pokerLib = pokerLib;
    }

    public PlayerThread(Runnable target, PokerLib pokerLib) {
        super(target);
        this.pokerLib = pokerLib;
    }

    public PlayerThread(ThreadGroup group, Runnable target, PokerLib pokerLib) {
        super(group, target);
        this.pokerLib = pokerLib;
    }

    public PlayerThread(String name, PokerLib pokerLib) {
        super(name);
        this.pokerLib = pokerLib;
    }

    public PlayerThread(ThreadGroup group, String name, PokerLib pokerLib) {
        super(group, name);
        this.pokerLib = pokerLib;
    }

    public PlayerThread(Runnable target, String name, PokerLib pokerLib) {
        super(target, name);
        this.pokerLib = pokerLib;
    }

    public PlayerThread(ThreadGroup group, Runnable target, String name, PokerLib pokerLib) {
        super(group, target, name);
        this.pokerLib = pokerLib;
    }

    public PlayerThread(ThreadGroup group, Runnable target, String name, long stackSize, PokerLib pokerLib) {

        super(group, target, name, stackSize);
        this.pokerLib = pokerLib;
    }

    public int getPlayerNub() {
        return playerNub;
    }

    public void setPlayerNub(int playerNub) {
        this.playerNub = playerNub;
    }

    public PokerLib getPokerLib() {
        return pokerLib;
    }

    public void setPokerLib(PokerLib pokerLib) {
        this.pokerLib = pokerLib;
    }

    @Override
    public void run() {
        int count = 0;  //记录 拿了几张牌
        String name = Thread.currentThread().getName(); //当前线程名字
        //同步块
        synchronized (pokerLib)
        {
            while (true) {
                if (pokerLib.getPokerList().isEmpty()) {
                    //已抓完牌
                    break;
                }
                //判断玩家线程编号和抽扑克牌玩家的编号是否一致
                if (this.playerNub != pokerLib.getCurrentNub()) {
                    /**
                     * 当前还没轮到该玩家抓牌,需要让出扑克的对象使用权,即释放扑克对象锁
                     * 该线程进入阻塞状态,一直等待到其它玩家线程唤醒(notify)它
                     */
                    try {
                        pokerLib.wait();    //Object里的 wait() 等待方法
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //编号正确开始摸牌
                count++;
                String poker = pokerLib.getOnePoker();
                System.out.println(name + ":获取第" + count + "张扑克[" + poker + "]");
                try {
                    //一秒模一张
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //设置下一位玩家的编号
                pokerLib.setNextPlayerNub();
                //唤醒下一个玩家的线程
                pokerLib.notify();
                //摸完牌自己的线程开始等待
                try {
                    if (!pokerLib.getPokerList().isEmpty()) {
                        //线程等待下一轮摸牌
                        pokerLib.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
