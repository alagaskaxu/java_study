package com.xzy.javase.file.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 带缓冲区的 字符读取 Reader类
 *  BufferedReader , 是FileReader功能上的延伸
 *  自带缓冲区,read()方法差不多
 *  还可以直接读一行字符文本 readLine() 返回String
 */
public class TestBufferedReader {
    public static void main(String[] args) {
        test01();
    }
    public static void test01(){
        FileReader reader = null;
        BufferedReader bufReader = null;
        try{
            reader = new FileReader("F:\\TestFile\\1.txt");
            bufReader = new BufferedReader(reader);
            while(true){
                //readLine() 读取一行字符
                String line = bufReader.readLine();
                if (null == line)
                {
                    break;
                }
                System.out.println(line);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        if (bufReader != null)
        {
            try {
                bufReader.close();  //bufReader.close内部会关闭FileReader
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
