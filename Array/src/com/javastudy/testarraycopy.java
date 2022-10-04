package com.javastudy;

/**
 * 测试数组的拷贝
 */
public class testarraycopy {
    public static void main(String[] args) {
        String a[] = {"阿里巴巴","京东","腾讯","网易"};
        String b[] = new String[6];
        //数组拷贝方法(源地址,源地址的开始拷贝地址,目的地址,目的地址的开始接收地址,拷贝个数(长度))
        System.arraycopy(a,1,b,0,2);
        //(源地址:a数组, 开始拷贝地址:a[1], 目的地址:b数组, 目的地址的开始接收地址:b[0], 拷贝的个数:2个元素(拷贝的长度: 2个元素的地址长度))
        for (String temp:b){
            System.out.println(temp);   //京东 腾讯 null null null null
        }

    }
}
