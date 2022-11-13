package com.xzy.javase.file.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO文件输出练习
 * 向指定文件输出九九乘法表
 */
public class demo05
{
    public static void main(String[] args) {
        test01();
    }

    public static void test01(){
        FileOutputStream output = null;
        try {
            File file = new File("F:\\TestFile\\3.txt");
            if (!file.isFile()){
               boolean sucess = file.createNewFile();   //文件不存在则创建该文件
                if (!sucess)
                {
                    return;
                }
            }
            //构造时不加true,默认覆盖原文件内容
            output = new FileOutputStream(file);
            //向文件中输出九九乘法表
            for (int r=1;r<=9;r++){
                for (int c=1;c<=r;c++){
                    String str=""+c+'*'+r+'='+(c*r)+'\t';

                    byte[] bs = str.getBytes(); //getBytes() 得到一个操作系统默认的编码格式的字节数组
                    //getBytes(String code)方法会根据指定的code编码返回某字符串在该编码下的byte数组表示
                    output.write(bs);
                }
                //回车换行符
                output.write('\n');
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        if (output!=null)
        {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
