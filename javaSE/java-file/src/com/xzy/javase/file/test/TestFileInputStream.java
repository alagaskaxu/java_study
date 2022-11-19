package com.xzy.javase.file.test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FileInputStream 继承于 InputStream
 * 文件 字节输入流
 * 以Byte字节(8位二进制)为单位 读取文件中的二进制数据
 */
public class TestFileInputStream {
    public static void main(String[] args){
        test02();

        try {
            FileInputStream input = new FileInputStream("F:\\TestFile\\1.txt");
            byte[] bs = new byte[12];   //缓冲区总大小 12 字节
            //int read(byte[] b) 返回读入缓冲区的字节总数,如果因为已经到达文件末尾而没有更多的数据,则返回 -1
            int count = input.read(bs);   //[97,98,99,100,101,0,0,0,0,0,0,0]
            System.out.println(count);    //count = 5
            System.out.println(bs[0]);  //97
            System.out.println(bs[4]);  //101
            System.out.println(bs[5]);  //0
            System.out.println(bs[11]); //0
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试读取文件
     */
    public static void test01(){
        try {
            //根据文件路径创建文件输入字节输入流
            FileInputStream input = new FileInputStream("F:\\TestFile\\1.txt");
            //read() 从文件中读一个字节的数据(光标会后移),返回下一个数据字节,没有数据返回 -1
            int data = input.read();   //默认只读八位二进制, 一字节
            System.out.println(data);   //97 == a
            data = input.read();
            System.out.println(data);   //98 == b

            //利用byte[]数组和int read(byte[])方法读取多个字节,byte[]叫做缓冲区,read(byte[])返回int类型表示byte[]已存放元素的长度
            byte[] bs = new byte[512];  //512字节的缓冲区,用来存放读取到的8位二进制
            while (true){
                //int read(byte[] b) 返回读入缓冲区的字节总数,如果因为已经到达文件末尾而没有更多的数据,则返回 -1
                int count = input.read(bs); //read读到的8位带符号二进制数(转成byte)都会存放在bs数组里,返回字节元素个数(已经存放的元素长度)
                if (-1 == count)    //read 返回-1 表示文件读完数据
                {
                    break;
                }
                //利用读取到的字节数组构造字符串
                //String str = new String(bs);    //bs默认存放 0 ,读取完所有字节后还可能存在一堆 0 ,导致字符串bug
                String str = new String(bs,0,count);    //只选取bs数组里的一部分元素(从offset下标开始到bs数组存在的元素个数结束)
                //只构造规定数组区间的字符串(一般是文件实际读取到的字节流区间[ 0,read(byte) ) )
                System.out.println(str);

                //使用完后需要关闭文件IO流
                input.close();  //此处可能因为上面产生异常,导致此代码无法运行,IO流无法关闭
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 正规IO读 的写法,避免IO流因为异常无法关闭
     */
    public static void test02(){
        //IO流引用写在try-catch语句块外,方便关闭IO时调用,不然try内创建的IO流对象,在语句外无法被调用,出现异常也就无法关闭IO了
        FileInputStream input = null;
        try {
            input = new FileInputStream("F:\\TestFile\\1.txt");
            byte[] bs = new byte[512];  //512字节的缓冲区,用来存放读取到的8位二进制
            while (true) {
                int count = input.read(bs); //read读到的8位二进制数(转成byte)都会存放在bs数组里,返回字节元素个数(已经存放的元素长度)
                if (-1 == count)    //read 返回-1 表示文件读完数据
                {
                    break;
                }
                //利用读取到的字节数组构造字符串
                //String str = new String(bs);    //bs默认存放 0 ,读取完所有字节后还可能存在一堆 0 ,导致字符串bug
                String str = new String(bs, 0, count);    //只选取bs数组里的一部分元素(从offset下标开始到bs数组存在的元素个数结束)
                //只构造规定数组区间的字符串(一般是文件实际读取到的字节流区间[ 0,read(byte) ) )
                System.out.println(str);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //正规关闭IO流,try-catch捕获异常,catch{}后的代码会继续运行
        if (input != null)  //判断IO流是否成功创建,被创建则不为null,需要被关闭
        {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
