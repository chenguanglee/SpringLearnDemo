package com.chenguangli.net;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author chenguangli
 * @date 2019/4/21 0:14
 */
public class IOClient {
    public static void main(String[] args) throws Exception{
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        socket.getOutputStream().flush();
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();
    }
}
