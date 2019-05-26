package com.A_B_NIO.aio;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AIOServer {
    private ExecutorService executorService;                        //线程池
    private AsynchronousChannelGroup threadGroup;                   //通道组
    public AsynchronousServerSocketChannel asynServerSocketChannel; //服务器通道

    public void start(int port) {
        try {
            executorService = Executors.newCachedThreadPool();
            threadGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);
            asynServerSocketChannel = AsynchronousServerSocketChannel.open(threadGroup);
            asynServerSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("AIO Server >>>>>>> port: " + port);
            asynServerSocketChannel.accept(this, new AIOServerHandler());
            Thread.sleep(Integer.MAX_VALUE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AIOServer aioServer = new AIOServer();
        aioServer.start(8888);
    }
}
