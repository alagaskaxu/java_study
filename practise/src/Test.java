public class Test
{
    public static void main(String[] args)
    {
        //练习:侧三角
        int row;    //总行数
        int col;    //总列数
        int star;   // * 的总数
        int blank;  //空格的数量

        row = 5;    //总行数:5
        col = 1 + (row/2);  //总列数:3
        star = 0;   //初始化
        blank = 0;

        for (int i = -(col-1);i < col;i++)   //i表示行,i的范围为[-2,3),即[-2,2]
        {
            blank = i<0? (-i):i;    //取i的绝对值作为空格数
            star = col - blank;
            for (int j = 0; j < star;j++)
            {
                System.out.print("*");
            }
            //换行
            System.out.println();
        }
        System.out.println("========");

        //镜像反转
        for (int i = -(col-1);i < col;i++)   //i表示行,i的范围为[-2,3),即[-2,2]
        {
            blank = i<0? (-i):i;    //取i的绝对值作为空格数
            star = col - blank;
            //打印空格
            for (int j = 0;j < blank;j++)
            {
                System.out.print(" ");
            }
            //打印 *
            for (int j = 0; j < star;j++)
            {
                System.out.print("*");
            }
            //换行
            System.out.println();
        }
        System.out.println("========");

        //练习:1.1+2.2+3.3+....+10.10+11.11+99.99
        double db = 0.0;
        double b = 0.0;
        for (int i = 1; i <= 99; i++)
        {
            b= i<10?(0.1*i):(0.01*i);
            db = db+i+b;
        }
        System.out.println("1.1+2.2+3.3+....+10.10+11.11+99.99= "+db);

    }
}
