package com.xzy.javase.collection.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 集合类中的ArrayList类
 * 动态数组
 * ArrayList<元素类型>
 *
 * vector类与ArrayList类似,都是动态数组
 * 区别: vector 线程同步,安全;
 * ArrayList 线程不安全
 */
public class TestArrayList {
    public static void main(String[] args) {
        test02();
    }

    /**
     * 创建动态数组ArrayList对象
     */
    public static void test01(){
        //Arraylist<>的几个定义方法与实例化
        ArrayList list = new ArrayList();
        ArrayList<String> strList = new ArrayList<>();  //只存放String类型的动态数组
        // new后的<>类型默认与前面一样是String,也可以写成<String>
        List<String> cityList = new ArrayList<>();  //List是ArrayList的父类,可以向上转型自动转型
    }

    /**
     * 常用方法
     */
    public static void test02(){
        List<String> cityList = new ArrayList<>();
        //add() 添加元素
        cityList.add("南京");
        System.out.println(cityList);
        //size() 查看动态数组有几个元素,而非容量大小
        int size = cityList.size();
        System.out.println(size);
        //isEmpty() 判断数组是否为空
        System.out.println(cityList.isEmpty());
        cityList.add(null);
        cityList.add("北京");
        cityList.add("上海");
        cityList.add("杭州");
        cityList.add("苏州");
        cityList.add("北京");
        System.out.println(cityList);

        //contains() 查询动态数组中是否包含某个元素
        System.out.println(cityList.contains(null));
        System.out.println("是否包含上海: "+cityList.contains("上海"));
        System.out.println(cityList.contains("深圳"));

        //get() 获取元素: 根据下标返回对应的元素
        String city = cityList.get(0);  //返回 下标为0 的数组元素
        System.out.println(city);

        System.out.println("=====for遍历ArrayList====");
        //遍历,循环ArrayList中所有的元素
        size = cityList.size(); //元素个数
        for (int index=0;index<size;index++)
        {
            System.out.println(cityList.get(index));
        }
        System.out.println("***foreach遍历ArrayList***");
        for (String c:cityList)
        {
            System.out.println(c);
        }
        System.out.println("***Lambda表达式遍历ArrayList***");
        cityList.forEach(c->{
            System.out.println(c);
        });
        System.out.println("***iterator迭代器遍历ArrayList***");
        //不建议用迭代器遍历ArrayList,代码不简练
        Iterator<String>iter =  cityList.iterator();
        while (iter.hasNext())
        {
            String c = iter.next();
            System.out.println(c);
        }

        System.out.println("====ArrayList的删除====");
        //remove()  删除动态数组中的元素
        System.out.println("原数组:"+cityList);
        String rec = cityList.remove(0); //根据下标移除首个对应元素,并返回被删除的元素值
        System.out.println("移除对应下标0的元素后的动态数组: "+cityList);  //移除第一个对应的元素
        System.out.println("被删除的元素是: "+rec);

        boolean b = cityList.remove("北京");  //删除首个指定的元素,返回布尔值
        System.out.println("是否成功删除 北京"+b);
        System.out.println("删除对指定的元素后的动态数组: "+cityList);    //删除的都是第一个对应的元素

        //clear() 清空所有元素
        //cityList.clear();
        //System.out.println("清空所有元素后AList:"+cityList);

        //add() 添加,插入(输入索引就是插入)
        cityList.add(1,"重庆");
        System.out.println("在下标为1 处插入重庆后:"+cityList);

        //indexOf() 查询元素下标位置,没有则返回-1
        System.out.println("重庆所在下标位置:"+cityList.indexOf("重庆"));
        System.out.println("南京所在下标位置:"+cityList.indexOf("南京"));

    }
}
