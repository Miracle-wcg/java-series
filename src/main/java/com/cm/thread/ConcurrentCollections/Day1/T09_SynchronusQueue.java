package com.cm.thread.ConcurrentCollections.Day1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author chengawu
 * @date 1/3/2019 4:53 PM
 */
public class T09_SynchronusQueue {//容量为0

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> strs = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.put("aaa");//阻塞等待消费者消费
        System.out.println(strs.size());
    }
}
