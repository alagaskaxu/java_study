/*
*   循环结构while for 语句
 */
public class loop {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 10){
            System.out.println(i);
            i++;
        }

        //计算1+2+3+...+100
        i = 1;
        int sum = 0;
        while (i <= 100){
            sum = sum + i;
            i++;
        }
        System.out.println("1-100的和为:"+sum);

        //for循环语句
        //打印1-10
        for (i = 0;i <= 10;i++){
            System.out.println(i);
        }
        //for循环计算1-100的和
        int sum2 = 0;
        for (i = 1; i <= 100;i++){
            sum2 += i;      //sum2 = sum2 + i;
        }
        System.out.println("sum2 = "+sum2);

        //嵌套循环
        //打印输出十行,每行输出0-9
        for (i = 0;i<10;i++)    //之前定义了局部变量i,生命周期在整个main方法里
        {
            for (int j = 0;j<10;j++)    //int j ,j变量生命周期只再循环里,出了循环j变量自动销毁
            {
                System.out.print(j+"\t");
            }
            System.out.print("\n");
        }

        //打印等腰直角三角形
        for (i = 0 ; i<5; i++)      //i表示行号,j表示列
        {
            for (int j = 0; j<=i; j++)
            {
                System.out.print(" * ");
            }
            System.out.print("\n");
        }
        //打印倒立的等腰直角三角形
        System.out.println("#############");
        for (i = 0 ; i<5; i++)
        {
            for (int j = 0; j<(5-i); j++)
            {
                System.out.print(" * ");
            }
            System.out.print("\n");
        }
        //打印等腰三角形
        System.out.println("#############");
        int num = 4;    //初始位置
        for (i = 0 ; i<5; i++)
        {
            for (int j = 0; j<10; j++)
            {
                if (j >= num - i && j <= num + i)
                {
                    System.out.print("*");
                }else
                {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }

    }
}
