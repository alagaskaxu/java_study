package com.xzy.javase.collection.test;

import sun.reflect.generics.tree.Tree;

import java.util.TreeSet;

/**
 *  TestTreeSet
 *  可以去重,可以自动排序
 *  TreeSet的底层是TreeMap,大部分方法和TreeMap一样
 *  Key不能为null,即TreeSet不能为null
 */
public class TestTreeSet {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(3);
        set.add(0);
        set.add(-1);
        set.add(9);
        set.add(5);
        set.add(0);
        //set.add(null);  //不能为null
        System.out.println(set);    //会自动排序与去重
    }
}
