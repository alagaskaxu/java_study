package com.xzy.javase.file.demo;

import java.io.File;

/**
 * 文件的删除
 */
public class demo01 {
    public static void main(String[] args) {
        File test = new File("F:\\TestFile\\test");
        deleteDirs(test.getPath());
    }

    //删除目录包括里面的文件和子目录
    public static void deleteDirs(String dirPath) {
        File dir = new File(dirPath);
        if (dir.isFile()) {
            dir.delete();   //文件直接删除
            return;
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("即不是文件也不是目录");
        }
        //获取目录中所有子目录或文件的对象
        File[] subDirs = dir.listFiles();   //listFiles() 返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件
        if (subDirs == null) {
            System.out.println(dir.getPath() + ",没权限查看此目录");
            return; //没权限获取子目录的数组时,会返回null数组,数组引用指向null会造成空指针异常
        }

        //如果数组为空,长度为0,foreach循环不会执行,直接for后的代码删除当前文件夹
        for (File subDir : subDirs) {
            //代码优化,和下面代码效果一样
            String path = subDir.getPath();
            deleteDirs(path);   //递归删除目录和文件
           /*

            if (subDir.isFile())
            {
                subDir.delete();    //文件直接删除
            }else if (subDir.isDirectory())
            {
                deleteDirs(subDir.getPath());   //递归删除子目录
            }else {
                throw new IllegalArgumentException(subDir.getPath()+"即不是文件也不是目录");
            }

            */
        }
        //没有子目录和子文件则删除当前目录
        dir.delete();
    }

    //重载
    public static void deleteDirs(File dirPath) {
        deleteDirs(dirPath.getPath());
    }
}
