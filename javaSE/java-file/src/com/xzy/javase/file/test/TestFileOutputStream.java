package com.xzy.javase.file.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * FileOutputStream 继承于 OutputStream
 * 文件输出字节流
 * 以Byte字节(8位二进制)为单位 向文件中写入二进制数据
 */
public class TestFileOutputStream {
    public static void main(String[] args) {
        test01();
    }

    public static void test01(){
        FileOutputStream out = null;
        try {
            /**
             * new FileOutputStream("b.txt",true);
             * 默认第二个参数是false,表示不追加,每次new对象都会清空文件之前的内容再创建新的内容
             * ture表示在之前的基础上追加内容,即在文件末尾继续添加
             */
            //FileOutputStream()默认构造每次运行都用write()的内容覆盖原文件内容
            //FileOutputStream("",true)构造时加上true使每次运行都会向文件末尾输入write()的内容
            out = new FileOutputStream("F:\\TestFile\\2.txt",true);
            out.write(97);  //'a'
            out.write(50);  //'2'
            //通过数组先文件输出字符串
            String str = "java语言IO流";
            byte[] bs = str.getBytes(); //getBytes() 得到一个操作系统默认的编码格式的字节数组
            //getBytes(String codeName)方法会根据指定的codeName编码返回某字符串在该编码下的byte数组表示
            out.write(bs);

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        if (out!=null)
        {
            try {
                out.close();    //关闭IO流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
