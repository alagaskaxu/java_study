package com.xzy.javase.Lambda.demo;

/**
 * 测试jdk8接口支持的默认方法和静态方法
 */
public class Pay implements IPay{

    @Override
    public boolean aliPay(int money) {
        return IPay.super.aliPay(money);
    }

    @Override
    public boolean unionPay(int money) {
        return false;
    }

    public static void main(String[] args) {
        IPay iPay = new Pay();
        //jdk8的新特性,接口支持静态方法和默认方法
        iPay.aliPay(10);    //接口里的默认方法
        IPay.wechatPay(10); //接口里的静态方法
        iPay.unionPay(10);  //接口的传统抽象方法
    }
}
