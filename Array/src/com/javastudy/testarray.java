package com.javastudy;

/**
 * 数组的定义和本质
 * 数组定义:
 * int[] a = new int[5];
 * Car[] cars = new Car[5];
 * 数组是相同数据的有序集合.
 * 数组的特点:
 * 1.长度确定.数组 一旦被创建,它的大小就是不可以改变的
 * 2.其元素的类型必须是相同类型,不允许出现混合类型
 * 3.数组类型可以是任何数据类型,包括基本类型和引用类型
 * 4.数组也是对象.数组中的元素相当于该对象的成员变量
 */
public class testarray {
    public static void main(String[] args) {
        //普通数组的定义
        int[] a = new int[5];   //定义一个int类型的数组,数组名叫a,数组元素个数为5
        int b[] = new int[5];   //同上,数组名叫b

        //数组的初始化,数组默认值为0
        a[0] = 10;  //5元素的数组,下标从0开始,0-4;
        System.out.println("int数组默认值a[1]= "+a[1]+"初始化后的a[0]值为: "+a[0]);
        //数组初始化一般用循环,叫动态初始化
        System.out.println("数组a的元素(长度):"+a.length);   //a.length 表示数组a的长度 5个元素
        for (int i=0;i<a.length;i++){
            a[i] = 10 + 10*i;   //动态初始化
        }

        //遍历数组
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }

        //静态初始化数组
        int c[] = {100,200,300,400};    //等价 int[] c = {100,200,300,400}
        //通过for-each循环遍历数组c,简化遍历的代码
        for (int temp:c){   //增强for循环 temp:c 表示从c数组里取出遍历的元素放入临时变量temp
            System.out.println(temp);
        }
        //for_each循环遍历数组代码本质的实现原理如下:
        for (int i = 0; i<c.length; i++){
            int temp = c[i];
            System.out.println(temp);
        }

    }
}
