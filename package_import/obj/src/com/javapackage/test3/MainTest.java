package com.javapackage.test3;
/*
* import 导包
* 1.如果我们需要使用其它包的类,需要用import导包,从而可以在本类中直接通过类名来调用,减少无用代码书写
* 2.java会默认导入Java.lang包下所有的类,可以直接使用
* 3.如果导入两个同名的类,只能用包名+类名来显示调用相关类
 */
import com.javapackage.test2.Car;
import java.util.*;  //util一些实用工具类,Date用来表示时间日期
    //*会导入包里的所有类,会降低编译速度,但不会降低运行速度
//测试静态导入,利用静态导入可以直接使用类里的静态方法
import static com.javapackage.test2.Car.destory;

public class MainTest {
    public static void main(String[] args) {
        //调用包里的类,包名路径要完整,或者用import导入需要的包
        com.javapackage.test.Car car = new com.javapackage.test.Car();
        car.run();
        Car car2 = new Car();   //import了test2中的Car,可以直接用类名调用
        car2.stop();

        //调用时间类
        Date d = new Date();
        System.out.println(d);

        //测试静态导入
        com.javapackage.test.Car.build();   //类直接用类名调用静态方法
        Car.destory();
        //利用静态导入可以直接使用类里的静态方法,不需要类名
        destory();  //都是test2包里的Car类里的静态方法
    }
}
