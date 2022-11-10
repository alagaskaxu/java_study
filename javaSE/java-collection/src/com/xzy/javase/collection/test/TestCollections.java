package com.xzy.javase.collection.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections工具类
 * 是一个集合工具类，用于操作LIst，Set，Map等集合类的方法工具类
 * 包含添加,拷贝,反转,排序,打乱,最大值等方法
 * 与Arrays一样都是工具类,Arrays对数组操作,Collections对集合类操作
 */
public class TestCollections {
    public static void main(String[] args) {
        List<String> cityList1 = new ArrayList<>();
        //利用Collections工具 添加多个元素
        Collections.addAll(cityList1,"北京","东京","南京","上海");
        System.out.println(cityList1);

        List<String> cityList2 = new ArrayList<>();
        Collections.addAll(cityList2,"1","2","3","4","5","6");
        //Collections.copy(目标dest,源sre) 拷贝Collection类的对象,dest的size >= sre.size
        System.out.println(cityList2);
        Collections.copy(cityList2,cityList1);
        System.out.println(cityList2);

        //reverse 反转
        Collections.reverse(cityList2);
        System.out.println("反转2:"+cityList2);

        //sort 排序
        Collections.sort(cityList2);
        System.out.println("排序后cityList2:"+cityList2);

        //shuffle() 随机打乱顺序,对集合进行随机排序
        Collections.shuffle(cityList2);
        System.out.println("打乱后:"+cityList2);

        //toArray()  collection类转数组
        String[] i = new String[cityList2.size()];
        //Arrays.asList(); //Arrays工具类的转List类的方法,可以将数组转List
        cityList2.toArray(i);   //还返回一个数组
        System.out.println("转成数组后用Arrays工具类输出:"+Arrays.toString(i));
    }
}
