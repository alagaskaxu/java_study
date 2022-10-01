package com.polymorphism;

/**
 * 多态:多态是指同一个方法调用,由于对象不同可能会有不同的行为
 * 要点:
 * 1.多态是方法的多态,不是属性的多态(多态与属性无关)
 * 2.多太的存在要有3个必要条件:继承,方法重写,父类引用指向子类对象
 * 3.父类引用指向子类对象后,用该父类引用调用子类重写的方法,此时多态就出现了
 *
 */
public class Animal {
    public void shout(){
        System.out.println("Animal.shout");
    }

}

class Dog extends Animal{
    //重写父类的shout方法
    @Override
    public void shout() {
        System.out.println("汪汪~");
    }
    public void watchDog(){
        System.out.println("watchdog");
    }

}

class Cat extends Animal{
    @Override
    public void shout() {
        System.out.println("喵喵~");
    }
}
