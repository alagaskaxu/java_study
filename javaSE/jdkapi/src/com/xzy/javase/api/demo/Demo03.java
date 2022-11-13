package com.xzy.javase.api.demo;

import java.util.Calendar;
import java.util.Date;

public class Demo03 {
    private static final int SEC_MILLIS = 1000; //一秒的毫秒数
    private static final int MIN_MILLIS = 60*SEC_MILLIS; //一分钟的毫秒数
    private static final int H_MILLIS = 60*MIN_MILLIS; //一小时的毫秒数
    private static final int DAY_MILLIS = 24*H_MILLIS; //一天的毫秒数
    /**
     * 根据年月打印当月日期
     * @param year
     * @param month
     */
    public static void printCalendar(int year,int month){
        if (year<1900||year>=2099){
            throw new IllegalArgumentException("无效的年");
        }
        if (month<1||month>12){
            throw new IllegalArgumentException("无效的月份");
        }
        Calendar c = Calendar.getInstance();
        //设置特定日期,本月第一天
        c.set(year,month-1,1);
        //本月第一天为星期几
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        //本月总天数
        int days = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        //打印日期格式
        System.out.println("一\t二\t三\t四\t五\t六\t日");
        //打印本月1号前的空格,dayOfWeek为1时是星期天
        int blank= 1==dayOfWeek?6:(dayOfWeek-2);
        for (int count=1;count<=blank;count++)
        {
            System.out.print(' ');
            System.out.print('\t');
        }
        //打印本月所有日期
        for (int date=1;date<=days;date++)
        {
            System.out.print(date);
            System.out.print('\t');
            if (1 == dayOfWeek)
            {
                System.out.println();   //星期天换行
            }
            dayOfWeek = 7==dayOfWeek?1:++dayOfWeek;
        }

    }

    public static void main(String[] args) {
        printCalendar(2022,11);
        System.out.println();
        Calendar c = Calendar.getInstance();
        c.set(2023,0,1,0,0,0);  //2023.1.1 00:00
        Date date = c.getTime();
        timeDown(date);
    }

    /**
     * 倒计时
     * @param date 未来时间点表示的Date对象
     */
    public static void timeDown(Date date){
        //获取当前时间点的毫秒数
        long now = System.currentTimeMillis();  //获取当前系统时间
        //long now = new Date().getTime();  //获取当前时间,一样效果
        long targetMillis = date.getTime();
        long x = targetMillis - now;    //未来目标时间与现在时间之间的毫秒数
        if (x<=0){
            System.out.println("倒计时已结束");
            return;
        }
        //剩余多少天
        long days = x/DAY_MILLIS;  //除于一天的毫秒数
        //剩余多少小时
        x%=DAY_MILLIS; //x除天的余数还有多少毫秒
        long hours = x/H_MILLIS;
        //剩余多少分钟
        x%=H_MILLIS;
        long minutes = x/MIN_MILLIS;
        //剩余多少秒
        x%=MIN_MILLIS;
        long seconds = x/SEC_MILLIS;
        System.out.println(String.format("剩余%d天%d小时%d分钟%d秒",days,hours,minutes,seconds));
    }
}
