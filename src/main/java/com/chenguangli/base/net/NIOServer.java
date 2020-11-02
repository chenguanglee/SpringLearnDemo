package com.chenguangli.base.net;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author chenguangli
 * @date 2020/9/12 16:44
 */
public class NIOServer {

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                int select = selector.select();
                System.out.println("当前select个数" + select);
                if (select == 0) {
                    continue;
                }
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey next = iterator.next();
                    iterator.remove();
                    if (next.isAcceptable()) {
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
//                        ByteBuffer byteBuffer = ByteBuffer.allocate(123);
//                        byteBuffer.put(new String("123").getBytes());
//                        socketChannel.write(byteBuffer);
                    }

                    if (next.isReadable()) {
                        SocketChannel channel = (SocketChannel) next.channel();

                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        int read = channel.read(byteBuffer);
                        if (read <= 0) {
                            channel.close();
                            next.cancel();
                        }
                        System.out.println(new String(byteBuffer.array()));

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
