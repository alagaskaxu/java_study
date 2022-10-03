package com.javastudy.innerClass;

/**
 * 测试匿名内部类
 *
 * 匿名内部类:
 * 适合只需要使用一次的类.如:键盘监听操作等.
 * 在安卓开发awt swing GUI里开发中常见
 *
 */
public class testAnonymousInner {
    //传入参数为实现A类接口的对象
    public void test(A a){
        System.out.println("--将运行A类的run方法--");
        a.run();
    }

    public static void main(String[] args) {
        testAnonymousInner tAm = new testAnonymousInner();
        //方法一
        testA ta = new testA();
        tAm.test(ta);  //传入A接口实现类的对象
        System.out.println();
        //方法二
        tAm.test(new testA());  //直接创建对象传入,不设置变量名,匿名传入
        System.out.println();
        //方法三:创建匿名内部类:直接在传参入口 编写一个没类名的内部类(匿名内部类),
        // 重写对应方法,再创建匿名对象,即创建匿名内部类对象,
        // 方法是一次性的,只用一次
        tAm.test(new A() {  //匿名内部类,没有类名,只知道是实现A接口方法的类
            @Override
            public void run() {
                System.out.println("匿名内部类的run方法,只使用一次");
            }
        });

        //匿名内部类实现的方法只使用一次,每次都要重写
        System.out.println();
        tAm.test(new A() {
            @Override
            public void run() {
                System.out.println("新的匿名内部类run方法");
            }
        });

    }

}
//  不用匿名内部类,则按一般方法创建接口的具体实现类,实例化对象,传入test()里
class testA implements A{
    @Override
    public void run() {
        System.out.println("testA具体实现run方法");
    }
}

//A接口
interface A{
    void run();
}
