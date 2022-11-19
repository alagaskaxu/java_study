package com.xzy.javase.Lambda.demo;

/**
 * 支付接口,抽象方法
 * jdk8后接口可以写 static静态方法 和 default默认方法,这两个都要在接口里实现
 */
public interface IPay {
    /**
     * 支付宝,默认方法
     * @param money
     * @return
     */
    default boolean aliPay(int money){
        System.out.println("jdk8接口的默认方法");
        return false;
    }

    /**
     * 微信支付,jdk8接口的静态方法
     * @param money
     * @return
     */
    static boolean wechatPay(int money){
        System.out.println("jdk8接口的静态方法");
        return false;
    }

    /**
     * 银联支付,传统接口的抽象方法
     * @param money
     * @return
     */
    boolean unionPay(int money);
}
