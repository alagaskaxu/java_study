package com.xzy.javase.collection.demo;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 斗地主发牌
 */
public class Demo01 {
    //存放54张扑克牌
    public static final List<String> POKER_LIST = new ArrayList<>();
    public static final int NUMBER = 13;
    //初始化54张扑克牌
    static{
        String[] color =new String[]{"红桃","黑桃","梅花","方块"};
        String[] numb =new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        for (int i = 0;i<4;i++){
            for (int j = 0;j<NUMBER;j++){
                POKER_LIST.add(color[i]+numb[j]);
            }
        }
        POKER_LIST.add("joker");
        POKER_LIST.add("BigJOKER");

    }

    public static void main(String[] args) {
        System.out.println(POKER_LIST);
        List<String> myCard = new LinkedList<>();
        shuffleCard(myCard);    //自定义洗牌程序
        System.out.println("自定义洗牌后myCard:"+myCard);
        //Collections.shuffle(POKER_LIST);    //Collections工具类里的随机打乱
        //System.out.println("调用工具类洗牌后POKER_LIST:"+POKER_LIST);
        List<String> cards1 = new ArrayList<>();
        List<String> cards2 = new ArrayList<>();
        List<String> cards3 = new ArrayList<>();
        cards1.addAll(dealCard(myCard));
        sortCards(cards1);  //理牌
        System.out.println("第一名玩家的牌:"+cards1);
        cards2.addAll(dealCard(myCard));
        sortCards(cards2);  //理牌
        System.out.println("第二名玩家的牌:"+cards2);
        cards3.addAll(dealCard(myCard));
        sortCards(cards3);  //理牌
        System.out.println("第三名玩家的牌:"+cards3);
        System.out.println("剩余牌:"+myCard);

    }

    /**
     * 随机洗牌
     * @param myCard
     */
    public static void shuffleCard(List<String> myCard) {
        myCard.addAll(POKER_LIST);
        Random rd = new Random();
        int size = POKER_LIST.size();
        for (int i = 0; i < size; i++) {
            int ran = rd.nextInt(size); //[0,54)
            String card = myCard.remove(ran);
            myCard.add(0, card);
        }
    }

    /**
     * 发牌程序
     * @param myCard
     * @return
     */
    public static List dealCard(List<String> myCard){
        List<String> cards = new ArrayList<>();
        for (int i = 0;i<17;i++)
        {
            String card = myCard.remove(0);
            cards.add(card);
        }
        return cards;
    }

    public static void sortCards(List<String> myCard){
        Map<Integer,String> pokerMap = new TreeMap<>();
        Map<Integer,String> cardsMap = new TreeMap<>();
        int pSize = POKER_LIST.size();
        int mSize = myCard.size();
        for (Integer i = 0;i < pSize;i++)
        {
            String card = POKER_LIST.get(i);
            pokerMap.put(i,card);
        }

        for (Integer i = 0;i < mSize;i++)
        {
            String card = myCard.get(i);
            for (Integer p = 0;p <pSize;p++)
            {
                String pCard = pokerMap.get(p);
                if (card == pCard)
                {
                    cardsMap.put(p,card);
                    break;
                }
            }
        }
        myCard.clear();
        for (Integer key:cardsMap.keySet()) {
            //System.out.println(cardsMap.get(key));
            String value = cardsMap.get(key);
            myCard.add(value);
        }
    }
}
