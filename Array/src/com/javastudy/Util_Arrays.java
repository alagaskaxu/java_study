package com.javastudy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 测试工具类:java.util,Arrays
 */
public class Util_Arrays {
    public static void main(String[] args) {
        int[] c = {10,32,8,4,100,40};
        System.out.println(c);
        //利用Arrays工具类简化使用数组的方法
        System.out.println(Arrays.toString(c)); //toString是Arrays类里的静态方法
        //Arrays.toString(c)遍历c数组的元素
        Arrays.sort(c); //sort数组排序
        System.out.println(Arrays.toString(c));

        //binarySearch(数组,查找目标)二分查找
        System.out.println(Arrays.binarySearch(c,100));
        //存在则返回数组下标,不存在则返回负数

        //fill(数组名,填充值)数组填充
        int d[] = new int[10];
        Arrays.fill(d,100);
        System.out.println(Arrays.toString(d));

    }
}
