public class Test04
{
    public static void main(String[] args)
    {
        double high = 100.0;    //初始高度
        int n = 3;  //落地次数
        double s = 0;   //总路程

        s+=high;    //初始高度下落高度
        high/=2;    //第二次回弹的高度
        //n>=2时计算高度
        for (int i = 2;i<=n;i++)
        {
            s+=2*high;  //上升加再次下落高度
            high/=2;    //下次反弹的高度
        }
        System.out.println(s);
        System.out.println(high);
    }
}
