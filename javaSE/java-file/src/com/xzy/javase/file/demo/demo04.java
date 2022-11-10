package com.xzy.javase.file.demo;

import java.io.File;

/**
 * 目录(文件)的移动
 * 先复制源目录文件夹然后删除源文件夹
 */
public class demo04 {
    public static void main(String[] args) {
        moveDir("F:\\TestFile\\copyA\\a","F:\\TestFile\\moveA");
    }

    /**
     * 把源目录移动到目标目录中去
     *
     * @param src  源目录
     * @param dest 目标目录
     */
    public static void moveDir(File src, File dest) {
        //1.先复制源目录
        demo03.copyDir(src, dest);
        //2.删除源目录
        demo01.deleteDirs(src);

    }

    //重载
    public static void moveDir(String srcPath, String destPath) {
        demo03.copyDir(srcPath, destPath);
        demo01.deleteDirs(srcPath);
    }
}
