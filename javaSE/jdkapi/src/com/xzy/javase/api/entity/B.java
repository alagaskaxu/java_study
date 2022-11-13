package com.xzy.javase.api.entity;

public class B extends A{
    //重载
    public long getNumber(Integer a) {
        return a + 2;
    }
    public static void main(String[] args) {
        B bb = new B();
        Integer aa = 0;
        System.out.println(bb.getNumber(0));

        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operator(a, b);
        System.out.println(a + "," + b);
    }

    public static void operator(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
    }
}
