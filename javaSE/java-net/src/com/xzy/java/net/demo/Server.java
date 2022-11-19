package com.xzy.java.net.demo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        //开启服务器 5566 端口,开始监听客户端
        startServer(5566,true);
    }

    /**
     * 开启服务器,一直保持监听
     * @param port 端口号
     */
    public static void startServer(int port,boolean start){
        if (port<0||port>65535){
            System.out.println("端口输入错误,范围为[0,65535]");
            return;
        }
        if (start != true)
        {
            //开关不是true或端口为0,不启动服务
            System.out.println("服务器开关未打开");
            return;
        }
        boolean sGetFlag = true;   //服务器得到数据标志
        boolean sOutFlag = true;   //服务器输出数据标志
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            //服务器端需要创建监听特定端口的ServerSocket,ServerSocket负责接收客户连接请求
            serverSocket = new ServerSocket(port);
            System.out.println("Socket服务端已启动");
            while (true) {
                //一直保持监听客户端的socket,直到监听到一个socket就结束,保持永远监听就加死循环
                socket = serverSocket.accept();  //一直保持监听客户端的socket,直到监听到一个socket就结束
                System.out.println("已接受到客户端请求:" + socket.getRemoteSocketAddress());
                //接收客户端数据
                sGetFlag = getDataFromClient(socket);
                System.out.println("服务器接收到数据与确认标志");
                if (!sGetFlag) {
                    System.out.println("客户端发送结束,服务器开始发送数据");
                    System.out.println("==========================");
                    while(true) {
                        socket = serverSocket.accept();
                        System.out.println("已链接到客户端" + socket.getRemoteSocketAddress());
                        sOutFlag = outDataToClient(socket);
                        if (!sOutFlag) {
                            System.out.println("服务器向" + socket.getRemoteSocketAddress() + "发送数据结束");
                            break;
                        }
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (serverSocket != null)
        {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 得到客户端数据和确认标记
     * @param socket
     * @return
     */
    public static boolean getDataFromClient(Socket socket){
        boolean flag = true;    //服务器保持监听标志
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
                //等待客户端输出
                String line = reader.readLine();
                if (line == null) {
                    return flag;
                }
                line = URLDecoder.decode(line, "UTF-8");
                if (line.equals("#end")) {
                    flag = false;   //客户端结束发送
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

    /**
     * 向客户端发送数据与确认标志
     * @param socket
     * @return
     */
    public static boolean outDataToClient(Socket socket){
        boolean flag = true;
        OutputStream output = null;
        PrintWriter out = null;
        Scanner scanner = null;
        if (socket == null){
            throw new IllegalArgumentException("socket接收失败");
        }
        try {
            //利用socket向客户端发送一条信息
            output = socket.getOutputStream();
            out = new PrintWriter(output);
            System.out.println("向客户端发送一条数据:");
            scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            line = URLEncoder.encode(line, "UTF-8");
            out.println(line);
            out.flush();
            //socket.shutdownOutput();   表示socket输出完成
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("是否继续向客户端输出数据?Y/N");
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

}
