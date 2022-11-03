package com.xzy.javase.api.test;

/**
 * Math类
 */
public class TestMath {
    public static void main(String[] args) {
        //利用Math里的random()方法获取[0,1)的随机数
        //Math.random( )产生一个[0,1)的随机数，其返回值为double;原理:调用Random类中的nextDouble实现的
        double d = Math.random();
        System.out.println("[0,1)的随机数: "+d);
        //[0,100]的随机数
        int i = (int)(d*101);
        System.out.println("[0,100]的随机数: "+i);
        //四舍五入到个位 round();float返回int类型或double返回long类型
        long l = Math.round(3.14);
        System.out.println("3.14四舍五入:"+l);
        System.out.println("=======");

        //floor() 返回小于等于这个数的最大整数,   注意:结果返回类型为double类型
        System.out.println("<=4.1的最大整数: "+Math.floor(4.1));
        System.out.println("<=4.0的最大整数: "+Math.floor(4.0));
        System.out.println("<= -4.1的最大整数: "+Math.floor(-4.1));
        System.out.println("========");

        //ceil() 返回大于等于这个数的最大整数,   注意:结果返回类型为double类型
        System.out.println(">=5.1的最大整数: "+Math.ceil(5.1));
        System.out.println(">=5.0的最大整数: "+Math.ceil(5.0));
        System.out.println(">= -5.1的最大整数: "+Math.ceil(-5.1));

    }
}
