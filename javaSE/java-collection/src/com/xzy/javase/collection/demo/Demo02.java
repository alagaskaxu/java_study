package com.xzy.javase.collection.demo;

import com.xzy.javase.collection.util.MD5;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 签名算法
 */
public class Demo02 {
    public static void main(String[] args) {
        String url = "https://www.java.com/sign.php&appid=wxd&mch_id=100100&device_info=202&body=test";
        String shopKey = "192006250b4c09247ec02edce69f6a2d";    //shopKey为商户平台的密钥key
        String signString = signStr(url);   //签名的 网页参数 字符串
        String stringApiSign = signString+"&key="+shopKey;  //最终拼接的API密钥字符串
        System.out.println("最终API密钥字符串:"+stringApiSign);
        //MD5加密API密钥
        String md5Sign = MD5.getMD5(stringApiSign);
        md5Sign = md5Sign.toUpperCase();//转大写
        System.out.println("MD5加密后的API密钥,32位签名:"+md5Sign);
    }

    /**
     * 生成密钥签名
     * @param url
     * @return
     */
    public static String signStr(String url)
    {
        String signStrValue = "";  //拼接的签名字符串
        TreeMap<String,String> signMap = new TreeMap<>();
        //切分子串
        String[] subStrs= url.split("&");
        System.out.println("切分的子串数组:"+Arrays.toString(subStrs));
        int count = subStrs.length;
        //signStrValue = subStrs[0];    //subStrs[0]是网页链接
        //拆分字符串,得到键值对
        for (int c = 1;c<count;c++)
        {
            String subStr = subStrs[c];
            int index = subStr.indexOf("=");
            String key = subStr.substring(0,index);
            String value = subStr.substring(index+1);
            signMap.put(key,value);
        }
        //遍历键值对,进行签名字符串拼接
        for (String key:signMap.keySet()) {
            String value = signMap.get(key);
            signStrValue = signStrValue+"&"+key+"="+value;
        }
        //去除第一个&
        signStrValue = signStrValue.substring(1);
        return signStrValue;
    }
}
