package com.xzy.javase.file.test;

import com.xzy.javase.file.entity.Student;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 序列化
 * 将 对象 序列化成字节流 输出到文件中 进行保存
 */
public class TestObjectOutputStream {
    public static void main(String[] args) {
        test01();
    }
    public static void test01(){
        ObjectOutputStream out =null;
        FileOutputStream fileOut = null;    //输出到对应文件
        try {
            //student.data
            fileOut = new FileOutputStream("F:\\TestFile\\student.data");
            out = new ObjectOutputStream(fileOut);  //可以传入 outputStream 抽象类的所有子类的对象
            Student stu = new Student("tom","22",1,20);
            //序列化
            out.writeObject(stu);
            //序列化后 stu这个对象数据可以永久保存在student.data文件里;.data文件是专门存放序列化对象数据的文件
            //可以不用data存放,可以用txt等存放,序列化本质输出的都是二进制的字节流
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        if (out!=null)
        {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
