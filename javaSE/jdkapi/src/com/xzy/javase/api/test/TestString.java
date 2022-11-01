package com.xzy.javase.api.test;

import java.util.Locale;

/**
 * 练习String类
 */
public class TestString {
    public static void main(String[] args) {
        test01();
        System.out.println("=======");
        test02();
        System.out.println("=======");
        String number = "13961196673";
        System.out.println("方法一判断 "+number+" 是否是移动号码: "+test02practise1(number));
        System.out.println("方法二判断 "+number+" 是否是移动号码: "+test02practise2(number));
        System.out.println("=======");
        test03();
        System.out.println("=======");
        test04();
        System.out.println("=======");
        test05();
        System.out.println("=======");
        test06();
        System.out.println("=======");
        test07();
        System.out.println("=======");
        test08();

    }
    public static void test01(){
        String str1 = "abc";
        String str2 =new String("abc");
        System.out.println(str1 == str2);   //false,不是一个对象
        System.out.println(str1.equals(str2));  //true 字符串的值相同
        System.out.println("======");
        //获取String的长度
        String str3 = "你好!欢迎使用java String";
        System.out.println("str3:"+str3);
        int len = str3.length();
        System.out.println("str3的长度:"+len);
        //String下标索引从0开始
        //charAt(int index) 打印对应索引的字符 0=>你; 16=>n; 17=>g
        System.out.println("str3索引下标0处的字符为:"+str3.charAt(0));
        System.out.println("str3索引下标17处的字符为:"+str3.charAt(17));

        //循环打印字符串中每一个字符
        for (int index = 0;index<len;index++)
        {
            char ch = str3.charAt(index);
            //codePointAt(int index) 获取索引下标对应的字符的Unicode编码值
            int cp = str3.codePointAt(index);
            //8	=> a, 编码值为:	97
            System.out.println(index+"\t=> "+ch+", 编码值为:\t"+cp);
        }


        //空字符串,即长度为0
        System.out.println("=======");
        String str4 = "";
        System.out.println("空字符串str4的长度:"+str4.length());
        //isEmpty() 判断String是否为空字符串
        System.out.println("str4是否为空字符串:"+str4.isEmpty()); //true

    }

    /**
     * 1.将字符串中的字母转大小写
     * 2.去除字符串中左右两边的空格(或首位空格)
     * 3.判断字符串以什么开始或以什么结尾
     */
    public static void test02(){
        String str1 = "aBc";
        //toLowerCase() 将大写转成小写,不会修改原字符串,会返回一个新的String字符串
        str1.toLowerCase();
        System.out.println("str1转换后仍不会改变:"+str1);
        System.out.println("转小写后的新字符串:"+str1.toLowerCase());
        str1 = str1.toLowerCase();
        //此时的str1虽然名字和原来一样,但实际上指向了一个新的对象,旧的str1指向的aBc对象会被JVM自动销毁,然后str1指向新的abc对象
        System.out.println("转小写后重新赋值给str1后的str1字符串:"+str1);

        //trim() 去除左右两边的空格
        String str2 =" N B A ";
        //String不会被修改,需要创建新对象重新赋值初始化
        str2 = str2.trim(); //此时的str2与一开始的str2只是变量名字相同,实际指向的对象已经变成新创建的String对象了
        System.out.println(str2);

        System.out.println("======");
        //endsWith();startsWith() 判断字符串以什么开始或以什么结尾
        String str3 = "https://www.baidu.com";
        System.out.println(str3);
        System.out.println("判断str3是否以 .com结尾: "+str3.endsWith(".com"));  //true
        String str4 = "13861196673";
        System.out.println(str4);
        System.out.println("判断str4是否以 138开头:"+str4.startsWith("138"));
        System.out.println("判断str4是否以 1234结尾:"+str4.endsWith("1234"));

    }

    /**
     * 判断参数所表示的手机号是否是移动手机号码
     */
    //方法一
    public static boolean test02practise1(String str){
        if (str.length() != 11)
        {
            return false;
        }
        String start3 = str.charAt(0)+str.charAt(1)+str.charAt(2)+"";
        switch (start3){
            case "150":
            case "151":
            case "152":
            case "157":
            case "158":
            case "159":
            case "134":
            case "135":
            case "136":
            case "137":
            case "138":
            case "139":
            case "182":
            case "187":
            case "188":
            case "147":
                return true;
            default:
                return false;
        }
    }

