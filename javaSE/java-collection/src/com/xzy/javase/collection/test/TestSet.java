package com.xzy.javase.collection.test;

import com.xzy.javase.collection.entity.Student;

import java.util.HashSet;
import java.util.Set;

/**
 * Set中如何判断两个对象或元素是重复的
 * 需要同时满足如下条件,就能判断重复
 *  a.两对象的hashCode()值相同
 *  b.这两个对象调用equals()方法比较时 返回true,表示两个对象相等
 */
public class TestSet {
    public static void main(String[] args) {
        Set<Student> stuSet = new HashSet<>();
        stuSet.add(new Student("张飞","220101",90,83,60));
        stuSet.add(new Student("刘备","220102",95,93,90));
        stuSet.add(new Student("张飞","220101",90,83,60));
        System.out.println(stuSet.size());  //2
        //有两对象的hashCode值相同,同时用equals方法比较发现返回true,即对象相同,则Set元素有重复
        System.out.println(stuSet);
    }
}
