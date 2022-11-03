package com.xzy.javase.api.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * 会员签到
 * 当日签到记录1,未签到记录0,第二天补签记录2.
 * 使用"签到字符串"记录每日签到状态,格式:"202210_011200111111"
 * tips:
 * 1.前6个数字字符表示年月(yyyyMM),从第8个数字开始表示每日签到状态
 * 2.如果前一天未签到,第二天可以补签,补签记录 2 ,未补签记录0
 */
public class Demo02 {
    public static void main(String[] args) {
        String dateCode = "";   //签到字符串
        Calendar cal = Calendar.getInstance();   //当前时间实例化
        //设定特定时间
        cal.set(2022,10,15);

        dateCode = getCode(cal);    //得到当前日期的签到字符串
        System.out.println("签到字符串:"+dateCode);
        //判断"签到字符串"是否有效
        if (isNumRight(dateCode,cal))
        {
            System.out.println("签到字符串有效");
        }else
        {
            System.out.println("签到字符串无效");
        }

        //传int类第几天和对应"签到字符串",输出对应日期当天签到状态
        if (isNumRight(dateCode,cal)){
            search(3,dateCode);
        }else
        {
            throw new RuntimeException("无效签到字符串");
        }

        //求当月最长连续签到天数,算补签
        if (isNumRight(dateCode,cal)){
            int maxdays =  maxrow(dateCode);
            System.out.println("当月最长连续签到天数为: "+maxdays);
        }else
        {
            throw new RuntimeException("无效签到字符串");
        }

    }

    /**
     * 得到 签到字符串
     * @param cl
     * @return
     */
    public static String getCode(Calendar cl)
    {
        String code = "";   //签到字符串
        String date = "";   //日期字符串
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        date = dateFormat.format(cl.getTime()); //日期转字符串格式化
        code = date+"_";
        code += getSignNum(cl.get(Calendar.DAY_OF_MONTH)); //得到签到状态字符串
        return code;
    }

    /**
     * 模拟已经签到的状态
     * @param days
     * @return signNum签到字符串
     */
    public static String getSignNum(int days)
    {
        int s = 0;
        String signNum = "";
        StringBuffer str = new StringBuffer();    //模拟的签到次数
        Random rd = new Random();
        for (int d=0;d<days;d++)
        {
           s = rd.nextInt(3);
           str.append(s);
        }
        signNum = str.toString();
        return signNum;
    }

    /**
     * 判断"签到字符"是否有效
     * @param code 签到字符串
     * @return boolean
     */
    public static Boolean isNumRight(String code,Calendar cl){
        //切分"签到字符串"
        String year = code.substring(0,4);
        String mouth = code.substring(4,6);
        String numStr = code.substring(7);

        //判断是否全是数字,不是数字则抛出错误
        String str = year+mouth+numStr;
        int num = str.length();
        for (int i = 0;i<num;i++)
        {
            char ch = str.charAt(i);
            if (ch <'0'||ch >'9')
            {
                //System.out.println(ch);
                throw new RuntimeException("签到字符无效,存在非数字字符!");
            }
        }

        //判断条件
        long y = Long.parseLong(year);
        int m = Integer.parseInt(mouth);
        int ns = numStr.length();
        int day = cl.get(Calendar.DAY_OF_MONTH);   //本月天数
        int days = cl.getActualMaximum(Calendar.DAY_OF_MONTH);   //本月总天数
        if (y<2000||m<1||m>12)
        {
            return false;
        }
        //签到总数不能大于当月总天数
        if (ns>days)
        {
            return false;
        }
        //目前签到数不能大于当月目前天数
        if (ns>day||ns<0)
        {
            return false;
        }
        return true;
    }

    /**
     * 传第几天和对应"签到字符串",输出对应日期当天签到状态
     * @param day 日期
     * @param code "签到字符串"
     */
    public static void search(int day,String code) {
        //切分"签到字符串"
        String year = code.substring(0,4);
        String mouth = code.substring(4,6);
        String numStr = code.substring(7);
        if (day>numStr.length())
        {
            throw new RuntimeException("查询日期非法:超出已记录的天数");
        }
        char ch = numStr.charAt(day-1);
        switch (ch)
        {
            case '0':
                System.out.println(year+"年"+mouth+"月"+day+"日未签到");
                break;
            case '1':
                System.out.println(year+"年"+mouth+"月"+day+"日已签到");
                break;
            case '2':
                System.out.println(year+"年"+mouth+"月"+day+"日已补签");
                break;
            default:
                throw new RuntimeException("签到状态非法,非字符0,1,2状态");
        }

    }

    /**
     * 传 "签到字符串" 求当月最长连续签到天数,算补签
     * @param code
     * @return maxDays 最长天数
     */
    public static int maxrow(String code){
        int maxDays = 0;    //最长连续签到天数
        int temp = 0;   //中间变量
        String numStr = code.substring(7);  //签到状态字符串
        char ch = numStr.charAt(0); //单个状态
        char ch2 = ch; //单个状态
        int len = numStr.length();  //字符串长度
        for (int i = 0;i<len;i++)
        {
            ch = numStr.charAt(i);
            if ('1' == ch || '2' == ch)
            {
                int j =1;
                ch2 = ch;
                while ((j<len-i)&&('1' == ch2 || '2' == ch2))
                {
                    ch2 = numStr.charAt(i+j);
                    temp+=1;
                    j++;
                }
            }
            maxDays = temp>maxDays?temp:maxDays;    //最大连续天数
            temp = 0;   //初始化
        }
        return maxDays;
    }

}
