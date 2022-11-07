package com.xzy.javase.collection.test;

import java.util.TreeMap;

/**
 *
 * TreeMap类
 * 会根据key来进行排序,增加系统运行效率
 * 1.底层实现方法为 红黑树
 * 2.根据key进行排序,排序方式分为两种:a.默认 b.自定义规则,即比较器
 * 3.不允许key是null,value可以是null
 * 4.线程不安全不同步
 */
public class TestTreeMap {
    public static void main(String[] args) {
        TreeMap<String,String> cityMap = new TreeMap<>();
        cityMap.put("sh","上海");
        cityMap.put("wx","无锡");
        cityMap.put("nj","南京");
        cityMap.put("nt","南通");
        cityMap.put("wh","武汉");
        cityMap.put("1","1");
        cityMap.put("-1","-1");
        System.out.println(cityMap);    //TreeMap会自动排序,不按存放先后
        //cityMap.put(null,null);     //TreeMap的key不能为null,会运行时异常
        cityMap.put("",null);   //value可以是null
        System.out.println(cityMap);
    }
}
