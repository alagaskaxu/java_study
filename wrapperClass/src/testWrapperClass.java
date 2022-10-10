import java.net.Inet4Address;

/**
 *lang包里的Wrapper Class 包装类
 * 八种基本数据类型对应八种包装类
 * 作用:把基本类型加一个包装变成一个对象
 */
public class testWrapperClass {
    public static void main(String[] args) {
        testInteger();
        testAutoBox();
        testCache();
    }
    /**
     * 对应关系: 基本数据类型-> 包装类
     * byte-> Byte  boolean-> Boolean
     * short-> Short    long-> Long
     * char-> Character int-> Integer
     * float-> Float    double-> Double
     */

    //Integer基本测试
    public static void testInteger(){
        //基本数据类型转为Integer对象 valueOf
        Integer int1 = Integer.valueOf(100);

        //包装类对象转为基本数据类型 xxxxValue()
        int int2 = int1.intValue();
        long long1 = int1.longValue();

        //字符串转为Integer对象,parseInt()
        Integer int3 = Integer.parseInt("324"); //不能是字母文字之类,只能数字,不然会报错
        System.out.println(int3);

        //MAX_VALUE 能表示最大的数
        System.out.println("int能表示的最大整数: "+Integer.MAX_VALUE);
    }

    //测试自动装箱,拆箱
    public static void testAutoBox(){
        Integer a = 100;    //自动装箱.编译器自动添加: Integer a = Integer.valueOf(100);
        int b = a;  //自动拆箱,对象转基本数据类型.编译器自动添加: int b = a.intValue();
        //自动装箱拆箱容易空指针异常
        Integer c = null;
        //int d = c;  //自动拆箱.int d = c.intValue; c是空,会报空指针异常

    }

    //测试包装类缓存
    public static void testCache(){
        //整形,char类型所对应的包装类.在自动装箱时,对于-128到127之间的值会进行缓存处理,目的是提高效率
        Integer a = Integer.valueOf(100);
        Integer b = 100;        //100在缓存里,直接取出来
        System.out.println(a == b);   //true.是同一对象

        Integer c = 300;    //300不在缓存里,要创建新对象
        Integer d = 300;    //300不在缓存里,要创建新对象
        System.out.println(c == d);     //false.不是同一对象

    }

}
