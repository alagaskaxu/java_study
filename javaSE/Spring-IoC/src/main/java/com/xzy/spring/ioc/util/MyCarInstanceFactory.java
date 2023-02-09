package com.xzy.spring.ioc.util;

import com.xzy.spring.ioc.entity.Car;

public class MyCarInstanceFactory {
    /**
     * 创建汽车对象
     * @return
     */
    public final Car createNewCar(){
        System.out.println("MyCarInstanceFactory-->createNewCar");
        Car car = new Car();
        car.setColor("白");
        car.setName("宝马");
        return car;
    }
}
