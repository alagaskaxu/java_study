package com.xzy.javase.file.test;

import java.io.UnsupportedEncodingException;

/**
 * 测试字符编码的原理
 * ASCii编码的字符最高位是0. 如:a = 97 01100001
 * 中文的编码由两个字节的有符号二进制来表示,如:GB2312,与ASCii编码表示区别 其最高位都是1,表示为负
 * '看' 由两个字符 -65 + -76, 11000001 + 11001100 ==> 30475 (无符号十进制)
 *
 * utf-8 编码为可变编码(1~4 字节):
 * 1.一个US-ASCIl字符只需1字节编码
 * 2.带有变音符号的拉丁文、希腊文、叙利亚文等字母则需要2字节编码
 * 3.其他语言包括中日韩文字,东南亚文字,中东文字等包含了大部分常用字,使用3字节编码
 * 4.其他极少使用的语言字符使用4字节编码
 */
public class Test01 {
    public static void main(String[] args) {
        byte[] bs = new byte[]{97,98,-65,-76,-78,-58};
        String str = null;
        try {
            str = new String(bs,"GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(str);
        System.out.println((long)'看');
    }
}
