package com.javastudy.innerClass;
import com.javastudy.innerClass.Outer2.Inner2;

//测试调用静态内部类
public class testStaticInner {
    public static void main(String[] args) {
        //调用静态内部类,静态类不需要实例化,可以直接调用
        //通过new 外部类名.内部类名() 来创建静态内部类的对象
        Outer2.Inner2 inner2 = new Outer2.Inner2();
        inner2.test();

        //或者利用import导入静态内部类,可以省去外部类名的书写; Outer2. 可以省去,但是本质一样
        Inner2 inner22 = new Inner2();
        inner22.test();
    }

}
