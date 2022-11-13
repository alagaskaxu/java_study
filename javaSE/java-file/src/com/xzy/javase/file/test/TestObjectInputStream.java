package com.xzy.javase.file.test;

import com.xzy.javase.file.entity.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

/**
 * 反序列化
 * 将序列化的对象文件 反序列化 转换成 对象实例,得到文件内对象的数据
 */
public class TestObjectInputStream {
    public static void main(String[] args) {
        test01();
    }
    public static void test01(){
        ObjectInputStream in = null;
        FileInputStream fileIn = null;
        try{
            fileIn = new FileInputStream("F:\\TestFile\\student.data");
            in = new ObjectInputStream(fileIn);
            //反序列化,不需要创建对象类
            //反序列化 得到一个学生对象
            Student stu =  (Student) in.readObject();   //readObject()返回 Object类,需要强制转换成对应 对象类
            System.out.println(stu);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        if (in != null)
        {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
