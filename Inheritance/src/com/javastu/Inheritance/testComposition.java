package com.javastu.Inheritance;

import jdk.nashorn.internal.objects.annotations.Constructor;

/**
 *  组合Composition
 *  组合的核心就是将父类对象作为子类的属性,然后子类通过调用这个属性来获得父类的属性和方法
 *  组合和继承特点:
 *  1.组合比较灵活.继承只能有一个父类,但是组合可以有多个属性
 *  2.对于"is-a"关系(是什么,Student is a Person)建议使用继承,
 *  "has-a"关系(拥有,computer has CPU,Memory...)建议使用组合
 */
public class testComposition {
    public static void main(String[] args) {
        Stu u1 = new Stu();
        u1.pp.name = "x";
        u1.study();
        Stu u2 = new Stu("student",172, "计科");
        u2.study();
        System.out.println(u1.pp.name);
        System.out.println(u2.pp.height);
        //利用组合调用父类CPU和Memory的属性
        Computer pc = new Computer();
        pc.cpu.calculate();
        pc.memory.store();

    }
}
//Stu类利用组合达到和class student extends Person{} 相同的效果(is-a关系,用extends继承比较好)
class Stu{
    Person pp = new Person();   //组合,利用父类对象pe来使用父类Person中的name和height属性
    String major;
    public void study(){
        System.out.println(this.pp.name+"Stu.study");
    }

    //构造器
    public Stu(){}
    public Stu(String name, int height, String major){
        this.pp.name = name;
        this.pp.height = height;
        this.major = major;
    }

}

class CPU{
    void calculate(){
        System.out.println("CPU.calculate");
    }
}

class Memory{
    void store(){
        System.out.println("Memory.store");
    }
}
    //单用extends来描述Computer不够,这是"has-a"关系,用组合来描述类最方便确切
class Computer {
    CPU cpu = new CPU();
    Memory memory = new Memory();

}
