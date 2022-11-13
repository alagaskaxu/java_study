package com.xzy.javase.file.test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Test02 {
    public static void main(String[] args) {
        System.out.println(Charset.defaultCharset().name());
        String str = "java学习";  //java默认utf-8
        //获取str的字符串字节数组
        byte[] bs = str.getBytes(); //utf-8的字节流,一个中文三字节
        System.out.println(Arrays.toString(bs));
        try {
            byte[] bs1 = str.getBytes("GBK");   //GBK编码的str的字节流,一个中文两字节
            System.out.println(Arrays.toString(bs1));
            String str2 = new String(bs1,"GBK");
            System.out.println(str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.err.println("error");    //err,输出错误信息,红色
    }
}
