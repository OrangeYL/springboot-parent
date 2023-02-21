package com.orange.demo.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author: Li ZhiCheng
 * @create: 2022-09-2022/9/21 19:08
 * @description: Tcp网络编程  客户端发送信息给服务端
 */
public class TcpClientDemo01 {
    public static void main(String[] args) {
        InetAddress serverAddress=null;
        Socket socket=null;
        OutputStream outputStream=null;
        //服务端地址
        try {
            serverAddress = InetAddress.getByName("127.0.0.1");
            int port=8899;
            //创建一个socket
            socket = new Socket(serverAddress, port);
            //创建一个输出流，向外写东西
            outputStream = socket.getOutputStream();
            //将"你好呀，共同进步！"写入输出流
            outputStream.write("你好呀，共同进步！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(outputStream!=null){
                    outputStream.close();
                }
                if(socket!=null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
