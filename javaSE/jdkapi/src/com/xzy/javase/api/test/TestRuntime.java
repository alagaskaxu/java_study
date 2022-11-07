package com.xzy.javase.api.test;

import java.io.IOException;

/**
 *
 */
public class TestRuntime {
    public static void main(String[] args) {
        Runtime.getRuntime().gc();
        System.out.println(1);
        //Runtime.getRuntime().exit(0);   //关闭JVM运行 0代表正常退出，非0代表异常中止
        System.out.println(2);
        try {
            Runtime.getRuntime().exec("D:\\QQ\\Bin\\QQScLauncher.exe");  //调用cmd命令控制系统,打开QQ
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
