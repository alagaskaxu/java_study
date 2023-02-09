package com.xzy.spring.ioc.util;

import com.xzy.spring.ioc.entity.Car;

/**
 * 汽车静态工厂类
 */
public class MyCarStaticFactory {
    /**
     * 创建汽车对象
     * @return
     */
    public final static Car createNewCar(){
        System.out.println("MyCarStaticFactory==>createNewCar");
        Car car = new Car();
        car.setColor("黑");
        car.setName("奔驰");
        return car;
    }
}
