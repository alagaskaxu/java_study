package com.xzy.javase.collection.test;

import java.util.Stack;

/**
 * Stack类 单独的栈类 继承于Vector动态数组
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> pokerStack = new Stack<>();
        //push() 压栈
        pokerStack.push("黑桃2");
        pokerStack.push("梅花3");
        pokerStack.push("方块k");
        pokerStack.push("小王");
        System.out.println("栈元素个数: "+pokerStack.size());
        //peek() 查看栈顶元素
        System.out.println("栈顶元素: "+pokerStack.peek());
        System.out.println(pokerStack);
        //pop() 出栈,删除栈顶对象,同时返回出栈的元素
        System.out.println(pokerStack.pop()+" 出栈");
        System.out.println(pokerStack);
    }
}
