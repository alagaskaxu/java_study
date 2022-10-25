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

        //练习:1.1+2.2+3.3+....+10.10+11.11+99.99+100.100
        double db = 100.100;    //直接特殊处理,减少判断
        double b = 0.0;
        for (int i = 1; i <= 99; i++)
        {
            b= i<10?(0.1*i):(0.01*i);
            db = db+i+b;
        }
        System.out.println("1.1+2.2+3.3+....+10.10+11.11+99.99+100.100= "+db);
        //方法二:1.1+2.2+3.3+....+10.10+11.11+99.99+100.100
        //利用面向对象的类:字符串转化数字
        db = 100.100;   //特殊问题特殊处理,减少运算难度
        for (int n=1;n<100;n++)
        {
            String strNub = ""+n+'.'+n; //将数字转成字符串形式
            System.out.println(strNub);
            //parseDouble()方法可以将字符串类型的数字转换为Double类型的数字 "1.1" => 1.1
            double d = Double.parseDouble(strNub);
            db += d;
        }
        System.out.println("1.1+2.2+3.3+....+10.10+11.11+99.99+100.100= "+db);

        //方法三:1.1+1.1=2.2+1.1=3.3.....;     1.1-9.9每次加1.1
        //10.10+1.01=11.11+1.01=12.12.....;     10.10-99.99每次加1.01
        db = 100.100;
        for (double d =1.1;d<=9.9;d+=1.1)
        {
            db+=d;
        }
        for (double d=10.10;d<100.100;d+=1.01)
        {
            db+=d;
        }
        System.out.println("方法三(有误差):"+db);
        //由于double的精度问题会有误差和bug.逻辑上可行,实际不行
    }
}
