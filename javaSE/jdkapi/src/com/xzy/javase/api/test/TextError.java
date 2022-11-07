package com.xzy.javase.api.test;

/**
 * 测试系统异常 Error(错误).如:内存不足,内存栈溢出
 */
public class TextError {
    public static void main(String[] args) {
        //test01();
        //test02();
    }

    /**
     * 测试内存不足错误:OutOfMemoryError
     */
    public static void test01() {
        StringBuffer strBuf = new StringBuffer();
        while (true) {
            strBuf.append("a");
        }
    }

    /**
     * 方法调用过多,栈溢出错误,StackOverflowError
     */
    public static void test02() {
        test02();
    }
}