package com.cm.thread.ConcurrentCollections.Day2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author chengawu
 * @date 1/8/2019 2:24 PM
 */
public class T05_ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 6; i++) {
            service.execute(() -> {
                try {
                    TimeUnit.MICROSECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println(service);

        service.shutdown();
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());

        TimeUnit.SECONDS.sleep(5);
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);
    }
}
