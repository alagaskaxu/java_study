package com.xzy.javase.api.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 非运行时异常(一般异常)
 */
public class TestException {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "2022-11-03";
        //Date date = sdf.parse(str);
        //编译器发现 parse()可能会产生解析失败的异常,导致编译失败.
        // 需要抛出一般异常,使得编译通过,不然程序不会继续执行

        try {
            Date date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
