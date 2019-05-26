package com.A_B_NIO.aio;

import com.A_B_NIO.bio.CalculatorUtil;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

public class AIOServerHandler implements CompletionHandler<AsynchronousSocketChannel, AIOServer> {
    private final int BUFFER_SIZE = 1024;

    @Override
    public void completed(AsynchronousSocketChannel asynchronousSocketChannel, AIOServer attachment) {
        attachment.asynServerSocketChannel.accept(attachment, this);
        read(asynchronousSocketChannel);
    }

    private void read(AsynchronousSocketChannel asynchronousSocketChannel) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        asynchronousSocketChannel.read(byteBuffer, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                attachment.flip();
                String resultData = new String(attachment.array()).trim();
                System.out.println("Server receive data >>>>> is :" + resultData);
                String response = resultData + "=" + CalculatorUtil.cal(resultData);
                write(asynchronousSocketChannel, response);
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                exc.printStackTrace();
            }
        });
    }

    private void write(AsynchronousSocketChannel asynchronousSocketChannel, String response) {
        try {
            ByteBuffer buf = ByteBuffer.allocate(1024);
            buf.put(response.getBytes());
            buf.flip();
            asynchronousSocketChannel.write(buf).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void failed(Throwable exc, AIOServer attachment) {
        exc.printStackTrace();
    }
}
