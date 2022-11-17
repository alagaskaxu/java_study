package com.xzy.javase.thread.demo;

import com.xzy.javase.thread.entity.Store;

/**
 * 顾客3线程
 */
public class Customer3Thread extends Thread{
    /**
     * 商品
     */
    private Store store;

    public Customer3Thread(){

    }

    public Customer3Thread(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        if (store == null){
            System.out.println(name+"没有参与抢购商品");
            return;
        }
        //getProduct()方法是线程同步的,在多线程抢购时不会出错
        String productName = store.getProduct();
        if (productName == null){
            System.out.println(name+"未抢到商品");
        }else{
            System.out.println(name+"用户抢到["+productName+"]");
        }
    }
}
