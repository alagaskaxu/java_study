package com.xzy.javase.api.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * throws
 * 方法抛出异常,一般抛出检测性(编译时)异常;运行时异常一般用try-catch
 * 目的:通过编译,让程序正常运行
 * throws抛出异常,谁调用该方法由谁处理这个异常
 * try-catch则是遇到异常由自己处理完异常
 *
 * throw 手动抛出异常,方法体内抛出异常,表示此处存在异常
 */
public class TestThrows {
    public static void main(String[] args) {
        //main方法可以抛出异常给JVM(JVM会异常终止),但是不建议用throws,抛出异常,而是try-catch捕获处理异常

        /**/
        try {
            m3();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**/

        //m4已处理过异常
        m4();

        //处理过异常,同时能知道具体异常的类型与具体实现捕获的方法和详细位置
        m5();

    }
    public static void m1() throws ParseException, IOException {    //抛出对应异常,一般是检测性(编译时)异常
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str="2022-11-y4";
        Date date = sdf.parse(str);
        System.out.println(date);
        Runtime.getRuntime().exec("D:\\QQ\\Bin\\QQScLauncher.exe");
    }
    public static void m2() throws Exception{   //直接抛出所有异常,Exception可以代表所有异常
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str="2022-11-y4";
        Date date = sdf.parse(str);
        System.out.println(date);
        Runtime.getRuntime().exec("D:\\QQ\\Bin\\QQScLauncher.exe");
    }

    public static void m3() throws ParseException, IOException {    //可以直接抛出Exception父类
        //可以try-catch处理异常,也可以直接抛出,让其他方法处理
        m1();
    }
    public static void m301() throws Exception{
        m1();   //可以直接抛出Exception父类,减少书写
    }

    public static void m4(){    //可以 throws Exception
        //直接捕获处理异常,便于main方法调用
        try {
            m1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void m5(){
        //直接捕获处理*编译时异常*,便于其他方法调用,不再需要捕获或抛出的一大段代码
        try {
            m1();   //throws ParseException, IOException
        } catch (Exception e) {
            e.printStackTrace();
            //如果出现异常则将编译时异常捕获的同时再抛出运行时异常
            throw new RuntimeException(e);
            //**将编译时异常转为运行时异常好处:
            // 减少其他方法调用的复杂度,同时又能让其他方法知道出现异常的具体类型与具体实现捕获异常方法和详细位置
        }
    }

}
