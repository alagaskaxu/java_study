package com.xzy.javase.api.test;

import java.text.DecimalFormat;

public class TestNumberFormat {
    public static void main(String[] args) {
        //数字格式化
        DecimalFormat df1 = new DecimalFormat("#,###.#"); //# 和 0 都可以表示数字格式
        System.out.println(df1.format(11200));
        System.out.println(df1.format(11200.88));
        DecimalFormat df2 = new DecimalFormat("00.00");  //#如果没数字不会显示,用0则没数字会显示为0
        System.out.println(df2.format(3.1453));
        System.out.println(df2.format(3));
        //百分比
        DecimalFormat df3 = new DecimalFormat("0%");
        System.out.println(df3.format(0.3));
        //钱币符号
        DecimalFormat df4 = new DecimalFormat("\u00A4#");
        System.out.println(df4.format(15));
    }
}
