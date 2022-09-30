package com.encapsulation.a;

public class BYD extends Car{
    //被访问权限符修饰的方法仍可以重写,在权限范围内系统能够找到父类的方法名并自动生成,权限外无法自动识别,可以视为自己重写一段重名的方法

    public void check(){    //private修饰的方法系统不能找到名字自动生成
        System.out.println("B重写private修饰的方法");
    }
    @Override
    protected void addOil() {     //可在重写方法时再加上新的权限修饰符,但是只能使比之前权限高,不能从public到private
        System.out.println("B重写addoil方法");
    }
    @Override
    protected void autoLighten() {
        System.out.println("B重写auto方法");
    }
    @Override
    public void run() {
        System.out.println("B重写run方法");
    }

    void test(){
        //注释说明报错
        //super.check();  //父类中 private 修饰 check表示私有,只能自己类能访问
        super.addOil(); //父类中没修饰说明是default修饰的addOIl,
        // 只有同一个包的类能访问

        super.autoLighten();    //a包Car父类中 protected 修饰 auto,
        // 表示可以被同一个包的类以及其它包中的子类访问

        super.run();    //父类中 public 修饰的 run,表示可以被该项目的所有包中的所有类访问

    }
}
