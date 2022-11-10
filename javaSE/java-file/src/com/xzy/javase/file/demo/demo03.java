package com.xzy.javase.file.demo;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 目录的复制
 * 1.需要复制的目录
 * 2.复制到哪去
 */
public class demo03 {
    public static void main(String[] args) {
        File src = new File("F:\\TestFile\\a");
        File dest = new File("F:\\TestFile\\copyA");
        copyDir(src,dest);
    }

    /**
     * 目录的复制
     * @param src   源目录的路径
     * @param dest  目的路径
     */
    public static void copyDir(File src,File dest){
        if (!src.isDirectory()){
            throw new IllegalArgumentException(src.getPath()+"不是一个有效的目录");
        }
        if (!dest.isDirectory()&&dest.exists()){
            throw new IllegalArgumentException(dest.getPath()+"目的路径不是一个有效的目录");
        }
        //判断源目录与目标目录为同一个目录
        if(src.equals(dest))
        {
            throw new IllegalArgumentException("源目录与目标目录不可以是同一个目录");
        }

        //在目标路径创建与源目录同名的目录
        String srcDirName = src.getName();  //源目录名
        String destDirName = srcDirName;    //拷贝后的目录名
        File destDir = new File(dest,destDirName);
        //判断目标目录是否已经存在要拷贝的文件夹
        if (destDir.isDirectory())
        {
            destDirName = srcDirName+'_'+ UUID.randomUUID().toString();
            destDir = new File(dest,destDirName);
        }
        //创建目录
        destDir.mkdirs();
        //获取源目录中的子目录及文件
        File[] subFiles = src.listFiles();
        if (null == subFiles)
        {
            return;
        }
        for (File subFile:subFiles){
            if (subFile.isFile()){
                //目标目录中创建新的文件
                String fileName = subFile.getName();
                File newFile = new File(destDir,fileName);
                try {
                    newFile.createNewFile();    //创建新文件
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if (subFile.isDirectory())
            {
                copyDir(subFile,destDir);
            }else{
                throw new IllegalArgumentException("即不是目录也不是文件");
            }
        }

    }

    //重载
    public static void copyDir(String srcPath,String destPath) {
        File srcDir = new File(srcPath);
        File destDir = new File(destPath);
        copyDir(srcDir,destDir);
    }

}
