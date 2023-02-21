package com.orange.demo.tcp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: Li ZhiCheng
 * @create: 2022-09-2022/9/21 19:19
 * @description: Tcp网络编程 服务端接收信息显示在控制台
 */
public class TcpServerDemo01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
        //1. 开放服务器端口，创建ServerSocket
            serverSocket = new ServerSocket(8899);
        //2. 等待客户端的连接
            accept = serverSocket.accept();
        //3. 创建输入流，读入客户端的消息,
            is = accept.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            //read:读入输入流is，并存入buffer
            while ((len=is.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }
            System.out.println(baos.toString());
            System.out.println("数据来源地址："+accept.getInetAddress().getHostName());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        //4. 关闭资源
            try {
                if (baos!=null){
                    baos.close();
                }
                if (is!=null){
                    is.close();
                }
                if (accept!=null){
                    accept.close();
                }
                if (serverSocket!=null){
                    serverSocket.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
