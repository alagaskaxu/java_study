package com.xzy.javase.collection.test;

import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList
 * 双向链表实现的List列表
 * 既可以看作一个顺序容器(双链表),又可以看作一个队列（Queue）,同时又可以看作一个栈（stack）
 * 线程不同步,线程不安全
 */
public class TestLinkedList
{
    public static void main(String[] args) {
        //双链表 :随意修改
        //test01();
        System.out.println("=====");
        //单双队列 :先进先出
        test02();
        System.out.println("=====");
        //栈 :先进后出
        test03();
    }

    /**
     * LinkedList的定义
     * 链表的定义和使用,与ArrayList几乎一样
     */
    public static void test01(){
        //List<String> citylist = new LinkedList<>();
        LinkedList<String> cityList = new LinkedList<>();
        cityList.add("南京");
        cityList.add(null);
        cityList.add("上海");
        cityList.add("南京");
        cityList.add("济南");
        cityList.add("武汉");
        int size = cityList.size();
        System.out.println(size);
        System.out.println(cityList);
        System.out.println("链表是否为空: "+cityList.isEmpty());
        System.out.println("链表是否包含上海: "+cityList.contains("上海"));
        //遍历链表与ArrayList一样
        for (String c:cityList) {
            System.out.println(c);
        }

        //删除,查询,添加,插入等方法与ArrayList一样
        String re = cityList.remove(1);
        System.out.println("删除下标为1的元素后的链表为: "+cityList+",删除元素为: "+re);
    }

    /**
     * 队列:先进先出
     * 队列(queue)的定义和使用
     * LinkedList包含Queue单向和Deque双向队列
     */
    public static void test02(){
        //用户队列列表,先进先出,先到先来
        LinkedList<String> userDeque = new LinkedList<>();
        //addLast() 队列的添加入队,即向末尾添加 ; addFirst() 向双向队列对首添加
        userDeque.addLast("小明");    //从队尾入队, void
        userDeque.offerLast("小王");  //向队尾插入元素,返回boolean,其他和addLast()差不多
        userDeque.offer("小美");  //入队
        System.out.println(userDeque);

        //getFirst() 获取队首元素
        System.out.println("得到队首元素: "+userDeque.getFirst());   //得到队首元素

        //pollFirst() 单队列队首出队
        String user = userDeque.pollFirst();    //返回出队元素,类似removeFirst()
        System.out.println(user+" 出队列");
        System.out.println(userDeque);

        //双向队列:两边都能进出元素
        //offerFirst() 在队首插入元素,和addFirst() 添加队首元素 差不多
        userDeque.offerFirst("x");  //return boolean
        System.out.println(userDeque);
        userDeque.addFirst("add");
        System.out.println(userDeque);  //void

    }

    /**
     * 栈 stack
     * 先进后出
     */
    public static void test03() {
        LinkedList<String> pokerStack = new LinkedList<>();
        pokerStack.push("红桃A");    //向栈顶压栈,入栈即List的第一个元素 void
        pokerStack.push("黑桃J");    //压栈,入栈 void
        pokerStack.addFirst("大王");    //向首部添加元素,效果类似,但建议栈用push
        //压栈用push,其他的添加都是向末尾添加
        pokerStack.offerLast("方块2");  //向队尾插入元素,返回boolean
        pokerStack.add("小王");  //向末尾添加,但是栈用push压栈
        System.out.println(pokerStack);

        //peek() 查看栈顶元素(大王),不会进行修改删除等操作
        String poker =  pokerStack.peek();  //返回元素值
        System.out.println("栈顶元素为: "+poker);
        poker = pokerStack.pop();   //元素出栈,即删除首元素,同时返回出栈的元素
        System.out.println("栈顶元素出栈后:"+pokerStack+",出栈元素为:"+poker);

    }

}
