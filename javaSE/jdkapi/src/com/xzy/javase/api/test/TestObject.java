package com.xzy.javase.api.test;

/**
 * 测试Object类
 */
public class TestObject
{
    public static void main(String[] args)
    {
        Object ob1 = new Object();
        Object ob2 = new Object();
        Object ob3 = ob1;
        //比较两个引用是否指向同一对象
        System.out.println(ob1 == ob2);
        System.out.println(ob1 == ob3);
        //比较两个对象值是否相等,默认是比较两个引用是否相同,该方法可以重写
        System.out.println(ob1.equals(ob2));
        //查看对象的值,通常子类重写该方法
        System.out.println(ob1.toString());

    }
}
