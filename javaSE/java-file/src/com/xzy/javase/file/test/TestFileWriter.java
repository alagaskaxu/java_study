package com.xzy.javase.file.test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

/**
 * Writer抽象类 将字节流变为字符流
 * TestFileWriter 继承于OutputStreamWriter继承于Writer
 * 用来写入字符文件的便捷类,自带固定的小缓冲区(char[1024]数组)
 * write()方法将字符写入缓冲区,缓冲区写满则自动写入字符数据到文化内再刷新缓冲区,flush()手动控制刷新,写入数据刷新缓冲区
 * close()关闭写入也会自动写入缓冲区数据再刷新缓冲区最后关闭写入通道
 */
public class TestFileWriter {
    public static void main(String[] args) {
        test01();
    }
    public static void test01(){
        FileWriter writer = null;
        try {
            //如果文件路径不存在,会新建文件
            writer = new FileWriter("F:\\TestFile\\4.txt");
            writer.write("\t\t2022年11月\n");
            writer.write("一\t二\t三\t四\t五\t六\t日\n");
            Calendar c = Calendar.getInstance();
            c.set(2022,10,1);   //2022.11.1
            int week = c.get(Calendar.DAY_OF_WEEK); //一号周几
            int days = c.getActualMaximum(Calendar.DAY_OF_MONTH);   //总天数
            int blank = 1==week?6:(week-2);
            //打印空格
            for (int b=1;b<=blank;b++)
            {
                writer.write(" \t");
            }
            //打印日期
            for (int date=1;date<=days;date++)
            {
                writer.write(""+date+"\t");
                if (1 == week)
                {
                    writer.write("\n");
                }
                week = 7 == week?1:(week+1);
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        if (writer != null)
        {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
