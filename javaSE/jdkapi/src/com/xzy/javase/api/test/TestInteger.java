package com.xzy.javase.api.test;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * 基本数据类型的包装类
 * int => Integer
 */
public class TestInteger {
    public static void main(String[] args) {
        Integer i = new Integer(1);
        Integer i2 = new Integer("314"); //字符串类型的数字转成int类型,字符串必须是全数字
        //常用方法
        //基本数据类型的相互转型 valueOf()
        //将字符串格式的数字解析转换成数字int类型 valueOf()返回Integer类型; parseInt();返回int基本数据类型
        int x = Integer.valueOf("36");  //返回Integer类型
        int y = Integer.parseInt("36"); //返回int基本数据类型

        //转换进制
        //将十进制转为其它进制,以字符串格式返回
        String str1 = Integer.toBinaryString(8);    //1000 转为二进制
        System.out.println("8转为二进制:"+str1);
        String str2 = Integer.toHexString(15);    //1000 转为十六进制
        System.out.println("15转为十六进制:"+str2);
        System.out.println("==========");

        /**
         * 1.装箱和拆箱
         * 装箱:用对象打包封装一个基本数据类型.如:Integer i = new Integer(10);
         * 拆箱:从包装类对象中取出基本数据类型.如:int i2 = i.intValue();
         * 2.自动装箱和自动拆箱:由编译器自动完成装箱或拆箱,jdk1.5之后才支持
         * 自动装箱:Integer i = 3;  //编译器自动封装一个i的Integer对象来存放 3
         * 自动拆箱:int i3 = new Integer(5);    //编译器自动从Integer对象中取出基本数据类型int类型的 3
         */

        //自动装箱
        Integer i3 = 3;
        //自动拆箱
        int i4 = new Integer(5);
        int i5 = Integer.valueOf(5);    //valueOf返回Integer类型后 再自动拆箱
        //手动拆箱
        int i6 = i3.intValue();
        System.out.println(i6); //3
        System.out.println("======");
        Double d = 3.99;
        double ii0 = d.doubleValue();
        System.out.println("包装Double转基本double类型: "+ii0);  //3.99
        //int ii1 = d.doubleValue();    d.doubleValue() 将Double对象 拆箱为 基本数据类型double类型的数据,返回的是double类型不能赋给int类型
        int ii1 = d.intValue();      //手动拆箱,将double类型的对象 拆成 基本数据类int类
        System.out.println("包装Double转基本int: "+ii1);  //3
        int ii2 = Double.valueOf("3.99").intValue();
        System.out.println("intValue()方法:"+ii2);    //3
        //int ii3 = Double.parseDouble("3.99").intValue();   //parseDouble()直接返回基本数据double类型
        int ii3 = (int)Double.parseDouble("3.99");   //强制转换为 int类型
        System.out.println("强制转换:"+ii3);    //3

    }

}
