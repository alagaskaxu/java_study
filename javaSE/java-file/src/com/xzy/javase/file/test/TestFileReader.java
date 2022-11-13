package com.xzy.javase.file.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reader抽象类,将字节流转换成字符流,读取文本内容
 * 以字符为单位读取
 * FileReader 继承于 InputStreamReader 继承于 Reader,将字节流转换成字符流
 * FileReader,以字符为单位,一个字符可能为一字节-四字节大小,read()一次读取一个字符
 * FileInputStream,以字节为单位,read()一次只读取 8位二进制的字节byte单位
 */
public class TestFileReader {
    public static void main(String[] args) {
        test01();
        test02();
    }
    public static void test01(){
        FileReader reader = null;
        try {
            File file = new File("F:\\TestFile\\1.txt");
            reader = new FileReader(file);
            while(true)
            {
                //FileReader.read() 读取一个字符,按一个字符为单位读取,返回字符的编码值,以int类型返回,没字符数据返回-1
                int charPoint = reader.read();
                if (-1 == charPoint)
                {
                    break;
                }
                System.out.println(charPoint);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        if (reader!=null)
        {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void test02(){
        FileReader reader = null;
        try {
            File file = new File("F:\\TestFile\\1.txt");
            reader = new FileReader(file);
            while(true)
            {
                //FileReader.read(char[]) 读取字符,按字符数组为单位读取,返回字符数组的元素个数,以int类型返回,数组内没字符返回-1
                char [] chs = new char[512];    //以字符数组作为缓冲区,FileInputStream是以字节为单位,byte[]做缓冲区
                int count = reader.read(chs);
                if (-1 == count)
                {
                    break;
                }
                String str = new String(chs,0,count);
                System.out.println(str);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        if (reader!=null)
        {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

