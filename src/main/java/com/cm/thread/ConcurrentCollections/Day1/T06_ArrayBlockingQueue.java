package com.cm.thread.ConcurrentCollections.Day1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 有界Queue
 *
 * @author chengawu
 * @date 1/3/2019 3:40 PM
 */
public class T06_ArrayBlockingQueue {
    static BlockingQueue<String> strs = new ArrayBlockingQueue<String>(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            strs.put("a" + i);
        }

        strs.put("aaa"); // 满了就会等待，程序阻塞
//        strs.add("aaa"); //throw IllegalStateException
//        strs.offer("aaa"); // return false
//        strs.offer("aaa", 1, TimeUnit.SECONDS);
        System.out.println(strs);
    }
}
