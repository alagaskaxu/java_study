package com.xzy.javase.array.test;

/**
 * 二维数组
 */
public class TestArray02 {
    public static void main(String[] args) {
        //二维数组的定义,必须定义其一维的长度,即int[][] 前一个的[] 必须定义长度
        int[][] i = new int[][]{};  //{}里填一维数组{{1,2},{2,3},{3,4,5}}
        i=new int[10][];    //一维数组长度必须有,即第一个[]必须有值
        i[0] = new int[10]; //二维数组的长度可以都不相同,可以自己设定
        i[1] = new int[2];
        /*
        等价于
         int[10] -->     int[0][10]
                 -->     int[1][2]
                 -->     int[3][]
                 ....
                 -->     int[10][]
         */
        i=new int[10][9];   //二维的数组长度可以定死
        //一维数组长度必须有,二维的数组
        System.out.println(i.length);   //10 二维的length表示里面有几组的一维数组,即第一个一维数组的长度
        //语法错误,先确定第1维的长度
        //i=new int[][9];
        //多维数组
        int[][][] m = new int[2][][];
        i = new int[][]{{1,2,3},{3,4},{5,6}};
        System.out.println(i.length);   //二维的length表示里面有几组的一维数组
        System.out.println("i[0][0]="+i[0][0]+",i[0][2]="+i[0][2]); //i[0][]对应的一维数组的长度为3
        System.out.println("i[1][0]="+i[1][0]+",i[1][1]="+i[1][1]);//i[1][]对应的一维数组的长度为2,i[1][2]会下标越界
    }
}
