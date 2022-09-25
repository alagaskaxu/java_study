/*
 *方法的定义和调用
 * 方法类似于c语言的函数function
 * 方法的声明格式:
 * [多个修饰符] 返回值类型 方法名(形式参数列表) {}
 * []表示可选项 ; 形式参数类别(形参)表示方法的输入值 ; 返回值类型表示方法最后输出值的类型
 * 例如:[public static] void method(String[] args) {} 就是main方法,method是自定义的方法名
 *      public static void add(int n1 , int n2) {} 就是add方法,add是自定义的方法名
 */
public class method {
    //main方法: 整个程序的入口
    public static void main(String[] args) {
        //调用add方法(函数)
        int a1 = add(100, 200);
        int num1, num2;  //num1,num2是实际参数(实参),调用时实际传递的参数
        num1 = 10;
        num2 = 20;
        int a2 = add(num1, num2);
        System.out.println(a1 + "," + a2);
        printInfo();
        printInfo();
    }

    //定义两个数求和的方法(函数)
    public static int add(int n1, int n2/*n1,n2为形参*/)
    {
        int sum = n1 + n2;  //n1,n2表示形式参数(形参)
        return sum;     //return 方法的输出值(函数的返回值)
    }

    //void表示无返回值
    public static void printInfo() {
        System.out.println("void方法测试");
    }
}
