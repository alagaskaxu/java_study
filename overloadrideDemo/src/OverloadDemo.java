/**
 *  多态之一:方法重载overload
 *  形参个数不同,类型不同都可以实现方法的重载
 */
public class OverloadDemo
{
    /**\
     * 两数求和
     * @param x
     * @param y
     * @return sum
     */
    public int getSum(int x,int y)
    {
        int sum = x+y;
        return sum;
    }

    /**
     * 三数求和
     * @param x
     * @param y
     * @param z
     * @return sum 和
     */
    public int getSum(int x,int y,int z)
    {
        int sum = x+y+z;
        return sum;
    }

    /**
     *求两个浮点型数字的和
     * @param x
     * @param y
     * @return sum 和
     */
    public double getSum(double x,double y)
    {
        double sum = x+y;
        return sum;
    }

    /**
     * 浮点与整形相加
     * @param x
     * @param y
     * @return sum
     */
    public double getSum(int x,double y) {
        double sum = x + y;
        return sum;
    }

    public static void printMsg(int i)
    {
        System.out.println("int");
    }
    public static void printMsg(Integer i)
    {
        System.out.println("Integer");
    }
    public static void  printMsg(Object ob)
    {
        System.out.println("Object");
    }

    public static void main(String[] args) {
        OverloadDemo.printMsg(1);   //int
        printMsg(1);    //int
        printMsg(new Integer(1));   //Integer
        Object ob = null;   //null不能赋值给基本数据类型,只能赋值给引用类型
        printMsg(null);  //Integer
    }

}
