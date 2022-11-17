package com.xzy.javase.thread.demo;

import java.util.List;
import java.util.Random;

/**
 * 顾客2线程
 */
public class Customer2Thread extends Thread{
        /***
         * 存放商品数组
         */
        private List<String> productList;

        public Customer2Thread() {
        }

        public Customer2Thread(Runnable target) {
            super(target);
        }

        public Customer2Thread(ThreadGroup group, Runnable target) {
            super(group, target);
        }

        public Customer2Thread(String name) {
            super(name);
        }

        public Customer2Thread(ThreadGroup group, String name) {
            super(group, name);
        }

        public Customer2Thread(Runnable target, String name) {
            super(target, name);
        }

        public Customer2Thread(ThreadGroup group, Runnable target, String name) {
            super(group, target, name);
        }

        public Customer2Thread(ThreadGroup group, Runnable target, String name, long stackSize) {
            super(group, target, name, stackSize);
        }

        public List<String> getProductList() {
            return productList;
        }

        public void setProductList(List<String> productList) {
            this.productList = productList;
        }

        @Override
        public void run() {
            //从商品栈对象中"抢"(移除并获取栈顶的对象)
            //同步块,使不同步的List<String> productList加上一道锁使其变为同步的
            synchronized (productList) {
                String name = this.getName();
                if (productList.isEmpty()) {
                    System.out.println("亲爱用户:" + name + ",您本次抢购未抢到任何商品,下次加油哦!");
                    return;
                }
                String productName;
                int size = productList.size();
                if (1 == size) {
                    productName = productList.remove(0);
                } else {
                    //随机取商品
                    Random rd = new Random();
                    int index = rd.nextInt(size);
                    productName = productList.remove(index);
                }
                System.out.println("亲爱用户:" + name + ",恭喜您抢到了【" + productName + "】");
            }


        }
    }

