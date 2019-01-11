package com.cm.MutilThread.Chapter01.samenum;

/**
 * @author chengawu
 * @date 1/11/2019 5:45 PM
 */
public class MyThread extends Thread {
    private int i = 5;

    @Override
    public void run() {
        System.out.println("i=" + (i--) + " threadName=" + Thread.currentThread().getName());
    }
}
