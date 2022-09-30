package com.encapsulation.a;

/**
 * 封装:提高代码的安全性和复用性
 * 高内聚(封装细节,便于修改内部代码,提高可维护性)
 * 低耦合(简化外部调用,便于调用者使用,便于扩展和协作)
 *
 * 访问权限修饰符,可以修饰方法和属性,作用相同,具体如下:
 * private 表示私有,只能自己类能访问
 * default 表示没有修饰符修饰,只有同一个包(包括同一包内的子类)的类能访问,其它包不行
 * protected 表示可以被同一个包的类以及其它包中的子类访问
 * public 表示可以被该项目的所有包中的所有类访问
 *
 */
public class Car {
    int id;     //不加修饰表示修饰符为default
    private String brand;

    private void check(){   //private 表示私有,只能自己类能访问
        System.out.println("car.check");
    }
    void addOil(){      //不加修饰符就是默认修饰符为default
        System.out.println("car.addOil");
    }
    protected void autoLighten(){     //protected 表示可以被同一个包的类以及其它包中的子类访问
        System.out.println("car.autoLighten");
    }
    public void run(){      //public 表示可以被该项目的所有包中的所有类访问
        System.out.println("car.run");
    }
}
/**
 * 封装的简单规则:
 * 1.属性一般使用private访问权限
 * 2.属性私有后,提供相应的get/set方法来访问相关属性,
 * get/set方法通常是public修饰的,以提供对属性的赋值与读取操作
 * (注意:boolean变量的get方法是 is 开头的)
 * 方法:一些只用于本类的辅助方法可以用private修饰,
 * 希望其它类 调用的方法用public修饰
 */
