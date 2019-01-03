package com.cm.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author chengawu
 * @date 12/29/2018 2:14 PM
 */
public class Test {
    static String s1 = "aaa";

    public static void main(String[] args) {
        Thread th1 = new Thread(() -> {
            System.out.println("Thread 1 running");
            System.out.println(s1);
        });
        Thread th2 = new Thread(() -> {
            s1 = "bbb";
            System.out.println("Thread 2 running");
        });

        try {
            th2.start();
            Thread.sleep(1000);
            th1.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
