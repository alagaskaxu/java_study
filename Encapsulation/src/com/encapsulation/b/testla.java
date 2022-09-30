package com.encapsulation.b;

import com.encapsulation.a.Car;

public class testla extends Car{
    void test (){
        //注释的都是报错的
        //super.check();  //父类中 private 修饰 check表示私有,只能自己类能访问
        //super.addOil(); //父类中没修饰说明是default修饰的addOIl,
        // 只有同一个包的类能访问,不同的包不能访问default

        super.autoLighten();    //a包中Car父类中protected 修饰auto ,使b包的子类可以调用
        // 表示可以被同一个包的类以及其它包中的子类访问

        super.run();    //a包Car父类中 public 修饰 run,
        // 表示可以被该项目的所有包中的所有类访问

    }
}
