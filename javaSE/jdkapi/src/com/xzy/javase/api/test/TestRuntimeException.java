package com.xzy.javase.api.test;

/**
 * RuntimeException
 * 常见运行时异常
 */
public class TestRuntimeException {
    public static void main(String[] args) {
        //测试常见运行时异常
        //test01(); //算术异常
        //test02(); //空指针异常
        //test03(); //字符串下标索引越界
        //test04(); //数组下标索引越界
        //test05(); //Class类型转换错误
        test06();
    }

    /**
     * ArithmeticException
     * 算术异常,如除数为0等算术异常
     */
    public static void test01(){
        int i = 3/0;
    }

    /**
     * NullPointerException
     * 空指针异常,使用空指针时会出现空指针异常
     */
    public static void test02(){
        String str = null;  //空指针:指针没用指向任意实体
        str.hashCode(); //调用了空指针的方法,出现空指针异常
    }

    /**
     * IndexOutOfBoundsException
     * 下标索引越界
     * 1.StringIndexOutOfBoundsException    字符串下标索引越界异常
     * 2.ArrayIndexOutOfBoundsException    数字下标索引越界异常
     */
    public static void test03(){
        String str = "abc";
        str.charAt(5);  //StringIndexOutOfBoundsException  字符串索引下标越界异常
    }
    /**
     * ArrayIndexOutOfBoundsException 数组下标越界
     */
    public static void test04(){
        int [] i = {1,2,3};
        System.out.println(i[5]);
    }

    /**
     * ClassCastException
     * Class类型转换错误异常
     */
    public static void test05(){
        Object ob = new Integer(1); //自动装箱向父类转型,ob的原类型为Integer型
        Integer i = (Integer) ob;    //强制转换,ob原来的对象就是Integer类,可以转回原来
        String str = (String)ob;    //Integer对象不能强制转成String类型
    }
    public static void test06(){}
}
