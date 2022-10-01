package com.polymorphism;

import javax.xml.crypto.Data;

public class testPolym {
    public static void main(String[] args) {
        //多态
        Dog d = new Dog();

        animalCry(d);   //Animal父类引用a 指向子类对象d

        Cat c = new Cat();
        animalCry(c);   //Animal父类引用a 指向子类对象c

        //对象的转型,子类向父类转型叫向上转型,如子类Dog传入Cry方法转型为Animal父类对象
        Animal a = new Dog();   //这是向上转型
        //转型后成为了Animal类,而不是Dog类(有点像强制类型转换)
        //a.watchDog;   //报错

        //利用强制转型可以改变类型
        Dog a2 = (Dog)a;
        a2.watchDog();
        //Cat a3 = (Cat)a;  //可以转,语法没错,编译能通过,但是编译完运行时会报错;运行时会判断类型转换是否正确

    }
        //父类Aniaml的形参接收了其子类Dod类的对象d(即父类引用指向了子类对象)
    static void animalCry(Animal a){
        System.out.println("--step1--");
        //Animal父类引用 指向Dog,Cat子类对象,(a指向子类对象d和c)
        // 父类引用指向子类对象后,用该父类引用a 调用子类重写的方法(Dog和Cat里重写的shout方法)
        a.shout();
        System.out.println("--step2--");

    }
}
