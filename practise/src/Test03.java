public class Test03
{
    public static void main(String[] args)
    {
        int max = 500;  //50元,500毛
        int a = 1;      //一元个数
        int b = 1;      //五毛个数
        int c = 1;     //一毛个数
        int money = 0;
        int count = 0;
        for (a = 1; a <= 50; a++)
        {
            int Bn = 250-2*a;
            for (b = 1; b <= Bn; b++)
            {
                int Cn = 500 - 10*a - 5*b;
                for (c = 1; c <= Cn; c++)
                {
                    money = 10 * a + 5 * b + c;
                    if (max == money) {
                        System.out.println("一元:" + a + "五毛" + b + "一毛" + c);
                        count++;
                    }else
                    {
                        continue;
                    }
                }
            }
        }
        System.out.println("一共有:"+count+"组");
    }
}
