package com.javastudy.innerClass;

/**
 * 内部类的要点:
 * 1.内部类是一种特殊的类,指的是定义在一个类的内部的类
 * 2.实际开发中,为了方便的使用外部类的相关属性和方法,这时候会定义一个内部类.
 * 内部类可以直接访问外部类的私有属性,内部类被当成其外部类的成员.
 * 但外部类不能访问内部类的内部属性
 */

//外部类
public class Outer1 {
    private int age = 18;
    public void show(){
        System.out.println("外部类age:"+age);
    }

    //内部类:定义在外部类Outer1里面
    //非静态内部类,不能有静态的方法、静态属性、静态初始化块
    class Inner1{
        private int id = 1001;
        private int age = 22;

        public void test1(){
            System.out.println("Inner1.test1");
            System.out.println("内部类的age: "+age);    //age也可以写成this.age
            System.out.println("调用外部类的属性age: "+Outer1.this.age);  //通过 外部类名.this.属性名 来调用外部类的属性
            Outer1.this.show(); //调用外部类方法与调用属性同理
        }

    }

}
