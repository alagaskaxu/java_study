package com.xzy.javase.api.test;

public class TestCharacter {
    public static void main(String[] args) {
        Character ch = new Character('a');
        //判断是否是字母
        System.out.println(Character.isLetter('a'));    //true
        System.out.println(Character.isLetter('1'));    //false
        System.out.println(Character.isLetter(97)); //true 97对应的编码中为 a
        //判断是否是数字
        System.out.println("======");
        System.out.println("1是否是数字:"+Character.isDigit('1'));    //true
        //判断是否是大写字母
        System.out.println("a是否是大写字母:"+Character.isUpperCase('a'));    //false
        System.out.println(Character.isUpperCase('A'));    //true
        //将字符型转成字符串类型,得到String字符串类型
        String str = Character.toString('h');

    }
}
