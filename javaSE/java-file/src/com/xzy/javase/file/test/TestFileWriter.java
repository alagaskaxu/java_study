package com.xzy.javase.file.test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

/**
 * Writer抽象类 将字节流变为字符流
 * TestFileWriter 继承于OutputStreamWriter继承于Writer
 * 用来写入字符文件的便捷类
 */
public class TestFileWriter {
    public static void main(String[] args) {
        test01();
    }
    public static void test01(){
        FileWriter writer = null;
        try {
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
