package com.xzy.javase.collection.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map接口
 * HashMap类
 * 不会自动排序,是散列表,无序的;{nanjing=南京, null=null, 1=1, shanghai=上海, beijing=北京}
 * HashMap<key,value>
 * HashMap原理或底层结构
 * 1.宏观上看是可变长的数组
 * 2.该数组中每一个元素存放的是一个链表
 * 3.当链表中的对象达到一定数量时,支持红黑二叉树
 *
 * 利用哈希函数hash,hash(key)得到对应的值
 * 该值可以确定 链表 在HashMap的数组里的存放位置
 * 将包含key和value的链表存放在数组里对应值的位置
 * 链表根据key找对应value
 * 综上,一个key对应一个数组位置和一个链表元素
 *
 * Hashtable类 与 HashMap 差不多
 * 区别: Hashtable的key和value不能是null
 * Hashtable线程同步安全,HashMap线程不安全异步
 */
public class TestHashMap {
    public static void main(String[] args) {
        //HashMap的定义方法
        HashMap<String,String> cityMap0 = new HashMap<>();
        Map<String,String> cityMap = new HashMap<>();

        //put(key,value) 添加键值对(key和value一对)
        cityMap.put("nanjing","南京1");    //key唯一,key=nanjing,value = 南京1
        cityMap.put("nanjing","南京");    //key唯一,相同的key,value会覆盖旧值
        int size = cityMap.size();  //一个元素(一个key值)
        System.out.println(size);
        System.out.println(cityMap);
        System.out.println(cityMap.isEmpty());
        cityMap.put(null,null); //key,value可以是null
        cityMap.put(null,null); //key仍是唯一的,覆盖了旧的null
        System.out.println(cityMap);
        cityMap.put("shanghai","上海");
        cityMap.put("beijing","北京");
        cityMap.put("1","1");
        System.out.println(cityMap);    //HahsMap 是无序的,不会排序也不会按存放顺序存放
        //{nanjing=南京, null=null, 1=1, shanghai=上海, beijing=北京}

        //get(key) 根据key来获取value值,没有则是null,只能依靠key来找value
        String city = cityMap.get("shanghai");
        System.out.println(city);
        city = cityMap.get("shenzhen"); //没有这个key
        System.out.println(city);

        //remove(key) 通过key删除键值对,key存在则返回value,不存在返回null
        System.out.println(cityMap);
        city = cityMap.remove("shanghai");
        System.out.println(city);
        System.out.println(cityMap);

        //replace(key) 根据key替换value值,返回被替换的值
        city = cityMap.replace("beijing","北京1北京");
        System.out.println(cityMap+"被替换的值"+city);

        //containsKey(key)  是否包含key
        System.out.println("是否包含key:beijing:"+cityMap.containsKey("beijing"));

        //遍历键值对
        cityMap.keySet();   //得到所有key的set集合
        //方法一:迭代器
        System.out.println("===迭代器遍历===");
        Iterator<String> iter = cityMap.keySet().iterator();    //HashMap key的set集合的迭代器
        while (iter.hasNext())
        {
            String key = iter.next();
            String value = cityMap.get(key);    //根据key得到value
            System.out.println(key+"=>"+value);
        }

        //方法二:Lambda表达式 jdk8的forEach(Lambda表达式)
        System.out.println("===forEach(Lambda表达式)遍历===");
        cityMap.forEach((k,v)->{
            System.out.println(k+"-->"+v);
        });

        //方法三: foreach遍历key,从而得到key-value
        System.out.println("=foreach遍历key,从而得到key-value=");
        for (String k:cityMap.keySet()) {
            String value = cityMap.get(k);    //根据key得到value
            System.out.println(k+"="+value);
        }

        // Entry是Map内部接口,HashMap内部类,用来存放一组键值对
        //Map.Entry<key的类型,value的类型>是Map的内部接口
        //HashMap.Entry<key,value>是HashMap的内部类
        //方法四:获取所有键值对(Entry)的迭代器.
        System.out.println("==Entry迭代器,entry.getkey/value==");
        Iterator<Map.Entry<String,String>> entryIter = cityMap.entrySet().iterator();
        while (entryIter.hasNext())
        {
            Map.Entry<String,String> entry = entryIter.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+"--"+value);
        }

        //方法五:遍历HashMap中的Entry(键值对)内部类;Entry对象里存放着键值对的key和value;
        Set<Map.Entry<String,String>> entrySet = cityMap.entrySet();    //entrySet将Entry内部类作为key类型存放在set里
        System.out.println("key类型为Entry的set类:"+entrySet);   //set<key的类型>,set类只会存放key不会有value,利用Entry直接存放一组键值对Entry对象
        System.out.println("==entrySet()方法,entry.getkey/value==");
        for (Map.Entry<String,String> entry:entrySet)
        {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+"-->"+value);
        }

    }
}
