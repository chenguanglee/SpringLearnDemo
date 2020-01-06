package com.chenguangli.base.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chenguangli
 * @date 2019/4/21 0:01
 */
public class IOServer1 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);

        // (1) 接收新连接线程

        while (true) {
            try {
                // (1) 阻塞方法获取新的连接
                Socket socket = serverSocket.accept();

                // (2) 每一个新的连接都创建一个线程，负责读取数据

                try {
                    InputStream inputStream = socket.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder stringBuffer = new StringBuilder();
                    String str;
                    while ((str = bufferedReader.readLine()) != null) {
                        stringBuffer.append(str);
                    }
                    System.out.println(stringBuffer.toString());

                    String data = "lee";
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write(data.getBytes());
                    System.out.println("server -----");
                    inputStream.close();
                    outputStream.close();
                    socket.close();
                } catch (IOException e) {
                }


            } catch (IOException e) {
            }

        }

    }
}



