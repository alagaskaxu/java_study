package com.xzy.javase.file.test;

import java.io.PrintWriter;

/**
 * PrintWriter 字符打印输出流
 * 向文本输出流打印对象的格式化表示形式,不会抛出 I/O 异常,异常比较少
 * 不会自动刷新缓冲区,需要手动flush()刷新
 * 只有 close() 关闭时会自动刷新
 */
public class TestPrintWriter {
    public static void main(String[] args) {
        test01();
        test02();
    }

    //向控制台打印
    public static void test01(){
        PrintWriter out = new PrintWriter(System.out);
        out.println(97);    //打印完换行
        out.print(97);      //写什么就打印什么,不会转换
        out.write(97);  //write() 只能写字符,int 97 会转为Ascii码的 a,最后输出字符a
        out.flush();    //需要手动刷新
        out.close();    //需要关闭
    }

    //向文件中打印
    public static void test02() {
        PrintWriter out = null;
        try{
            //文件不存在则会创建文件
            out = new PrintWriter("F:\\TestFile\\7.txt");
            out.println(1);
            out.println(2);
            out.println(true);  //写什么打印什么
            out.println(3.14);
            out.println("javaIO学习");
            out.write("end");
        }catch (Exception e){
            e.printStackTrace();
        }
        if (out!=null)
        {
            out.close();
        }
    }
}
