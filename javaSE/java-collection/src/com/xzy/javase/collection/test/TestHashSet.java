package com.xzy.javase.collection.test;

import java.util.HashSet;
import java.util.Iterator;

/**
 * HashSet类
 * HashSet中只存储了key(将key当成Map的value来使用),
 * 并且key不会重复,故使用HashSet可以达到去重的效果
 * HashSet的底层是HashMap,大部分方法一样
 * 无序的,不会自动排序也不按存放先后来存放
 */
public class TestHashSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);     //只会存在一个 1 ,set会自动去重
        set.add(null);  //可以添加一个key为null
        System.out.println("set的个数:"+set.size());
        System.out.println("set为:"+set);
        System.out.println("set是否包含 1: "+set.contains(1));
        set.add(2);
        set.add(-1);
        set.add(0);
        Boolean b = set.remove(3);  //去除元素 3 ,返回布尔值
        System.out.println(b);  //要删除的元素不存在则返回false
        //set.clear;    //清空set

        System.out.println("set为:"+set);
        //无序的[null, -1, 0, 1, 2],元素较少时,看起来可能会有序

        //遍历set中的所有元素
        System.out.println("===迭代器遍历===");
        //方法一:迭代器
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext())
        {
          Integer integer = iter.next();
            System.out.println(integer);
        }

        //方法二: foreach遍历
        System.out.println("===foreach遍历===");
        for (Integer i:set) {
            System.out.println(i);
        }

        //方法三: Lambda表达式 forEach()
        System.out.println("===forEach(Lambda表达式)遍历===");
        set.forEach((k)->{
            System.out.println(k);
        });
    }
}
