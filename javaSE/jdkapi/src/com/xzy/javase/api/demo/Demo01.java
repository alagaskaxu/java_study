package com.xzy.javase.api.demo;

import java.util.Random;

/**
 * 获取6位随机验证码
 * 验证码由大小写字母,数字组成
 */
public class Demo01 {
    public static void main(String[] args) {
        String code = getCode();
        System.out.println("6位验证码: "+code);
        System.out.println("======");
        code = getCode(8);
        System.out.println("自定义位数8位验证码: "+code);
    }

    /**
     *获取6位随机验证码
     *验证码由大小写字母,数字组成
     * @return code验证码
     */
    public static String getCode(){
        final Integer codenum = 6;    //验证码字数,可转为形参控制验证码长度
        Integer index = 0;  //下标索引
        String code = "";   //验证码code
        StringBuffer number = new StringBuffer();   //随机字母池number
        //生成小写的26个字母
        for (int i=0;i<26;i++)
        {
            number.appendCodePoint(97+i);
        }
        //添加大写字母
        number.append(number.toString().toUpperCase());
        //添加数字
        for (char c = '0';c<='9';c++)
        {
            number.append(c);
        }
        System.out.println("验证码字符库: "+number);
        Random rd = new Random();
        for (int j = 0;j<codenum;j++)
        {
            index = rd.nextInt(62)+1;   //[1,62]
            code+=number.charAt(index);
        }
        return code;
    }

    //方法二
    /**
     * 输出*指定位数*的*不重复*的验证码
     * @param codenum 验证码位数
     * @return code 验证码
     */
    public static String getCode(int codenum) {
        String code = "";
        /**
         * ACSII编码值
         * 数字: 48-57
         * 大写字母: 65-90
         * 小写字母: 97-122
         */
        Random rd = new Random();
        for (int i=0;i<codenum;) {
            int n = rd.nextInt(3) + 1;    //[1,3]
            int cp; //随机编码值
            if (1 == n) {
                cp = rd.nextInt(10) + 48;   //随机数字
            } else if (2 == n) {
                cp = rd.nextInt(26) + 65;   //随机大写字母
            } else if (3 == n) {
                cp = rd.nextInt(26) + 97;   //随机小写字母
            } else {
                throw new RuntimeException("随机数错误");
            }
            char ch = (char)cp;
            if (-1 == code.indexOf(ch))     //判断是否有重复字符,避免重复字符
            {
                code += ch;
                i++;
            }
        }
        return code;
    }

}