    //方法二
    public static boolean test02practise2(String str) {
        if (str.length() != 11) {
            return false;
        }
        if (str.startsWith("150")||str.startsWith("151")||str.startsWith("152")||str.startsWith("157")||str.startsWith("158")
                ||str.startsWith("137")||str.startsWith("138")||str.startsWith("139"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 字符串查询 indexOf() 从左到右查询,返回想查询字符或字符串第一次出现的下标
     *        lastIndexOf() 从左到右查询,返回想查询字符或字符串第一次出现的下标
     */
    public static void test03(){
        String str1 ="abc123hello123okabc";
        int index = str1.indexOf("123");    //str1中第一个"123"的下标位置
        System.out.println(str1);
        System.out.println("从左到右查询123在str中的索引下标为:" +index+" ;对应字符为: "+str1.charAt(index));
        int index2 = str1.indexOf("123",4); //从下标 4 开始向右查询第一个"123"的下标位置,即str1中第二个"123"的下标
        System.out.println("从左到右查询第二个123在str中的索引下标为:" +index2+" ;对应字符为: "+str1.charAt(index2));
        System.out.println("--------------");
        int index3 = str1.lastIndexOf("123");
        System.out.println("从右到左查询第一个123在str中的索引下标为:" +index3+" ;对应字符为: "+str1.charAt(index3));
        //查询字符串中包含几个"abc"(区分大小写)
        System.out.println("==========");
        String str2 = "jlABCkdjlkabc&lll23i1eklabclpol30123el4abcklkaBc";
        System.out.println("字符串为: "+str2);
        int count = 0;  //计数器
        int formIndex = 0;  //从字符串左边第一个字符下标0开始查询
        while(true)
        {
            int i = str2.indexOf("abc",formIndex);
            if (-1 == i)
            {
                break;
            }
            count++;
            formIndex = i + 1;
        }
        System.out.println("字符串中一共有:"+count+"个abc");

    }

    /**
     * 字符串的替换 replace("被替换词","替换词") , replaceFirst("被替换词(正则表达式)","替换词") , replaceAll("被替换词(正则表达式)","替换词")
     */
    public static void test04(){
        //abc替换成***
        String str1 = "jlABCkdjlkabc&lll23i1eklabclpol30123el4abcklkaBc";
        System.out.println("字符串为: "+str1);
        //替换单个字符 将 1 替换成 '好'
        System.out.println("1换成\'好\':"+str1.replace('1','好'));
        //替换所有abc为'***'(区分大小写)
        System.out.println("abc换成\'***\':"+str1.replace("abc","***"));
        //替换第一个abc(区分大小写)
        System.out.println("替换第一个abc"+str1.replaceFirst("abc","***"));
        //替换全部abc(不区分大小写)
        System.out.println("不区分大小写全部替换abc:"+str1.replaceAll("(a|A)(b|B)(c|C)","***"));

    }

    /**
     * 字符串的截取 subString(int beginIndex, int endIndex) 范围为[beginI , endI)
     * 字符串的切割 spilt("正则表达式"); 根据匹配给定的正则表达式来拆分字符串
     */
    public static void test05(){
        String str1 = "www.taobao.com";
        System.out.println(str1);
        System.out.println("字符串截取[0,3):"+str1.substring(0,3));    //下标范围为[0,3)    www
        System.out.println("字符串从Index=4开始截取到末尾:"+str1.substring(4));      //范围为从下标 4 到末尾  taobao.com

        //字符串切割 split("正则表达式")
        String str = "a=1;b=2;c=3";
        System.out.println("以;为分隔符分割字符串:"+str);
        //以 ; 为分隔符进行切割存入String的数组
        String[] strs = str.split(";");
        for (String temp:strs)
        {
            System.out.println(temp);
        }

    }

    /**
     * 字符串的拼接 +
     * 将其它数据类型转换成字符串
     */
    public static void test06(){
        String str = ""+123;
        str+=true;
        System.out.println(str);
        String str2 = "abc";
        str += str2;
        System.out.println(str);
        String str1 = "123";
        String str3 = str2.concat(str1);
        System.out.println(str3);
        System.out.println("===其它类型转为String===");
        String s = String.valueOf(true);    //"true" 将boolean类型的true转为字符串String类型的"true"
        System.out.println(s);
        String s1 = String.valueOf(1);   // 1 转为 String的 "1"
        System.out.println(s1);

    }

    /**
     * 字符串格式化输出 static format()
     * 匹配 matches("正则表达式")
     */
    public static void test07(){
        //格式化   %s,%d 占位符
        String str1 = "你好!%s,今天是%d年%d月%d日";
        String str2 = String.format(str1,"徐",2022,11,1);
        //将占位符变成具体的数值,格式化输出
        System.out.println(str2);

        //匹配 matches("regex")
        String number = "13962296673";
        System.out.println(number.matches("1\\d{10}"));

    }

    /**
     * String字符串对象内存存储问题
     */
    public static void test08(){
        String str1 ="abc";
        String str2 ="abc";
        //"abc"会直接存放在*静态常量池*,str1,str2存放*栈区*里,而str1和2都指向在静态常量池的 *同一个* abc字符串
        System.out.println(str1.equals(str2));
        System.out.println(str1==str2); //指向地址相同
        System.out.println("=======");
        String str3 =new String("abc");
        //new会创建一个String对象存放在 *堆区* ,str3指向String对象,堆区的string对象会复制*静态常量池*的abc字符串存放在堆区的对象里
        //静态常量池只存在一个"abc"字符串,而new会创建一个新的对象,其值为abc;str1,2指向静态常量池中的abc字符串;str3指向堆区的string对象
        System.out.println(str1.equals(str3));
        System.out.println(str1==str3);
    }


}
