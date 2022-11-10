package com.xzy.javase.file.test;

import java.io.File;
import java.io.IOException;

/**
 * File类
 * 用于对计算机文件的操作
 * 创建文件,删除文件,文件重命名,文件复制等方法
 */
public class TestFile {
    public static void main(String[] args) {
        //创建对应文件的引用对象
        test01();
        //File类的常用方法
        test02();
        //目录的常用方法
        test03();
    }

    /**
     * 新建文件对象,新建目录对象
     * 只是创建了与指定路径的文件对应的引用对象
     * 不会在实际电脑中生成文件
     * 利用引用对象调用方法才能控制实际文件
     */
    public static void test01(){
        //方法一:新建文件对象
        File txto1 = new File("F:\\TestFile\\1.txt");
        //方法二:先新建目录对象,在目录里创建文件对象
        File TestFile = new File("F:\\TestFile");
        File txt02 = new File(TestFile,"2.txt");    //根据所在目录对象所在的位置创建文件对象
        //方法三: 根据文件父目录路径 和 文件名 新建文件对象
        File txt03 = new File("F:\\TestFile","3.txt");
        //根据所在父目录的对象或路径和当前目录的名称创建子目录对象
        File test01 = new File(TestFile,"test01");
        File test02 = new File("F:\\TestFile","test02");
    }

    /**
     * 文件的常用方法
     */
    public static void test02(){
        File txt01 = new File("F:\\TestFile\\1.txt");   //电脑上存在的文本文件
        File txt02 = new File("F:\\TestFile\\2.txt");   //电脑上不存在的文本文件
        File test01 = new File("F:\\TestFile\\test01"); //存在的 文件夹目录
        //exists() 查看文件是否存在
        System.out.println("1.txt是否存在:"+txt01.exists());    //true
        //isFile() 查看对象是否是文件
        System.out.println("1.txt是否为文件:"+txt01.isFile());   //true
        System.out.println("test01是否为文件:"+test01.isFile()); //false;test01是文件夹,是目录,不是文件
        System.out.println(txt01.getPath());    //得到路径
        //在文件目录中 新建文件 2.txt
        if (!txt02.isFile())    //2.txt不是文件时新建文件(不是文件即文件不存在)
        {
            //createNewFile()  新建文件会抛出异常需要try-catch
            try {
                txt02.createNewFile();  //txt02路径错误(即父文件夹目录不存在)会产生异常,不会按照路径去创建对应的父文件夹目录
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //删除文件
        if (txt02.isFile()) //2.txt是文件则删除该文件 (是文件则文件存在可以删除)
        {
            txt02.delete(); //删除可能需要权限
        }

        //不写目录路径也能新建文件;默认会将文件新建到该项目的根目录中
        File txt = new File("1.txt");   //新建到项目的根目录: D:\javaproject\java_study\javaSE
        try {
            txt.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //默认路径会将文件新建到该项目的根目录中
        File jftxt = new File("java-file\\1.txt");   //新建到项目的根目录中的java-file文件夹中: D:\javaproject\java_study\javaSE\java-file
        try {
            jftxt.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 目录常见操作
     */
    public static void test03(){
        File test = new File("F:\\TestFile\\test");
        //判断目录是否存在
        System.out.println("目录是否存在:"+test.exists());
        System.out.println("是否是目录:"+test.isDirectory());
        //创建目录
        if (!(test.isDirectory())){
            test.mkdir();   //mkdir() 创建目录,其路径(父目录)一定要存在且正确
        }
        File test1 = new File("F:\\TestFile\\a\\test1");
        if (!(test1.isDirectory())){
            test1.mkdirs();   //mkdirs() 创建目录时,父目录不存在时会按照路径创建所有父文件夹
        }
        //得到文件或目录的路径
        System.out.println(test.getPath()); //得到路径
        System.out.println(test.getName()); //文件目录名
        System.out.println(test.getParent());   //父路径
        System.out.println(test.getParentFile());   //得到父类的File对象

        //删除目录
        if (test.isDirectory())
        {
            boolean success = test.delete();    //当文件夹里有文件时无法删除
            System.out.println(success);
        }

        System.out.println("====");
        //获取目录的子目录,子文件的File数组,存放抽象路径名的File对象
        File[] subDirs = test.listFiles();
        for (File dir:subDirs) {
            System.out.println(dir.getPath());
        }

        //list() 返回String数组,存放子目录和子文件名
        System.out.println("==子目录和文件名==");
        String[] strDirs = test.list();
        for (String dir:strDirs) {
            System.out.println(dir);
        }
    }

}
