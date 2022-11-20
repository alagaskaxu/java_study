package com.xzy.java.net.demo;

import java.io.*;
import java.net.Socket;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = null;
        //一直向服务端输出
        while(true) {
            System.out.print("是否连接到服务器并向服务器发送数据(Y/N): ");
            scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            if (line.isEmpty())
            {
                break;
            }
            char ch = line.charAt(0);
            if ('y' == ch || 'Y' == ch) {
                //连接服务端并持续输出并等待服务器返回数据
                linkServer("127.0.0.1", 5566);
            }else if ('n' == ch || 'N' == ch) {
                System.out.println("客户端关闭");
                break;
            }else{
                System.out.println("输入错误!");
            }
        }
    }

    /**
     * 连接服务器并发送数据
     * @param
     */
    public static void linkServer(String host,int port)
    {
        if (port<0||port>65535){
            System.out.println("端口输入错误,范围为[0,65535]");
            return;
        }
        boolean cGetFlag = true;   //客户端得到数据标志
        boolean cOutFlag = true;   //客户端输出数据标志
        Socket socket = null;
        while (cOutFlag) {
            try {
                //向服务器输出一条数据
                socket = new Socket(host, port);
                cOutFlag = outDataToServer(socket);
                //客户端输出结束
                if (!cOutFlag) {
                    //接收服务端数据
                    while (true) {
                        System.out.println("向服务器发送接收数据请求");
                        socket = new Socket(host, port);
                        System.out.println("服务器返回数据:");
                        cGetFlag = getDataFromServer(socket);
                        //接收服务端数据结束
                        if (!cGetFlag) {
                            System.out.println("服务器数据发送完毕");
                            break;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
    }

    /**
     * 向服务器发送一条数据
     * @param socket
     * @return flag y=>true;n=>false
     */
    public static boolean outDataToServer (Socket socket)
    {
        boolean flag = true;
        OutputStream output = null;
        PrintWriter out = null;
        Scanner scanner = null;
        if (socket == null){
            throw new IllegalArgumentException("socket接收失败");
        }
        try {
            //利用socket向服务器发送一条信息
            output = socket.getOutputStream();
            out = new PrintWriter(output);
            System.out.println("向服务器发送一条数据:");
            scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            line = URLEncoder.encode(line, "UTF-8");
            out.println(line+"\r\n");
            out.flush();
            //socket.shutdownOutput();   表示客户端socket输出完成
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print("是否继续向服务器输出数据?(Y/N): ");
        scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.isEmpty())
        {
            return flag;
        }
        char ch = line.charAt(0);
        if ('n' == ch || 'N' == ch) {
            flag = false;
            out.print("#end");
            out.flush();
        }
        if ('y' == ch || 'Y' == ch) {
            flag = true;
        }
        if (out != null) {
            out.close();
        }
        return flag;
    }

    /**
     * 接收服务器返回的数据
     * @param socket
     * @return flag
     */
    public static boolean getDataFromServer(Socket socket)
    {
        boolean flag = true;    //客户端保持接收标志
        InputStream input = null;
        InputStreamReader inReader = null;
        BufferedReader reader = null;
        if (socket == null){
            throw new IllegalArgumentException("socket接收失败");
        }
        try {
            input = socket.getInputStream();
            inReader = new InputStreamReader(input);
            reader = new BufferedReader(inReader);
            while (true) {
                //等待服务端输出
                String line = reader.readLine();
                if (line == null) {
                    return flag;
                }
                line = URLDecoder.decode(line, "UTF-8");
                if (line.equals("#end")) {
                    flag = false;   //服务端结束发送
                    return flag;
                }
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if (reader != null)
        {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
