package com.cm.thread;

/**
 * @author chengawu
 * @date 12/29/2018 2:22 PM
 */
public class VolatileTest {
    public static volatile int race = 0;
    public static final int THREADS_COUNT = 20;

    public static void increase() {
        race++;
    }

    public static void main(String[] args) {
        Thread[] ths = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            ths[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    increase();
                }
            });
            ths[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println(race);
    }
}
