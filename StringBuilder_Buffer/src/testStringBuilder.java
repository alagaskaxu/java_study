
/**
 * 测试可变字符序列的用法
 * StringBuffer和StringBuilder 比较
 * String:不可变字符序列
 * StringBuffer和StringBuilder: ,方法一模一样.
 * 区别:
 * StringBuffer: 线程安全,做线程同步检查,效率较低.
 * StringBuilder: 线程不安全,不做线程同步检查,因此效率较高.一般使用Builder
 */
public class testStringBuilder {
    public static void main(String[] args) {
        test1();

        //效率测试
        test2();
    }

    public static void test1(){
        //可变字符序列
        StringBuilder sb = new StringBuilder();
        StringBuffer sb2 = new StringBuffer();

        //向末尾增添内容append()
        sb.append("a"); //同一个对象,不像String会创建新的对象
        sb.append("b").append("c").append("d").append("e");
        System.out.println(sb);

        sb2.append("南京林业大学");
        //对应下标插入 insert()方法
        sb2.insert(0,"江苏"); //从0下标处开始插入字符
        System.out.println(sb2);
        //根据下标删除区间.区间:[,)
        sb2.delete(0,2);    //[0,2)
        System.out.println(sb2);    //南京林业大学
        //根据下标删除一个字符.
        sb2.deleteCharAt(0).deleteCharAt(0);
        System.out.println(sb2);    //林业大学

        //字符串逆序 reverse()方法
        System.out.println(sb2.reverse());  //学大业林

    }

    //字符串效率测试
    public static void test2(){
        //使用String进行字符串的拼接,平时不使用该方法拼接,仅作测试
        String str = "";
        //num1获取JVM剩余的内存空间,单位是字节
        long num1 = Runtime.getRuntime().freeMemory();
        //time1获取当前的时间
        long time1 = System.currentTimeMillis();

        for (int i = 0; i<5000;i++){
            str += i;       //由于String不可变,相当与产生了5000个字符串String对象
        }
        //String方法运行完后JVM的剩余空间
        long num2 = Runtime.getRuntime().freeMemory();
        //String方法运行完后的系统时间
        long time2 = System.currentTimeMillis();
        System.out.println("String拼接5000次的str占用空间为: "+(num1 - num2));
        System.out.println("String拼接的str花费的时间为: "+(time2 - time1)+"ms");

        System.out.println("===使用可变字符序列完成拼接效率测试===");
        //StringBuilder方法
        StringBuilder strbd = new StringBuilder();
        //num1获取JVM剩余的内存空间,单位是字节
        num1 = Runtime.getRuntime().freeMemory();
        //time1获取当前的时间
        time1 = System.currentTimeMillis();

        for (int i = 0; i<5000;i++){
            strbd.append(i);    //利用可变序列的append添加5000次字符
        }
        //StringBuilder方法运行完后JVM的剩余空间
        num2 = Runtime.getRuntime().freeMemory();
        //StringBuilder方法运行完后的系统时间
        time2 = System.currentTimeMillis();
        System.out.println("StringBuilder拼接5000次的str占用空间为: "+(num1 - num2));
        System.out.println("StringBuilder拼接的str花费的时间为: "+(time2 - time1)+"ms");
        //空间和时间几乎都是0

    }

}
