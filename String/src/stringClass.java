import java.lang.System;
import java.util.Arrays;

/**
 * String类:
 * String类又称为不可变字符序列
 * String位于java.lang包中,Java程序默认导入java.lang包下的所有类
 * java字符串就是Unicode字符序列,例如字符串"java"就是4个Unicode字符
 * Java没有内置的字符类型,而是标准Java类库中提供了一预定义的类String,每个用双引号括起来的字符串都是String类的一个实例
 */
public class stringClass {
    public static void main(String[] args) {
        test01();
        System.out.println("---测试String各自方法---");
        test02();
        System.out.println("--测试String方法2---");
        test03();
    }
    public static void test01() {
        //String类定义
        String s1 = "abc";  //凡是字符串常量"",都会放到字符串的常量池中
        String s2 = new String("abc");  //建了一个新的字符串对象
        String s3 = "abc";
        String s4 = "ABc";
        //查看是否是同一对象
        System.out.println(s1 == s2);   //flase
        System.out.println(s1 == s3);   //true
        //"abc"会放在堆里的常量池,是同一个对象分别赋值给s1和s3
        //s2:new会创造一个新的对象,该对象里有一个char数组,将常量池的abc赋值给这个新对象的数组里
        //equals比较字符串值
        System.out.println(s1.equals(s2));  //true
        //equals用来判断两个字符串的值是否相等
        System.out.println(s1.equalsIgnoreCase(s4));    //true
        //equals用来判断两字符串值是否相等,但是忽略大小写

    }
    //测试String工具
    public static void test02(){
        String s1 = "0123456789,How are you";
        System.out.println(s1.charAt(4));   //4 索引下标4的字符
        System.out.println(s1.length());    //22    字符串长度
        //字符串转化成char数组toCharArray()
        char[] chars = s1.toCharArray();    //转成数组
        System.out.println(Arrays.toString(chars));
        //截取成字符串数组split
        String[] strs = s1.split(",");  //以 , 作为分割截取原字符串;可以传入正则表达式
        System.out.println(Arrays.toString(strs));
        System.out.println("=========");

        //判断是否包含子字符串(查找字符串indexOf)
        System.out.println(s1.indexOf("are"));  //15 从头找,找到则返回对应的索引下标否则返回-1
        System.out.println(s1.lastIndexOf("are"));  //15 从尾部开始找
        //判断是否包含子字符串返回Boolean值
        System.out.println(s1.contains("How")); //true
        //判断是否以某字符串开头startsWith
        System.out.println(s1.startsWith("0123"));  //ture
        //判断是否以某字符串结尾
        System.out.println(s1.endsWith("789"));  //false

    }

    public static void test03(){
        String s1 = "0123456789,How are you";
        //用新字符替换老字符replace,来产生一个新字符串
        String s2 = s1.replace(' ','&');
        System.out.println(s2); //' '空格被 & 字符替换,产生新的字符串s2
        System.out.println("原s1字符串仍为: "+s1);    //原s1字符串未被改变

        //substring 截取从索引下标到结束索引的下标(或到末尾)的字符串,形成新字符串
        s2 = s1.substring(4);
        System.out.println("将s1从4下标处开始截到末尾: "+s2);
        String s3 = s1.substring(4,9);      //区间为 [4,9)
        System.out.println("将s1从4下标处开始截到9下标处: "+s3);

        //转换字符串大小写,toLowerCase()全转成小写; toUpperCase()全转成大写;
        s2 = s1.toLowerCase();  //字符串全转小写
        System.out.println("全小写: "+s2);
        s2 = s1.toUpperCase();  //字符串全转大写
        System.out.println("全大写: "+s2);

        //去除首尾空格trim()
        s3 = "  x ni hao  ";
        s2 = s3.trim(); //也是产生新的去除了首尾空格的字符串
        System.out.println(s3);
        System.out.println(s2);

    }

}

/**
 * char charAt(int index)       返回字符串中第index个字符
 * boolean equals(String other) 如果字符串与参数other值相等,返回true;否则返回false.
 * boolean equalsIgnoreCase(String other)   如果字符串与参数other值相等(忽略大小写),则返回true,否则返回false.
 * int indexOf(String str)      返回从头开始查找第一个子字符串str在字符串中的索引位置.如果未找到子字符串str,则返回-1.
 * int lastIndexOf(String str)  返回从末尾开始查找第一个子字符串str在字符串中的索引位置.如果未找到子字符串str,则返回-1.
 * int length()                 返回字符串长度
 * String replace(char oldChar,char newChar)  反回一个新串,它是通过newChar字符替换此字符串中出现的所有oldChar字符而生成的.
 * boolean startsWith (String prefix)   如果字符串以参数prefix值开始,则返回true.
 * boolean endsWith (String prefix)     如果字符串以参数prefix值结尾,则返回true.
 * String substring (int beginIndex)    返回一个新字符串,该串包含从原始字符串的beginIndex下标到串尾.
 * String substring (int beginIndex,int endIndex)    返回一个新字符串,该串包含从原始字符串的beginIndex下标到串尾或endIndex-1的所有字符.
 * String toLowerCase ()         返回一个新字符串,该串将原始字符串中的所有大写字母改成小写字母.
 * String toUpperCase ()         返回一个新字符串,该串将原始字符串中的所有小写字母改成大写字母.
 * String trim ()                返回一个新字符串,该串删除了原始字符串头部和尾部的空格.
 */
