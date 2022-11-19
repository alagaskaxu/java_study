package com.xzy.java.net.demo;

import java.io.*;
import java.net.*;

/**
 * URL
 */
public class URLDemo {
    public static void main(String[] args) {
        //test01();
        //test02();
        test03();
    }

    public static void test01(){
        try {
            URL url = new URL("https://www.bilibili.com/account/history?spm_id_from=333.337.0.0");
            System.out.println("协议:"+url.getProtocol());
            System.out.println("主机名或IP:"+url.getHost());
            System.out.println("服务端口号:"+url.getPort());
            System.out.println("资源路径"+url.getFile());
            System.out.println("参数:"+url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public static void test02(){
        InputStream in = null;
        BufferedReader reader = null;
        try {
            URL url = new URL("https://www.baidu.com");
            //建立URL链接
            URLConnection conn = url.openConnection();
            //得到URL返回的数据,读取百度服务器响应的数据
            in = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));
            while(true){
                String line = reader.readLine();
                if (line == null){
                    break;
                }
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (reader!=null){
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * URL编码与解码
     */
    public static void test03(){
        String url="https://localhost:8080/hello?name=小明";
        try {
            //对URL进行utf-8编码
            String res = URLEncoder.encode(url,"UTF-8");
            System.out.println(res);

            //解码
            String target = URLDecoder.decode(res,"UTF-8");
            System.out.println(target);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
