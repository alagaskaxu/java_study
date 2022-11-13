package com.xzy.javase.file.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;

/**
 * 拷贝图片
 */
public class demo06 {
    public static void main(String[] args) {
        copyImageFile("F:\\TestFile\\idea.jpeg","F:\\TestFile\\img");
    }

    /**
     * 将图片拷贝到目标目录中去
     * @param imgFilePath   需要拷贝的图片路径
     * @param destPath  目标目录的路径
     * @return
     */
    public static boolean copyImageFile(String imgFilePath,String destPath){
        File imgFile = new File(imgFilePath);
        if (!imgFile.isFile())
        {
            throw new IllegalArgumentException(imgFilePath+"文件路径不存在");
        }
        //判断是不是一个图像文件
        String imgFileName = imgFile.getName().toLowerCase();   //得到小写文件名
        //判断文件后缀
        if (!imgFileName.matches(".+[.](jpg)|(jpeg)|(gif)|(png)|(bmp)$"))
        {
            System.out.println(imgFileName);
            throw new IllegalArgumentException(imgFilePath+"不是图像文件");
        }
        File destDir = new File(destPath);  //目标目录对象
        if (!destDir.isDirectory())
        {
            throw new IllegalArgumentException(destPath+"目标目录不存在");
        }
        //1.备份图像文件
        String newImgName = imgFileName;
        File newImg = new File(destDir,newImgName);
        //判断目标目录是否已经存在相同图像文件名
        if (newImg.isFile())
        {
            //如果目标目录中以存在该文件,则重新创建新的图像文件
            //得到图像文件名及扩展名 如:"1.jpg" => "1" 和 ".jpg"
            int index = newImgName.lastIndexOf('.');
            String fileName = newImgName.substring(0,index);    //subString根据下标区间获得 子字符串
            String extName = newImgName.substring(index);   //获得扩展名
            //重新构造 图片文件的名称
            newImgName = fileName+'_'+ UUID.randomUUID()+extName;
            newImg = new File(destDir,newImgName);
        }
        //IO流
        FileOutputStream output = null;
        FileInputStream input = null;
        boolean success = false;    //操作状态标志位
        try{
            //创建备份图像文件
            newImg.createNewFile();
            //先读原字节流再输出
            input = new FileInputStream(imgFile);
            output = new FileOutputStream(newImg);
            while(true){
                byte[] bs = new byte[1024];
                //从源图像文件读取数据
                int count = input.read(bs);
                if (-1 == count)    //返回 -1 表示文件全读取完
                {
                    break;
                }
                //将读取到的数据写入到新的图像文件中
                output.write(bs,0,count);   //写入读取到的字节流,限定区间,count为实际读取到的字节流长度,避免数组默认值0被写入
            }
            success = true; //文件拷贝完成
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        //IO流关闭
        if (input != null)
        {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (output!=null)
        {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return success;
    }
}
