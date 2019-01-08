package com.cm.thread.ConcurrentCollections.Day2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chengawu
 * @date 1/8/2019 3:48 PM
 */
public class T09_SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int j = i;
            service.execute(() -> {
                System.out.println(j + " " + Thread.currentThread().getName());
            });
        }
    }
}
