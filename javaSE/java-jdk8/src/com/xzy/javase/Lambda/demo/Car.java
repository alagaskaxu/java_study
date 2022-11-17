package com.xzy.javase.Lambda.demo;

/**
 * 定义函数式接口
 * 函数式接⼝指的是只有⼀个函数的接口,
 * 这样的接⼝可以隐式转换为Lambda表达式
 */
@FunctionalInterface
public interface Car {
    /**
     * 汽车运行的速度
     */
    void run(int speed);
}
