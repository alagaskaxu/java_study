package com.xzy.javase.file.demo;

import sun.tools.jar.SignatureFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * 拷贝文件
 * 1.创建空文件到目标目录
 * 2.复制原数据到目标文件
 */
public class demo07 {
    public static void main(String[] args) {
        File srcFile = new File("F:\\TestFile\\3.txt");
        File destFile = new File("F:\\TestFile\\test00");
        copyFile(srcFile,destFile);
    }

    /**
     * 复制文件到对应的目录中
     * @param srcFilePath   源文件路径
     * @param destDirPath   目标目录
     */
    public static boolean copyFile(String srcFilePath,String destDirPath){
        //创建目标文件并返回目标文件路径对象
        File destFile = createFile(srcFilePath,destDirPath);
        String destFilePath = destFile.getPath();
        //复制源文件数据到目标文件,返回是否成功
        boolean success = copyFileData(srcFilePath,destFilePath);
        return success;
    }


    public static boolean copyFile(File srcFile, File destDir)
    {
        String srcFilePath = srcFile.getPath();
        String destDirPath = destDir.getPath();
        return copyFile(srcFilePath,destDirPath);
    }

    /**
     * 创建同名空文件
     * @param srcPath   源文件路径
     * @param destPath  目标路径
     * @return destFile 返回目标文件的抽象路径对象,避免同名文件的错误
     */
    public static File createFile(String srcPath,String destPath){
        File srcFile = new File(srcPath);
        File destDir = new File(destPath);
        //判断原文件是否是文件是否存在
        if (!srcFile.isFile())
        {
            throw new IllegalArgumentException(srcFile.getPath()+":源文件路径错误");
        }

        //判断目标目录是否存在且是否为目录
        if (destDir.exists()&&!destDir.isDirectory())
        {
            throw new IllegalArgumentException(destDir.getPath()+":目标目录路径错误,目标路径不是目录");
        }
        //目标目录不存在则创建目录
        if (!destDir.exists())
        {
            destDir.mkdirs();
            System.out.println(destDir.getPath()+"目标目录已生成");
        }

        String srcFileName = srcFile.getName();
        String destFileName = srcFileName;
        File destFile = new File(destDir,destFileName);
        //判断目标文件是否已经存在同名文化
        if (destFile.isFile())
        {
            //目标目录存在相同文件则创建副本
            //1.将文件后缀和文件名分开
            int index = srcFileName.lastIndexOf('.');
            String FileName = srcFileName.substring(0,index);
            String extName = srcFileName.substring(index);
            //2.目标文件名加上UUID区别同名文件,文件后缀不变
            destFileName = FileName+"_"+ UUID.randomUUID()+extName;
            destFile = new File(destDir,destFileName);
        }
        //创建空的文件
        try {
            destFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destFile;
    }

    /**
     * 创建空文件方法的重载方法
     * @param srcFile 源文件对象
     * @param destDir 目标路径对象
     * @return destFile  目标文件对象
     */
    public static File createFile(File srcFile,File destDir) {
        String srcPath = srcFile.getPath();
        String destPath = destDir.getPath();
        File destFile = createFile(srcPath,destPath);
        return destFile;
    }

    /**
     * 复制源文件数据
     * @param srcFilePath
     * @param destFilePath
     */
        public static boolean copyFileData(String srcFilePath,String destFilePath)
    {
        boolean success = false;    //是否成功的标志位
        File srcFile = new File(srcFilePath);
        File destFile = new File(destFilePath);
        //IO流引用创建在外,方便出现异常时调用,关闭IO流
        FileInputStream inPut = null;
        FileOutputStream outPut = null;
        try{
            //复制源文件数据
            inPut = new FileInputStream(srcFile);
            outPut = new FileOutputStream(destFile);
            //读取源文件数据,再写入目标文件
            while(true)
            {
                byte[] bs = new byte[1024];
                //1.读取源文件
                int count = inPut.read(bs);
                if (-1 == count)
                {
                    //-1 表示bs元素为空,数据读取完
                    break;  //跳出读取循环
                }
                //2.写入目标文件
                outPut.write(bs,0,count);   //(off:0,count)去除最后溢出byte数组中默认的 元素 0 ,避免乱码复制出错
            }
            success = true; //复制成功标志位
        }catch (Exception e){
            e.printStackTrace();
        }

        //关闭IO流
        //inPut引用不为null表示IO流被创建打开了,最后需要关闭IO流
        if (inPut != null)
        {
            try {
                inPut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (outPut != null)
        {
            try {
                outPut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return success; //返回是否成功标志位,true表示复制文件成功,反之失败
    }

    /**
     * 重载复制文件数据方法
     * @param srcFile   源文件对象
     * @param destFile  目标文件对象
     * @return
     */
    public static boolean copyFileData(File srcFile,File destFile)
    {
        String srcFilePath = srcFile.getPath();
        String destFilePath = destFile.getPath();
        return copyFileData(srcFilePath,destFilePath);
    }
}
