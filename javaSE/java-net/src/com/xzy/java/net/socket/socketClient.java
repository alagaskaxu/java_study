package com.xzy.java.net.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Scanner;

/**
 * socket客户端
 */
public class socketClient {
    public static void main(String[] args) {
        while(true) {   //一直向服务端输出
            Socket socket = null;
            PrintWriter out = null;
            Scanner scanner = null;
            try {
                socket = new Socket("127.0.0.1", 5566);
                //利用socket向服务器发送信息
                OutputStream output = socket.getOutputStream();
                out = new PrintWriter(output);
                System.out.println("请输入一句话");
                scanner = new Scanner(System.in);
                String line = scanner.nextLine();
                line = URLEncoder.encode(line,"UTF-8");
                out.print(line);
                out.flush();
                //socket.shutdownOutput();    //关闭此套接字的输出流,表示客户端socket输出完成
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (out!=null) {
                out.close();
            }
            System.out.println("是否继续聊天?Y/N");
            char ch = scanner.nextLine().charAt(0);
            if ('n' == ch||'N' == ch)
            {
                break;
            }
        }
    }
}
