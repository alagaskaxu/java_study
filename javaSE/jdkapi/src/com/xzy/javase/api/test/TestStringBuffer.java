package com.xzy.javase.api.test;

/**
 *测试StringBuffer类
 * StringBuffer是个容器,是字符串缓冲区
 * 两个成员变量,第一个char数组主要是存储真正的字符串，
 * 第二个是记录已经使用的长度,因为char数组开辟的空间一般是大于实际字符需要的,
 * 如果char数组的空间不够用的时候,需要用到扩容机制
 *
 * 与StringBuilder的不同点:
 * StringBuffer是线程*同步*的,线程安全的.但效率低
 * StringBuilder是线程*异步*的,线程不安全的.但效率高
 * 其它功能与结果几乎是完全一样的
 */
public class TestStringBuffer {
    public static void main(String[] args) {
        StringBuffer strBuf = new StringBuffer();
        //向缓冲区添加 *字符*
        strBuf.append('c');
        strBuf.append(12);  //实际上向缓冲区末尾添加了字符'1'和'2'
        strBuf.append(true);//同上't','r'
        strBuf.append(3.14);
        strBuf.append("abc");//还是按字符向末尾添加'a','b','c'
        strBuf.appendCodePoint(97); //以编码值添加 97 => a
        //toString() 获取缓冲区所有的字符,返回一个String对象
        String str = strBuf.toString();
        System.out.println(str);

        //插入 insert()   下标从0开始
        StringBuffer strbuf1 = new StringBuffer("abcd");
        System.out.println(strbuf1);
        strbuf1.insert(1,"22");
        System.out.println(strbuf1);
        System.out.println("strbuf1的长度:"+strbuf1.length());

        //删除字符,范围为[ , ) 下标从0开始
        strbuf1.delete(3,5);    //[3,5)
        System.out.println("删去[3,5)的字符:"+strbuf1);

        //字符串序列反转 reverse()
        strbuf1.reverse();
        System.out.println("字符串序列反转:"+strbuf1);
    }
}
