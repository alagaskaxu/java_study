package com.xzy.javase.Lambda.demo;

public class Demo02 {
    public static void main(String[] args) {
        //Car是接口,而且是函数式接口,只有一个接口,通过函数方法来实现其唯一的接口
        Car car = speed -> System.out.println("当前车速为:"+speed+"km/h");
        //Lambda表达式就是一个函数,此时run()方法的具体实现就是这个Lambda表达式
        car.run(100);
    }
}
