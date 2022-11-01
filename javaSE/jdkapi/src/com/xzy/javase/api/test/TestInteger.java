package com.xzy.javase.api.test;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class TestInteger {
    public static void main(String[] args) {
        Integer i = new Integer(1);
        Integer i2 = new Integer("314"); //字符串类型的数字转成int类型,字符串必须是全数字
        //常用方法
        //基本数据类型的相互转型 valueOf()
        //将字符串格式的数字解析转换成数字int类型 valueOf(); parseInt();
        int x = Integer.valueOf("36");
        int y = Integer.parseInt("36");

        //转换进制
        //将十进制转为其它进制,以字符串格式返回
        String str1 = Integer.toBinaryString(8);    //1000 转为二进制
        System.out.println("8转为二进制:"+str1);
        String str2 = Integer.toHexString(15);    //1000 转为十六进制
        System.out.println("15转为十六进制:"+str2);


    }


}
