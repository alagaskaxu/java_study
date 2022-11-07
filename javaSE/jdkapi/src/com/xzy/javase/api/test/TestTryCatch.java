package com.xzy.javase.api.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 捕获异常
 * try{     //try必须有
 *
 * }catch{  //try可以与 *多个catch* 一起使用
 *
 * }finally{    //try-finally组合使用时,finally可以没有; try-finally组合时,catch可以没有,但是不建议没有catch
 *
 * }
 */
public class TestTryCatch {
    public static void main(String[] args) {
        test01();
        System.out.println("======");
        test02();
        System.out.println("======");
        test03();

    }

    public static void test01(){
        try{
            int i =3/0;     //遇到异常下面的语句不会执行,有try-catch捕获异常后,直接跳转到catch语句里
            System.out.println("ok");   //不会执行
        }catch (ArithmeticException e)  //捕获异常是 算术异常
        {
            e.printStackTrace();    //打印运行栈,在命令行打印异常信息在程序中出错的位置及原因
            System.out.println("fail");
        }finally {
            //finally最终,不管有没有发生异常都需要执行
            //finally语句一般可以不加
            System.out.println("finally");

        }
        //try-catch后的语句可以继续正常执行;
        System.out.println("end");
        // 如果异常不捕获处理,程序会结束,在异常语句后的语句都不会执行
    }

    public static void test02(){
        try {   //存在多个异常时,只会捕获第一个异常并处理
            String str = null;
            String str1 = "123";
            str.length();   //空指针异常
            //str1.charAt(5); //字符串下标越界异常
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            String str2 = "2022y89";
            Date date = sdf.parse(str2);    //解析时异常
            System.out.println("0k");

        }catch (ArithmeticException e){ //捕获算术异常,无法捕获空指针异常
            e.printStackTrace();
            System.out.println("发生算术异常");   //不会执行
        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("发生空指针异常");  //捕获空指针异常后,会执行
        }catch (Exception e){   //捕获任意异常,可以处理所有异常
            e.printStackTrace();
            System.out.println("不常见异常");
        }
        System.out.println("end");  //如果没有捕获对应异常则不执行,因为异常未正确捕获,存在异常,程序结束
    }

    public static void test03(){
        try {
            String str = "123";
            str.charAt(5); //字符串下标越界异常

        }catch (Exception e){   //捕获任意异常,可以处理所有异常
            e.printStackTrace();
            System.out.println("异常");
        }
        System.out.println("end");
    }

}
