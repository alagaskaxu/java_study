package com.xzy.javase.array.test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * java.util.Arrays
 * 1.测试 Arrays类
 * Arrays类提供了数组操作的静态方法
 * 拥有 数组的拷贝,排序,查询,比较等基本方法
 *
 * 注意区分:
 * 2.Array类在 java.lang.reflect包
 * Array类提供了动态创建和访问java数组的方法
 */
public class TestArrays {
    public static void main(String[] args) {
        int[] i = {23,1,2,-1,1};
        //使用二分查找前先排序 sort()
        Arrays.sort(i);
        for (int k:i)
        {
            System.out.print(k+" ");
        }
        System.out.println();
        //binarySearch() 二分查找
        int index = Arrays.binarySearch(i,1);   //二分查找,找到则返回对应下标
        System.out.println("二分查找数组中的 第一个 1的下标: "+index);
        int index2 = Arrays.binarySearch(i,15); //未找到返回负数,一般返回被查找关键字应该在几号位(下标+1)的负数
        System.out.println("二分查找未找到目标时返回负数下标: "+index2);

        //数组拷贝
        System.out.println("===Arrays.copyOf==");
        //copyOf() 按数组长度拷贝数组
        String[] strs = {"abc","123","456","fhg"};
        String[] strs1 = Arrays.copyOf(strs,3); //只拷贝0-2下标的元素,存放在长度为3的数组里
        //如果长度超过原数组,超过部分对应元素的值为null
        for (String s:strs1)
        {
            System.out.println(s);  //abc  123  456
        }
        System.out.println("====");
        //copyOfRange() 按下标来拷贝 范围[,)
        String[] strs2 = Arrays.copyOfRange(strs,1,3); //范围为[1,3)只拷贝1-2下标的元素
        for (String s:strs2)
        {
            System.out.println(s);  //123  456
        }

        System.out.println("====Systm.arraycopy====");
        /*
          System类中的arraycopy(Object src,int srcPos,Object dest,int destPos,int length) 数组拷贝方法
          src-源数组; srcPos-源数组中的起始位置;
          dest-目标数组; destPos-目标数据中的起始位置;
          length-要复制的数组元素的数量
        */
        int[] src = {2,4,6,88,9,0};
        int[] dest = new int[10];
        System.out.println(Arrays.toString(src));
        System.out.println(Arrays.toString(dest));
        //arraycopy() 容易出错,能抛出三种运行时异常,需要注意下标和长度
        System.arraycopy(src,0,dest,1,3);
        System.out.println(Arrays.toString(dest));

        System.out.println("===Arrays.toString==");
        //toString() 查看数组中的内容,按默认格式返回数组的元素
        System.out.println(Arrays.toString(i));
        System.out.println(Arrays.toString(strs));

        //Array,类反射,动态创建和访问java数组的方法
        //引用没直接指向数组对象,想访问数组的一些属性需要利用Array来间接访问
        Object ob = new int[]{12,134,14};
        if (ob.getClass().isArray())
        {
            System.out.println("array");
            int len = Array.getLength(ob);  //间接访问Object类 ob 对象的长度
            System.out.println("长度:"+len);
        }
    }
}
