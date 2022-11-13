package com.xzy.javase.file.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * BufferedWriter
 * 将文本写入字符输出流，缓冲各个字符,是 FileWriter功能上的延伸
 * 自带大缓冲区,缓冲区默认为char[8198]
 * 可以指定缓冲区的大小,或者接受默认的大小
 */
public class TestBufferedWriter {
    public static void main(String[] args) {
        test01();
    }
    public static void test01(){
        FileWriter writer = null;
        BufferedWriter bufWriter = null;
        try {
            writer = new FileWriter("F:\\TestFile\\5.txt");
            bufWriter = new BufferedWriter(writer);
            bufWriter.write("ok");
            bufWriter.newLine();    //新的一行,换行,底层代码write("\r\n")
            bufWriter.write("hello");

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        if (bufWriter != null)
        {
            try {
                bufWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
