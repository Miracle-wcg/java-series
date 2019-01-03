package com.cm.thread.ConcurrentCollections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 写是复制容器
 * 多线程环境下，写时效率低，读时效率高
 * 适合写少读多的场景
 *
 * @author chengawu
 * @date 12/24/2018 3:43 PM
 */
public class T02_CopyOnWriteList {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        List<String> list = new Vector<>();
        List<String> list = new CopyOnWriteArrayList<>();

        Random r = new Random();
        Thread[] ths = new Thread[100];
        for (int i = 0; i < ths.length; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        list.add("a" + r.nextInt(10000));
                    }
                }
            };
            ths[i] = new Thread(task);
        }

        runAndComputeTime(ths);
        System.out.println(list.size());
    }

    private static void runAndComputeTime(Thread[] ths) {
        long start = System.currentTimeMillis();
        Arrays.asList(ths).forEach(t -> t.start());
        Arrays.asList(ths).forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
