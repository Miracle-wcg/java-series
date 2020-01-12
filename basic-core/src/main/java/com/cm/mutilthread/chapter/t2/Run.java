package com.cm.mutilthread.chapter.t2;

/**
 * @author chengawu
 * @date 1/11/2019 5:08 PM
 */
public class Run {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("End running");
    }
}
