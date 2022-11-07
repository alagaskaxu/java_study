package com.xzy.javase.api.test;

import com.xzy.javase.api.demo.NotFoundSexException;

/**
 * throw
 * 手动抛出异常,方法体内抛出异常,表示此处存在异常
 */
public class TestThrow {
    public static void main(String[] args) {
        //测试手动抛出运行时异常,编译时不会报错,不需要try-catch处理异常
        printSexText(2);    //遇到异常没捕获或抛出则程序就结束了
        //也可以通过try-catch捕获处理异常,获得想要的异常信息,同让程序继续运行.
        // 如: e.getMessage()等异常方法

        //测试编译时异常,一定需要try-catch处理异常或者throws抛出异常
        try {
            printSexText2(3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //测试自己定义的异常
        try {
            printSexText3(3);
        } catch (NotFoundSexException e) {
            e.printStackTrace();
        }
    }

    public static void printSexText(int sex)
    {
        if (1==sex){
            System.out.println("男性");
        }else if (2==sex)
        {
            System.out.println("女性");
        }else
        {
            //抛出一个运行时异常(方法体内手动抛出异常),编译时不会报错
            //throw new RuntimeException("未知性别:[ "+sex+" ]");

            //抛出 具体的运行时异常:向方法传递非法参数 异常,编译时不会报错
            throw new IllegalArgumentException("未知性别:[ "+sex+" ]");   //向方法传递非法参数的运行时异常
            //抛出异常后,程序就终止了
            //System.out.println("fail");
        }
    }

    //检测性(编译时)异常,在编译时就会报错,而非运行时
    public static void printSexText2(int sex) throws Exception {
        String text;
        if (1==sex){
            text = "男性";
        }else if (2==sex)
        {
            text="女性";
        }else{
            //检测性(编译时)异常
            throw new Exception("未知性别:[ "+sex+" ]");  //编译时就会报错,需要throws抛异常给出去,不建议用try-catch自己处理异常
        }
    }

    //测试自定义的异常
    public static void printSexText3(int sex) throws NotFoundSexException {
        String text;
        if (1==sex){
            text = "男性";
        }else if (2==sex)
        {
            text="女性";
        }else{
            //自定义的编译时异常
            throw new NotFoundSexException("未知性别:[ "+sex+" ]");  //编译时就会报错,需要throws抛异常给出去,不建议用try-catch自己处理异常
        }
    }
}
