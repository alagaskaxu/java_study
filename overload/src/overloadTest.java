/*
 *方法的重载 overload
 * 方法的重载是指一个类中可以定义多个方法名相同,但参数不同的方法.
 * 调用时会根据不同的参数自动匹配对应的方法.(注:只是方法名相同,实际是完全不同的方法;重构后的方法与相同的方法名的方法不是同一方法)
 * 构成方法重载的条件:
 * 1.不同的含义:形参类型,形参个数,形参顺序
 * 以下不构成方法重构,因为无法通过形参类型来区分不同函数
 * 2.只有返回值不同不构成方法的重载,如:int a(String str){} 与void a(String str){}
 * 3.只有形参的名称不同,也不够成重构,如:int a(String str){} 与int a(String s){}
 */
public class overloadTest {
    public static void main(String[] args) {
        int a = add(100,200);
        double b = add(10.5,20);    //参数类型不同实现重载
        int c = add(100,200,300);   //参数个数不同实现重载
        double d = add(10,20.8);        //参数顺序不同实现重载
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

    }

    //两种求和方法
    public static int add(int n1, int n2)
    {
        int sum = n1 + n2;
        return sum;
    }
    //形参类型不同实现add方法的重载
    public static double add(double n1,int n2)
    {
        double sum = n1 + n2;
        return sum;
    }
    //形参个数不同实现重载
    public static int add(int n1, int n2, int n3)
    {
        int sum = n1 + n2 +n3;
        return sum;
    }
    //形参顺序不同实现重载
    public static double add(int n1, double n2)
    {
        double sum = n1 + n2 ;
        return sum;
    }

}
