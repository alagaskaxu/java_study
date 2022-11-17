package com.xzy.javase.Lambda.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * lambda表达式
 */
public class Demo01 {
    public static void main(String[] args) {
        test01();
        test02();
        test03();
    }
    public static void test01(){
        List<String> cityList = new ArrayList<>();
        cityList.add("南京");
        cityList.add("北京");
        cityList.add("上海");
        cityList.add("杭州");
        cityList.forEach(city-> System.out.println(city));
    }

    /**
     * 函数式接口
     * Function<T, R>
     * Function<T, R> T为传入的参数; R为返回值类型
     */
    public static void test02(){
        //将Data类型变为String类型的时间
        Function<Date,String> fun =date->{
            if (date == null){
                return null;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return sdf.format(date);
        };

        String time = fun.apply(new Date());
        System.out.println(time);
    }

    /**
     * 消费型接口
     * Consumer<T>
     * T:⼊参类型;没有出参
     */
    public static void test03(){
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("hello");
        Arrays.asList("a","b","c","d").forEach(consumer);
    }

}
