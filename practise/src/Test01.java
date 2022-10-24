public class Test01
{
    /**
     * 专题一:二维几何图形
     *  1.******
     *  2.矩形
     *  3.平行四边形
     *  4.直角三角形
     *  5.等腰三角形
     *  6.菱形
     *  7.连续的几何图像
     *  8.空心的几何图像
     * @param args
     */
    public static void main(String[] args)
    {
        int row = 4;    //行数
        int col = 5;    //列数
        int blank = 0;  //空格数量
        int star = 0;   // * 的数量
        star = col;     //列数就是 * 的数量
        //2.矩形
        for (int i = 0; i<row;i++)   //i行
        {
            for (int j = 0;j<col;j++)    //j列
            {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("========");
        //3.平行四边形
        for (int i = 0; i<row;i++)
        {
            blank = i - 0;  //空格数量
            for (int j = 0;j<blank;j++)
            {
                System.out.print(" ");
            }
            for (int j = 0;j<col;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("========");
        for (int i = 0; i<row;i++)
        {
            blank = row-i-1;
            for (int j = 0;j<blank;j++)
            {
                System.out.print(" ");
            }
            for (int j = 0;j<col;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("========");
        //4.直角三角形
        //星号累加
        for (int i = 0; i<row;i++)
        {
            for (int j = 0;j<=i;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("========");
        //星号变化
        for (int i = 0; i<row;i++)
        {
            blank = 0;
            star = 2*i + 1;
            for (int j = 0;j<star;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("========");
        //反直角
        for (int i = 0; i<row;i++)
        {
            blank = 4*(row - i - 1);
            for (int j = 0;j <blank;j++)
            {
                System.out.print(" ");

            }
            star = 2*i + 1;
            for (int j = 0;j<star;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("========");
        //倒反直角
        for (int i = 0; i<row;i++)
        {
            blank = 4*i;
            for (int j = 0;j <blank;j++)
            {
                System.out.print(" ");

            }
            star = 2*(row - i -1) + 1;
            for (int j = 0;j<star;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("========");
        //5.等腰三角形
        for (int i = 0; i<row;i++)
        {
            blank = row - i - 1;
            for (int j = 0;j <blank;j++)
            {
                System.out.print(" ");
            }
            for (int j = 0;j<=i;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("========");
        for (int i = 0; i<row;i++)
        {
            blank = 2*(row - i - 1);
            for (int j = 0;j <blank;j++)
            {
                System.out.print(" ");
            }
            star = 2*i + 1;
            for (int j = 0;j<star;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("========");
        //倒等腰
        for (int i = 0; i<row;i++)
        {
            blank =2*i;
            for (int j = 0;j <blank;j++)
            {
                System.out.print(" ");

            }
            star = 2*(row - i -1) + 1;
            for (int j = 0;j<star;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("========");
        //6.菱形
        /*
            一般思路:i表示行号,先打印上半区的正三角再打印下半区的倒三角,用了两次for{for{};for{}}一共四个for
            另一种方法,将空格数作为 i 累加,从负数加起,范围为[-((row-1)/2),(row-1)/2],i取绝对值就是空格数,row-2*|i|就是star的数
            空格数: -2  -1  0  1  2 ; row = 5.
         */
        row = 5;
        col =  row;
        for (int i = -(row/2);i<=(row/2);i++)
        {
            blank = i<0? -i:i;    //求i绝对值,就是空格数
            //打印空格
            for (int j = 0;j<2*blank;j++)
            {
                System.out.print(" ");
            }
            //打印*
            star = row - 2*blank;   //star数就是总行数 - 2*空格数
            for (int j = 0;j < star;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("========");
        //7.连续的几何图形
        //连续的直角三角形
        row = 4;
        col = 2*row - 1;
        for (int i= 0;i<4;i++)  //i表示行号
        {
            star = 2*i+1;
            blank = col - star;
            for (int k = 0;k<3;k++) //k表示一个图像打印多少次
            {
                //打印*
                for (int j=0;j<star;j++)
                {
                    System.out.print("*");
                }
                //打印空格
                for (int j =0;j<blank;j++)
                {
                    System.out.print(" ");
                }
            }
            //换行
            System.out.println();
        }
        System.out.println("================");

        //8.打印空心的图像
        //空心的菱形
        row = 7;
        for (int i = -(row/2);i<=(row/2);i++)
        {
            blank = i<0? -i:i;    //求i绝对值,就是空格数
            //打印空格
            for (int j = 0;j<blank;j++)
            {
                System.out.print(" ");
            }
            //打印*
            star = row - 2*blank;   //star数就是总行数 - 2*空格数
            for (int j = 0;j < star;j++)
            {
                if (0 == j||(star-1) == j)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println("===========");


    }
}
