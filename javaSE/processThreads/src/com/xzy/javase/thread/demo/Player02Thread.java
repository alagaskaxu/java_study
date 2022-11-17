package com.xzy.javase.thread.demo;

import com.xzy.javase.thread.entity.PokerUtils;

public class Player02Thread extends Thread{
    private PokerUtils pokerUtils;

    public PokerUtils getPokerUtils() {
        return pokerUtils;
    }

    public void setPokerUtils(PokerUtils pokerUtils) {
        this.pokerUtils = pokerUtils;
    }

    @Override
    public void run() {
        int count = 0;  //统计获取扑克的轮次
        String name = Thread.currentThread().getName();
        while (true){
            String poker = pokerUtils.getOnePoker();
            if (poker == null){
                System.out.println(name+"抓牌结束!");
                break;
            }
            count++;
            System.out.println(name+"获得第"+count+"张扑克["+poker+"]");
        }
    }
}
