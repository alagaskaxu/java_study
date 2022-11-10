package com.xzy.javase.file.demo;

import java.io.File;

/**
 * 文件的查找
 */
public class demo02 {
    public static void main(String[] args) {
        searchTxt("F:\\TestFile\\test");
    }

    /**
     * 查找指定目录中的所有文本文件并打印
     * @param dirPath
     */
    public static void searchTxt(String dirPath){
        File path = new File(dirPath);
        if (path.isFile())
        {
            String fileName = path.getName();
            fileName.toLowerCase(); //转小写
            if (fileName.endsWith(".txt"))  //endsWith(),字符串是否以指定的后缀结束
            {
                System.out.println(path.getPath());
                return;
            }
        }
        if (!path.isDirectory())
        {
            throw new IllegalArgumentException(path.getPath()+",即不是文件也不是目录");
        }

        File[] childPath = path.listFiles();
        if (childPath == null)
        {
            System.out.println(path.getPath()+",没权限查看此目录");
            return;
        }
        for (File dir:childPath) {
            String cPath = dir.getPath();
            searchTxt(cPath);
        }
    }
}
