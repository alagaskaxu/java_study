package com.abstractClass;

/**
 * 抽象方法和抽象类
 * 抽象方法:
 * 1.使用abstract修饰的方法,没有方法体{},只有声明.
 * 2.定义的是一种规范,告诉子类必须要给抽象方法提供具体的实现
 * 抽象类:
 * 1.包含抽象方法的类就是抽象类(一般含有抽象方法的类就必须被定义为抽象类)
 * 2.通过抽象类,我们可以做到严格限制子类的设计,使子类之间更通用
 */

//抽象类
public abstract class Animal {
    //抽象方法
    public abstract void shout();
    //普通方法
    public void sleep(){
        System.out.println("animal.sleep");
    }
}

//Dog继承了Animal这个抽象类,则必须实现Animal里的抽象方法shout()
class Dog extends Animal{
    @Override
    public void shout() {
        System.out.println("Dog汪汪shout");
    }
}
//与Dog同样要具体实现shout()方法
class Cat extends Animal{
    @Override
    public void shout() {
        System.out.println("Cat喵喵shout");
    }
}

/**
 * 抽象类的使用要点:
 * 1.有抽象方法的类只能定义成抽象类
 * 2.抽象类不能实例化,即不能用new来实例化抽象类
 * 3.抽象类可以包含属性,方法,构造方法.但是构造方法不能用来new实例,只能用来被子类调用
 * 4.抽象类只能用来被继承
 * 5.抽象类方法必须被子类实现
 */

class Main{
    public static void main(String[] args) {
        Dog d = new Dog();
        d.shout();
        d.sleep();
        //抽象类不能实例化对象,即不能使用new
        Animal a = new Animal() {
            @Override
            public void shout() {
                System.out.println("抽象类不能被实例化,除非将抽象方法具体实现");
            }
        };
        a.shout();

    }
}