package com.xzy.javase.thread.demo;

import java.util.Stack;

/**
 * 顾客线程
 */
public class CustomerThread extends Thread{

    /**
     * 存放商品栈对象
     */
    private Stack<String> productStack;
    public CustomerThread() {
    }

    public CustomerThread(Runnable target) {
        super(target);
    }

    public CustomerThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public CustomerThread(String name) {
        super(name);
    }

    public CustomerThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public CustomerThread(Runnable target, String name) {
        super(target, name);
    }

    public CustomerThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public CustomerThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }

    public Stack<String> getProductStack() {
        return productStack;
    }

    public void setProductStack(Stack<String> productStack) {
        this.productStack = productStack;
    }

    @Override
    public void run() {
        //从商品栈中 抢购一个商品(移除并获取栈顶对象)
        String name = this.getName();
        if (productStack.empty())
        {
            System.out.println("商品数量为0,["+name+"]抢购未成功");
            return;
        }else
        {
            String productName = productStack.pop();
            System.out.println("恭喜:"+name+",成功抢购到["+productName+"]");
        }
    }
}
