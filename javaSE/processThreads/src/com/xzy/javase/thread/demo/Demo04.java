package com.xzy.javase.thread.demo;

import com.xzy.javase.thread.entity.PokerLib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 多线程摸牌
 */
public class Demo04 {
    public static void main(String[] args) {
        List<String> pokerList = new ArrayList<>();
        pokerList.add("黑桃A");
        pokerList.add("黑桃2");
        pokerList.add("黑桃3");
        pokerList.add("黑桃4");
        pokerList.add("黑桃5");
        pokerList.add("红桃A");
        pokerList.add("红桃2");
        pokerList.add("红桃3");
        pokerList.add("红桃4");
        pokerList.add("红桃5");
        //洗牌
        Collections.shuffle(pokerList);
        //一组扑克牌对象
        PokerLib pokerLib = new PokerLib();
        pokerLib.setPokerList(pokerList);
        PlayerThread play1 = new PlayerThread();
        PlayerThread play2 = new PlayerThread();
        play1.setPlayerNub(1);
        play1.setName("甲");
        play2.setPlayerNub(2);
        play2.setName("乙");
        play1.setPokerLib(pokerLib);
        play2.setPokerLib(pokerLib);
        play1.start();
        play2.start();
    }
}
