package com.xzy.javase.thread.demo;

import java.util.ArrayList;
import java.util.List;

public class Demo02 {
    public static void main(String[] args) {
        //ArrayList是线程不同步的,在多线程抢购时会出现bug
        //客户线程内利用 synchronized (productList) {}同步块 实现线程同步
        List<String> productList = new ArrayList<>();
        productList.add("iPhone14");
        productList.add("华为M7190");
        productList.add("小米T10");
        productList.add("iPad18");
        productList.add("ThinkPad M32");
        Customer2Thread c1 = new Customer2Thread("tom");
        Customer2Thread c2 = new Customer2Thread("cat");
        Customer2Thread c3 = new Customer2Thread("cao007");
        Customer2Thread c4 = new Customer2Thread("andy");
        Customer2Thread c5 = new Customer2Thread("jerry");
        Customer2Thread c6 = new Customer2Thread("spring");
        Customer2Thread c7 = new Customer2Thread("猪小明");
        Customer2Thread c8 = new Customer2Thread("王炸");
        Customer2Thread c9 = new Customer2Thread("陈翔");
        Customer2Thread c10 = new Customer2Thread("球球");
        c1.setProductList(productList);
        c2.setProductList(productList);
        c3.setProductList(productList);
        c4.setProductList(productList);
        c5.setProductList(productList);
        c6.setProductList(productList);
        c7.setProductList(productList);
        c8.setProductList(productList);
        c9.setProductList(productList);
        c10.setProductList(productList);
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
        c7.start();
        c8.start();
        c9.start();
        c10.start();
    }
}
