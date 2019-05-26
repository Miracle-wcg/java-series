package com.A_B_NIO.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer implements Runnable {
    private final int BUFFER_SIZE = 1024;//缓冲大小
    private final int PORT = 8888;
    private Selector selector;
    private ByteBuffer readBuffer = ByteBuffer.allocate(BUFFER_SIZE);

    public NIOServer() {
        startServer();
    }

    private void startServer() {
        try {
            selector = Selector.open();
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.configureBlocking(false);
            channel.socket().bind(new InetSocketAddress(PORT));

            channel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Server start >>>>>>>> port:" + PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                selector.select();

                Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();
                while (selectionKeyIterator.hasNext()) {
                    SelectionKey key = selectionKeyIterator.next();
                    selectionKeyIterator.remove();
                    if (!key.isValid()) {
                        continue;
                    }
                    if (key.isAcceptable()) {
                        accept(key);
                    }
                    if (key.isReadable()) {
                        read(key);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void read(SelectionKey key) {
        try {
            readBuffer.clear();
            SocketChannel channel = (SocketChannel) key.channel();
            int count = channel.read(readBuffer);
            if (-1 == count) {
                key.channel().close();
                key.cancel();
                return;
            }
            readBuffer.flip();
            byte[] bytes = new byte[readBuffer.remaining()];
            readBuffer.get(bytes);
            System.out.println("NIO Server: " + new String(bytes));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void accept(SelectionKey key) {
        try {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new NIOServer()).start();
    }
}
