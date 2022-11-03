package com.xzy.javase.api.test;

import java.util.Random;

/**
 * 测试Random类
 * 功能:生成伪随机数，区间内部的数字生成的几率时均等的
 * 构造方法:
 * Random( )
 * 该构造方法使用一个和当前系统时间对应的相对时间有关的数字作为种子数，然后使用这个种子数构造Random对象
 * Random（long seed)
 * 制定一个种子数进行创建
 *
 */
public class TestRandom
{
    public static void main(String[] args) {
        Random rd = new Random();
        //0-99的随机整数[0,99]
        int a = rd.nextInt(100);    //nextInt(100)产生的随机整数范围为[0,100)即[0,100-1]即[0,99]
        System.out.println("[0,100]的随机数"+a);

        //50-100的随机整数
        int d = rd.nextInt(51);
        d+=50;
        System.out.println("[50,100]的随机数"+d);

        //[50,100],[150,200],[350,400],[450,500]区间里的随机数
        System.out.println("几个区间内的随机数:"+getRandomData());

    }

    /**
     * 获取[50,100],[150,200],[350,400],[450,500]区间里的随机数
     * @return d 随机结果
     */
    public static int getRandomData(){
        Random rd = new Random();
        //获取随机区间
        int area = rd.nextInt(4)+1; //[1,4]
        int d = rd.nextInt(51);
        switch (area)
        {
            case 1:
                d +=50;
                break;
            case 2:
                d +=150;
                break;
            case 3:
                d +=350;
                break;
            case 4:
                d +=450;
                break;
            default:
                d = 0;
        }
        return d;
    }

}
