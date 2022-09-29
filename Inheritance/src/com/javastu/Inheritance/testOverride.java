package com.javastu.Inheritance;
/*
*
  方法的重写:override
  子类通过重写父类的方法可以用自身的行为替换父类的行为
  方法的重写是实现多态的必要条件
  三个要点:
  1.方法名,形参列表相同    ==
  2.返回值类型和声明异常类型,子类小于等于父类   <=
  3.访问权限,子类大于等于父类    >=
 */
public class testOverride {
    public static void main(String[] args) {
        Horse h1 = new Horse();
        h1.run();   //horse没重写则直接调用了父类Vehicle的方法,但是horse需要有自己的run()方法,需要利用方法的重写override
        h1.addOill();
        h1.addOill(2);
        Plane p1 = new Plane();
        p1.run();
        p1.stop();
    }
}

class Vehicle{
    public void run(){
        System.out.println("run---");
    }
    public void stop(){
        System.out.println("stop||");
    }
    /**
     * final关键字
     * 修饰变量:被修饰的变量不可改变.一旦赋了初值,不能被重新赋值. final int MAX_SPEED = 120;
     * 修饰方法:该方法不可被子类重写,但是可以被重载! final void study(){}
     * 修饰类:修饰的类不能被继承.如:Math,String等. final class A {}
     */
    public final void addOill(){
        System.out.println("加油");   //被final修饰,子类不能重写该方法
    }
    //final修饰的方法可以重载
    public final void addOill(int a){
        System.out.println(a+"号加油");
    }
}

class Horse extends Vehicle{
    //public void addOill(){}   被final修饰,子类不能重写该方法

    //方法的重写override(覆盖)
    /*
    @Override   //标记一下,便于理解
    public void run(){

        System.out.println("马踏飞燕");
    }
    */
}

class Plane extends Vehicle{
    //方法的重写override(覆盖)
    public void run(){
        System.out.println("天上飞");
    }
    public void stop(){
        System.out.println("降落机场");
    }

}
