package com.xzy.javase.file.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

/**
 * 字节流转成字符流
 * 从控制台读取字符
 */
public class TestInputStreamReader {
    public static void main(String[] args) {
        test01();
    }
    public static void test01(){
        InputStreamReader reader = null;
        try{
            //从控制台读取
            reader = new InputStreamReader(System.in);
            while (true){
                System.out.println("请输入");
                char [] chs = new char[512];
                int count = reader.read(chs);
                String str = new String(chs,0,count);
                System.out.println(str);
                System.out.println("是否继续输入");
                int code = reader.read();
                if ('n' == code||'N' == code)
                {
                    break;
                }
                reader.read(chs);   //读取回车,去除回车
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if (reader!=null){
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
