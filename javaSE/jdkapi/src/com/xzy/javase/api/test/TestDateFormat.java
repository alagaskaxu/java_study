package com.xzy.javase.api.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期格式化输出
 * 1.格式化:将(Date对象)日期对象转成字符串格式的日期,如:2022-11-03 11:30
 * 2.解析:将字符串格式的日期变成日期对象
 * Format() 抽象类 目的功能:用来格式化.其子类也是抽象类,子类: DateFormat,MessgaeFormat,NumberFormat
 * DateFormat() 抽象类;  SimpleDateFormat() 具体类,是DateForamt()的子类,实现了具体日期格式化方法
 */
public class TestDateFormat {
    public static void main(String[] args) {
        //日期的格式化与解析
        DateFormat df = new SimpleDateFormat("yyyy年MM-dd HH:mm:ss");
        //格式化
        String str = df.format(new Date());
        System.out.println(str);
        //解析,格式必须一致才能解析
        String text="2025年09-09 08:24:35";

        try {
            Date date = df.parse(text);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
