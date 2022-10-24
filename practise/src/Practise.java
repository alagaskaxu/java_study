public class Practise
{
    public static void main(String[] args)
    {
        int i, j;
        for (i = 1, j = 1; i <= 9; )
        {//i控制行,j控制列
            System.out.print(j+"*"+i +"="+ i*j+"\t");
            j++;
            if (j>i)
            {//当j>i的时候,说明改换行了,i++,并且j重置
                System.out.println();
                i++;
                j = 1;
            }
        }

    }
}
