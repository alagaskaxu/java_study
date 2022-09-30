package com.encapsulation.a;

public class testA {
    public static void main(String[] args) {
        Car c = new Car();
        //c.check();  //check被private修饰,对象也无法调用,实现了安全性
        c.addOil();     //default修饰,同一包内访问
        c.autoLighten();    //protected修饰,同一包内和不同包的子类可以访问
        c.run();        //任何包内的任何类都可以访问

        System.out.println("--------");
        BYD byd = new BYD();
        byd.check();
        byd.addOil(); //BYD类重写了addoil方法且修饰了新的权限符
        byd.autoLighten();
        byd.run();

        //利用get,set方法修改调用Users的属性
        System.out.println();
        Users u = new Users();
        u.setId(1001);
        System.out.println(u.getId());
        u.setAdmin(true);
        System.out.println(u.isAdmin());
        u.setName("xu");
        u.login();

    }
}
