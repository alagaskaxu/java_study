/*
 * break和continue语句
 * break:跳出语句,表示强行结束整个循环结构
 * continue: 继续语句,表示结束本次循环,继续下一个循环
 */
 class break_continue {
    public static void main(String[] args) {
        //产生100以内的随机数,直到随机数为88终止循环
        int count = 0;
        while(true)
        {
            int m = (int)(Math.random()*100);
            System.out.println(m);
            count ++;
            if (m == 88)
                break;
        }
        System.out.println("一共循环了:"+count+"次");

        //把100-150之间不能被3整除的数输出,每行输出5个
        count = 0;
        for (int i = 100;i<=150;i++)
        {
            if (i%3==0)
            {
                continue;   //表示遇到被3整除的数直接跳出本一次循环,继续下一次循环判断(即直接跳到下次循环开始)
            }
            System.out.print(i+" ");
            count++;
            if (count == 5 || count%5 == 0)   //count计数器是五时换行,即每五个数换一次行(count%5 == 0功能等价,可能效果更好,可以输出count直接得出一共几个数)
            {
                count = 0;  //count清零
                System.out.println();   //println表示换行输出
            }
        }
    }
}
