package com.xzy.javase.Lambda.demo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo04 {
    public static void main(String[] args) {
        test01();
        test02();
    }

    public static void test01() {
        List<String> cityList = new ArrayList<>();
        List<String> cityList2 = new ArrayList<>();
        cityList.add("南京");
        cityList.add("北京");
        cityList.add("上海");
        cityList.add("苏州");
        //cityList.forEach(e -> {System.out.println(e);});
        cityList.forEach(System.out::println);  //效果同上
        System.out.println("==========");
        //拷贝
        cityList.forEach(cityList2::add);
        cityList2.forEach(e -> System.out.println(e));
    }

    public static void test02() {
        Map<String,String> map = new HashMap<>();
        map.put("nj","南京");
        map.put("bj","北京");
        map.put("sh","上海");
        map.forEach((k,v)->System.out.println(k+"===>"+v));
    }
}