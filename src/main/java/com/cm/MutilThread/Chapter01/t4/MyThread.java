package com.cm.MutilThread.Chapter01.t4;

/**
 * @author chengawu
 * @date 1/11/2019 5:28 PM
 */
public class MyThread extends Thread{
    private int count = 5;
    @Override
    synchronized public void run() {
        super.run();
        count--;
        System.out.println("Thread " + this.currentThread().getName() + " calculated count is:" + count);
    }
}
