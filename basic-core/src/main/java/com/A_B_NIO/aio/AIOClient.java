package com.A_B_NIO.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Random;

public class AIOClient implements Runnable {
    private static int PORT = 8888;
    private static String IP_ADDRESS = "127.0.0.1";
    private AsynchronousSocketChannel asynchronousSocketChannel;

    public AIOClient() throws IOException {
        asynchronousSocketChannel = AsynchronousSocketChannel.open();
    }

    private void connect() {
        asynchronousSocketChannel.connect(new InetSocketAddress(IP_ADDRESS, PORT));
    }

    public void write(String request) {
        try {
            asynchronousSocketChannel.write(ByteBuffer.wrap(request.getBytes())).get();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            asynchronousSocketChannel.read(byteBuffer).get();
            byteBuffer.flip();
            byte[] bytes = new byte[byteBuffer.remaining()];
            byteBuffer.get(bytes);
            System.out.println(new String(bytes, "utf-8").trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
        }
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            AIOClient client = new AIOClient();
            client.connect();
            new Thread(client, "myClient").start();
            String[] operators = {"+", "-", "*", "/"};
            Random random = new Random(System.currentTimeMillis());
            String expression = random.nextInt(10) + operators[random.nextInt(4)] + (random.nextInt(10) + 1);
            client.write(expression);
        }
    }


}
