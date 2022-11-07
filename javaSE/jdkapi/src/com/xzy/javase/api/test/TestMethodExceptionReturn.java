package com.xzy.javase.api.test;

/**
 *  测试 有返回值的方法 出现异常时的返回值状态
 */
public class TestMethodExceptionReturn {

    public static void main(String[] args) {
        int x = m1();   //返回值为 0;如果finally中没有return 则返回 -10
        System.out.println("x= "+x);
    }

    public static int m1(){
        try {
            int i= 3/0;
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -10; //return 理论上返回 -10 后方法已经结束了
        }finally {
            System.out.println("finally");  //虽然return返回了,但是finally语句仍继续运行
            return 0;   //return 0 ,最后方法的返回值为 0
            //存在return 返回值的栈 , -10 和 0都存入栈中,先进后出;最后返回的第一个值为0
        }

    }
}
