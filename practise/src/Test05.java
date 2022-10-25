import java.util.Date;

/**
 * 打印日历
 * 要点:
 *  1.本月总天数
 *  2.本月第一天周中的天(0-6)
 *  3.周中的天在[0,6]范围内变化
 *  当周中的天为0时,换行
 */
public class Test05
{
    public static void main(String[] args)
    {
        int year=2022;
        int month=2;
        int days=getDays(year,month);
        //本月第1天是星期几
        Date date=new Date(year-1900,month-1,1);//日期对象
        int dayInWeek=date.getDay();
        System.out.println(dayInWeek);
        System.out.println("一\t二\t三\t四\t五\t六\t日");
        //第一天前面的空格数量
        int b=0==dayInWeek?6:dayInWeek-1;
        for(int c=1;c<=b;c++){
            System.out.print(' ');
            System.out.print('\t');
        }
        //打印本月中的所有日期
        for(int d=1;d<=days;d++)
        {
            System.out.print(d);
            System.out.print('\t');
            //周中的天的变化
            dayInWeek=6==dayInWeek?0:(dayInWeek+1);
            if(1==dayInWeek)
            {
                System.out.println();
            }
        }

    }
    /**
     * 根据年,月获取当月的天数
     * @param year 年
     * @month month 月
     */
    public static int getDays(int year,int month)
    {
        int day;
        switch (month)
        {
            case 2:
                day=(0==year%400)||(0==year%4&&0!=year%100)?29:28;
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day=31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day=30;
                break;
            default:
                //表示错误状态
                throw new RuntimeException("无效的月份【"+month+"】");
        }

        return day;
    }

}
