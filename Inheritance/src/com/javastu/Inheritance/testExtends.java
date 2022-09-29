package com.javastu.Inheritance;

/*
* 测试继承的基本用法
* calss 子类 extends 父类
* 继承的使用要点:
* 1.java中只有单继承(extends后就一个直接父类),没有像c++的多继承
* 2.java中类没有多继承,接口有多继承
* 3.子类继承父类,可以得到父类的全部属性和方法(除了父类的构造方法),
* 但不一定都可以直接访问(如:父类私有的属性和方法)
* 4.如果定义一个类时,没有调用extends,则它的父类是Java.lang.Object
 */
public class testExtends {
    public static void main(String[] args) {
        student stu1 = new student("xu", 172, "计算机科学与技术");
        stu1.rest();    //子类继承了父类的方法和属性
        stu1.study();
        System.out.println(stu1.name);

        //instanceof关键字:判断是否属于此类的实例(对象)
        System.out.println(stu1 instanceof student);    //true
        System.out.println(stu1 instanceof Person);    //true
    }

}
//一个源文件可以定义多个类
class Person {
    String name;
    int height;

    public void rest(){
        System.out.println("休息一会");
    }

}
//继承Person类
class student extends Person{
    //String name;
   //int height; //student继承了person类之后,与person的相同属性直接继承下来,不需再写一遍
    String major;   //课程,专业
    //public void rest(){ } //继承了person类所有
    public void study(){
        System.out.println("student学习中");

    }
    //构造器
    public student(String name,int height,String major){
        System.out.println(this);
        this.name = name;   //student.name,student.person.name;this指向student,name在person里
        this.height = height;
        this.major = major;
    }

}
