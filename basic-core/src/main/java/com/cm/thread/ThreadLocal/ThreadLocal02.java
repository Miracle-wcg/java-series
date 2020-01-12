package com.cm.thread.ThreadLocal;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal是使用空间换时间（效率高），synchronized是使用时间换空间
 * 比如在hibernate中session就存在于ThreadLocal中，避免synchronized的使用
 */
public class ThreadLocal02 {
    static ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
        }).start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Person());
        }).start();
    }

    static class Person {
        String name = "zhangsan";
    }
}
