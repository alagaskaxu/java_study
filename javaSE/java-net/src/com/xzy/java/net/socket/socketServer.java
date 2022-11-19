package com.xzy.java.net.socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * 套接字socket
 */
public class socketServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        PrintWriter out = null;
        Scanner scanner = null;
        try {
            //服务器端需要创建监听特定端口的ServerSocket,ServerSocket负责接收客户连接请求
            serverSocket = new ServerSocket(5566);
            System.out.println("Socket服务端已启动");
            while (true) {
                //一直保持监听客户端的socket,直到监听到一个socket就结束,保持永远监听就加死循环
                Socket socket = serverSocket.accept();  //一直保持监听客户端的socket,直到监听到一个socket就结束
                System.out.println("已接受到客户端请求:" + socket.getRemoteSocketAddress());
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                while (true) {
                    //等待客户端输出
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    line = URLDecoder.decode(line, "UTF-8");
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
