package com.chenguangli.base.net;

import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * @author chenguangli
 * @date 2019/4/21 0:14
 */
public class IOClient1 {
    public static void main(String[] args) throws Exception {
        try {
            Socket socket = new Socket("127.0.0.1", 8090);

            try {
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("hello world".getBytes());
                outputStream.flush();
                socket.shutdownOutput();

                InputStream inputStream = socket.getInputStream();

                if (inputStream != null) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder stringBuffer = new StringBuilder();
                    String str;
                    while ((str = bufferedReader.readLine()) != null) {
                        stringBuffer.append(str);
                    }
                    System.out.println(stringBuffer.toString());
                    inputStream.close();
                }
                outputStream.close();
                //socket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
