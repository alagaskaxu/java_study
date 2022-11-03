package com.xzy.javase.api.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期和时间,日历
 * 日期类 Date()  很多方法已经过时了,jdk1.1后大部分方法被抽象类 calendar()类替代
 * 日历类 Calendar()   抽象类,有些方法需要override重写
 * 在大多数情况下，date要实现的功能都可以通过calendar来实现的
 * 区别：Date是日期,Calendar是日历
 * Date是类,Calendar是抽象类
 */
public class TestDateAndCalendar {

    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   //日期输出格式
        Date date = new Date(); //精确到毫秒
        System.out.println(date);   //默认输出格式
        System.out.println(date.getTime()); //得到从初始值到现在时间的 毫秒数
        System.out.println(dateFormat.format(date));  //自定义格式输出,将毫秒数转成字符串
        //getMonth() 获取几月,从0开始,0 表示一月; 1表示二月
        System.out.println(date.getMonth()+1);  //被Calender代替
        //getDay()获取星期几,0 = Sunday, 1 = Monday, 2 = Tuesday
        System.out.println(date.getDay());  //被Calender代替

        System.out.println("====Calender===");
        //Calendar 创建实例对象不用 new,而是利用static方法 getInstance()
        //new 会要求实现抽象类内的所有方法,导致不必要的麻烦
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int mouth = c.get(Calendar.MONTH)+1;    //默认月份从0开始计算,一月是0,二月是1...十二月为11;所以要加一
        int dat = c.get(Calendar.DATE); //月中的几号
        int day = c.get(Calendar.DAY_OF_MONTH);//月中的几号
        //DAY_OF_WEEK 从1开始计算;根据时区来决定从星期天开始算还是星期一开始
        //默认是西方的从星期天开始计算,1为星期天,2为星期一...7为星期六; 所以减一得到直观上的对应
        //Java中设置不一样地区的输出能够使用 Locale.setDefault(Locale.地区名) 来实现
        int week = c.get(Calendar.DAY_OF_WEEK-1);//星期几,从星期天开始算
        System.out.println(""+year+mouth+"-"+day+"("+dat+")-"+week);
        int hours = c.get(Calendar.HOUR_OF_DAY);    //24小时
        System.out.println(hours);
        //getTime()  calender 转成 date类
        date = c.getTime();
        System.out.println(date);
        long millSeconds = date.getTime();  //date类得到毫秒数
        System.out.println(millSeconds);
        millSeconds = c.getTimeInMillis();  //Calender得到毫秒数
        System.out.println(millSeconds);
        //设定特定日期 set();
        c.set(Calendar.YEAR,1999);  //设置单个属性
        c.set(Calendar.MONTH,1);    //设置 2月,月份从 0 计算
        c.set(2022,1,1);    //一起设置
        int days = c.getActualMaximum(Calendar.DATE); //2月最大天数
        System.out.println("2022年2月总天数: "+days);

    }

}
