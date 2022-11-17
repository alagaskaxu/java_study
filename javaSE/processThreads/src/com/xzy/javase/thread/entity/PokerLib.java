package com.xzy.javase.thread.entity;

import java.util.List;

/**
 * 一副扑克牌,或n张扑克牌
 */
public class PokerLib {

    /**
     * 当前玩家的编号
     */
    private int currentNub = 1; //当前编号,默认为1号玩家
    /**
     * 扑克牌列表
     */
    private List<String> pokerList;

    public int getCurrentNub() {
        return currentNub;
    }

    public void setCurrentNub(int currentNub) {
        this.currentNub = currentNub;
    }

    public List<String> getPokerList() {
        return pokerList;
    }

    public void setPokerList(List<String> pokerList) {
        this.pokerList = pokerList;
    }

    /**
     * 设置下一个玩家的编号
     */
    public void setNextPlayerNub(){
        this.currentNub = 1==this.currentNub? 2:1;
    }

    /**
     * 得到一张牌
     * @return 列表第一张牌
     */
    public String getOnePoker(){
        return pokerList.remove(0);
    }
}
