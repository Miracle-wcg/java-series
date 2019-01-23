package com.cm.mutilThread.Chapter01.t3;

/**
 * @author chengawu
 * @date 1/11/2019 5:23 PM
 */
public class MyThread extends Thread {
    private int count = 5;

    public MyThread(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("Thread " + this.currentThread().getName() + " calculated count is:" + count);
        }
    }
}
