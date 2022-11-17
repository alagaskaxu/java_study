package com.xzy.javase.thread.demo;

import com.xzy.javase.thread.entity.Store;

import java.util.ArrayList;
import java.util.List;

public class Demo03 {
    public static void main(String[] args) {
        List<String> productList = new ArrayList<>();
        productList.add("iPhone14");
        productList.add("华为M7190");
        productList.add("小米T10");
        productList.add("iPad18");
        productList.add("ThinkPad M32");
        //商铺
        Store store = new Store();
        //店铺设置商品列表
        store.setProductList(productList);
        //同一个店铺
        Thread th1 = new Thread(new Customer3Thread(store),"tom");
        Thread th2 = new Thread(new Customer3Thread(store),"jack");
        Thread th3 = new Thread(new Customer3Thread(store),"marry");
        Thread th4 = new Thread(new Customer3Thread(store),"小明");
        Thread th5 = new Thread(new Customer3Thread(store),"小王");
        Thread th6 = new Thread(new Customer3Thread(store),"小美");
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th6.start();
    }

}
