package com.encapsulation.b;

import com.encapsulation.a.Car;

public class testB{
    public static void main(String[] args) {
        Car c = new Car();
        //c.check();  //check被private修饰,对象也无法调用,实现了安全性
        //c.addOil();     //default修饰,同一包内访问,a与b不同包不能访问
        //c.autoLighten();    //protected修饰,同一包内和不同包的子类可以访问
        //a与b不同包,testB不是Car的子类,c不是Car的对象,所以c不能访问Car里 protected 修饰的autolighten方法
        c.run();        //任何包内的任何类都可以访问

        testla ta = new testla();
        //ta.autoLighten();   //虽然testla类是Car的子类,在其类中能访问autoLighten()方法,
        // 但是ta是testla的实例对象,也不能访问在Car类中被protected 修饰的 auto()方法
        //并且testB还不是Car的子类,如果testB extends Car {},也需要使用super.auto来访问auto方法
    }
}
