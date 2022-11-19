package com.xzy.javase.Lambda.demo;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * lambda表达式
 */
public class Demo01 {
    public static void main(String[] args) {
        test01();
        test02();
        test03();
        test04();
        test05();
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
     * 调⽤⽅法:R apply(T t);
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
     * T:传⼊参数类型;没有出参返回值
     * 调⽤⽅法:void accept(T t);
     */
    public static void test03(){
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("hello");
        Arrays.asList("a","b","c","d").forEach(consumer);
    }

    /**
     * 生产型接口
     * Supplier<T>
     * T:返回值类型;没有传入参数
     * 调⽤⽅法:T get();
     */
    public static void test04(){
        Supplier<Integer> supplier = ()->{
            Random rd = new Random();
            return rd.nextInt(100)+1;
        };
        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());
    }

    /**
     * 断定型接口
     * Predicate<T>
     * T:传入参数类型;返回值为true|false
     * 传入参数类型任意
     * 调⽤⽅法: test(T)
     */
    public static void test05(){
        Predicate<Date> predicate = date -> {
            if (date == null){
             throw new IllegalArgumentException("日期不可为null");
            }
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            return 1==dayOfWeek;
        };
        System.out.println(predicate.test(new Date()));
    }
}
