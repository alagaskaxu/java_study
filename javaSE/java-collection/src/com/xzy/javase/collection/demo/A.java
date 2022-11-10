package com.xzy.javase.collection.demo;

/**
 * 自定义泛型
 * 泛型:用字母泛指一切引用类型
 * 使用时可以自己选定特定的引用类型,对象类型
 * 利用泛型可以减少多个类型的相同方法的重载
 * 用 <> 表示泛型<>里填写字母,如:<T>,用 T来泛指类型,具体类型调用时再`指定
 */
public class A<T> {
    /**
     * print方法 功能:打印泛型 T 类型的对象,T指代所有的引用类型
     * @param t  T类型的变量t
     * @return t  T类型的变量t,根据调用时具体规定的类型返回,可以将需要类型对应,免于强制转换
     */
    public T print(T t){
        System.out.println(t.toString());
        return t;
    }

    /**
     * printf()方法 功能: 普通的打印方法,只能打印Object类,或者用强制转换成对应的引用类型从而实现和泛型一样的功能;
     * 想打印别的类型还需要重载该函数,修改不同类型,或者在调用时将返回的Object类型强制转换为对应的引用类,相比泛型更为复杂
     * @param ob
     * @return  ob 返回值类型为Object类 其它引用类需要强制转换
     */
    public Object printf(Object ob){
        System.out.println(ob.toString());
        return ob;
    }

    public static void main(String[] args) {
        A a = new A();  //不使用泛型,默认使用Object类型和printf()一样需要强制转换
        String str = (String) a.print("Object类型 t ");  //不用泛型,默认是Object类,需要强制转换为对应的String类型
        Integer integer = (Integer) a.print(123);  //不用泛型,默认是Object类,需要强制转换为对应的Integer类型
        System.out.println(str+integer);
        a.printf("不用泛型的print()方法和普通的printf(Object ob)方法一样");

        //使用泛型,则<T>中的T就代表了<Integer>中的Integer,A类型中所有的T都会表示为Integer
        A<Integer> a1 = new A<>();  //使用泛型
        Integer i = a1.print(123);  //使用了<Integer>则不需要强制转换了,返回值直接是Integer类型
        System.out.println(i);
        //String s = a1.print("T t");
        //A类型中的print(T t) 变为 public Integer print(Integer t)方法
        //其它的引用类型也就不能传入了,返回值也是返回Integer类型
    }
}
