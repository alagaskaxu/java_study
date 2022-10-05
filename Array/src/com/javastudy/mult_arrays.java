package com.javastudy;

import java.util.Arrays;

/**
 * 二维数组:可以看成以数组为元素的数组
 */
public class mult_arrays {
    public static void main(String[] args) {
        //二维数组的定义
         int[][] a =new int[3][];   //3行的二维数组
         a[0] = new int[2];
         a[1] = new int[3];
         //单独赋值
         a[0][0] = 10;
         a[0][1] = 20;
         a[1][2] = 123;
        System.out.println("a[1][2]="+a[1][2]);
         //一整组的静态初始化
        a[1] = new int[]{10,20,33,440};
        a[2] = new int[]{10,20,30};
        System.out.println("a[1][2]= "+a[1][2]);
        //二维数组静态初始化
        int[][] b = {
                {10,20,30},
                {10,20},
                {100,220,333,444}
        };

        //遍历二维数组
        for (int i = 0; i<b.length; i++){   //b.length = 3,行
            for (int j=0; j<b[i].length; j++){  //b[i].length对应行的列数
                System.out.print(b[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("--------");
        //利用Arrays.toString工具,本质上一样
        for (int i=0; i<b.length; i++){
            System.out.println(Arrays.toString(b[i]));
        }

    }
}
