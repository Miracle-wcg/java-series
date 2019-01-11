package com.cm.MutilThread.Chapter01.t1;

/**
 * @author chengawu
 * @date 1/11/2019 4:40 PM
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread");
    }
}
