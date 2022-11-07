package com.xzy.javase.array.test;

/**
 * 一维数组
 * 数组特点:
 * 1.内存空间连续的
 * 2.大小或长度不可以改变
 * 3.数组通常存放同一种数据类型
 */
public class TestArray01 {
    public static void main(String[] args) {
        //数组定义
        int[] i = new int[10];  //编译器会用默认值初始化数组; int 默认值为 0;double默认 0.0;String 默认 null
        //数组定义与初始化
        int[] j = {12,13,14,15};
        int[] k = new int[]{1,2,3,4,5};
        System.out.println(k.getClass());
        System.out.println(k.getClass().isArray()); //判断是否是数组
        System.out.println(i.length);
        System.out.println(i[0]);
        int len = k.length; //数组长度
        //数组下标从0开始,到len-1
        for (int index=0;index<len;index++){
            System.out.print(k[index]+" ");
        }
        System.out.println();
        //foreach打印数组 k
        for (int d:k) {
            System.out.print(d+" ");
        }
        System.out.println();
        k[0]=15;    //对应位置重新赋值
        System.out.println("k[0]= "+k[0]);
        //字符串类型的一维数组
        String[] strings = {"hello","java","world"};
        for (String s: strings) {
            System.out.print(s);
        }
        System.out.println();
        System.out.println("======");
        printData();    //0
        printData(10,20,30);    //3
        System.out.println("======");
        printData(new int[]{23,44});    //2


    }

    // ...表示可以传多个值或者0个值,本质是依靠数组实现的,传数组也行
    public static void printData(int ...i){
        System.out.println(i.length);
    }
}
