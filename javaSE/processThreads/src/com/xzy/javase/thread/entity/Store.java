package com.xzy.javase.thread.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 店铺
 */
public class Store {
    /**
     * 商品类别
     */
    private List<String> productList = new ArrayList<>();

    public List<String> getProductList() {
        return productList;
    }

    public void setProductList(List<String> productList) {
        this.productList = productList;
    }

    /**
     * synchronized表示是同步的方法，得到商品列表里的商品
     * @return
     */
    public synchronized String getProduct(){
        if (productList == null||productList.isEmpty()){
            return null;
        }
        int size = productList.size();
        if (1 == size)
        {
            return productList.remove(0);
        }
        Random rd = new Random();
        int index = rd.nextInt(size);
        return productList.remove(index);
    }
}
