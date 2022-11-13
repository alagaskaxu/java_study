package com.xzy.javase.file.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * BufferedInputStream 继承于FileInputStream
 * 是FileInputStream的子类
 * 效率高,自带内部缓存
 * 使用方法几乎一样,就是buffer.close()关闭时,关闭的是传入的FileInputStream对象的IO流
 */
public class TestBufferedInputStream {
    public static void main(String[] args) {
        test01();
    }

    public static void test01(){
        FileInputStream in = null;
        BufferedInputStream bufIn = null;
        try {
            in = new FileInputStream("F:\\TestFile\\1.txt");
            bufIn = new BufferedInputStream(in);
            while(true){
                byte[] bs = new byte[1024];
                int count = bufIn.read(bs);
                if (-1 == count){
                    break;
                }
                String str = new String(bs,0,count);
                System.out.println(str);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        if (bufIn!=null);
        {
            try {
                bufIn.close();
                //bufIn的close方法就是调用了FileInputStream的close方法
                //bufIn构造时传入的就是FileInputStream 的 in
                //bufIn.close时关闭的其实是是传入的 in
                //bufferInputStream关闭了,FileInputStream就不用关闭了
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
