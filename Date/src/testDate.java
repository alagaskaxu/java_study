import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 测试时间相关的类
 */
public class testDate
{
    public static void main(String[] args) throws ParseException {
        test1();
        System.out.println("==测试DateFormat==");
        test2();    //抛出parse的错误throws
        test3();

    }

    /**
     * 测试Date类
     */
    public static void test1(){
        long nowNum = System.currentTimeMillis();   //long类型存储 返回当前时刻的毫秒数
        System.out.println(nowNum);
        //起始基准时间是1970年1月1日8:00(东八区) 时间区间可前推或后推2亿年
        Date d0 = new Date(1000);   //1000对应的当时的记录时间,1970年1月1日8点多1000毫秒(1s)
        System.out.println(d0);
        Date d1 = new Date();
        System.out.println(d1.getTime());     //getTime将日期转为毫秒数
        Date d2 = new Date(1000L * 3600 * 24 * 365 * 150);  //距离1970年150年后的日期,忽略闰月
        System.out.println(d2);

        Date d3 = new Date();
        d3.getDate();   //横线表示被废弃的方法,可以用,但可能有问题
        System.out.println(d3.getDate());   //获得日期的几号

    }

    /**
     * 测试DateFormat类的使用:时间和字符串之间相互转换
     */
    public static void test2() throws ParseException {  //throws抛出错误,字符串转时间时需要抛出错误
        //需要利用实现类SimpleDateFormat设定时间类对象的格式
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); //抽象类DateFormat 实现类SimpleDateFormat
        //yyyy-MM-dd hh:mm:ss 按年-月-日 小时-分钟-秒 的格式设定按字符串输出时的格式
        Date d = new Date();
        String str = df.format(d);   //传入一个时间对象,输出一个字符串对象
        System.out.println(str);

        //字符串转时间对象
        String str2 = "2049-10-1 10:05:20";
        Date d2 = df.parse(str2);   //parse 需要抛出错误
        System.out.println(d2);
        //修改格式.yyyy,MM等特殊字符不能该,连接符可自己修改
        DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(df2.format(d2));
        //具体的特殊时间字符,可以查表格化字符的含义

        //利用格式化字符可以轻松地获得一些信息:如获取当前时间是今年的第几天
        DateFormat df3 = new SimpleDateFormat("D"); // D 表示一年的第几天
        Date d3 = new Date();
        System.out.println("现在是一年的第 "+df3.format(d3)+" 天");
    }

    //测试日历类Calendar抽象类,日历类现在不常用
    public static void test3(){
        //月份: 0-11;从0开始, 0代表一月,1表示二月...11表示12月
        //星期: 1-7; 1代表周日,2代表周一...7代表周六
        Calendar calendar = new GregorianCalendar(2022,9,11,04,35,40);    //GregorianCalendar实现类
        //获得年份
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        System.out.println("日历类中自定义的年:"+year);
        System.out.println("日历类中自定义的月:"+month);

        //修改日历类的年份
        calendar.set(Calendar.YEAR,2023);
        System.out.println(calendar.get(Calendar.YEAR));

        //返回对应的毫秒数
        System.out.println(calendar.getTimeInMillis());

        //日期的计算
        calendar.add(Calendar.DATE,1000);   //在原日期上加1000天
        System.out.println(calendar.getTime());
        calendar.add(Calendar.YEAR,-30);   //在原日期上减30年
        System.out.println(calendar.getTime());

    }

}
