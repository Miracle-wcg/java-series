package com.cm.thread.ConcurrentCollections.Day3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    private static CyclicBarrier cyclicBarrier;

    static class CyclicBarrierThread extends Thread {
        public void run() {
            System.out.println(Thread.currentThread().getName() + "到了");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("开始开会！！");
            }
        });

        for (int i = 0; i < 5; i++) {
            new CyclicBarrierThread().start();
        }
    }
}
