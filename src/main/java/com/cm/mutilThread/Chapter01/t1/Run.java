package com.cm.mutilThread.Chapter01.t1;

/**
 * @author chengawu
 * @date 1/11/2019 4:41 PM
 */
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("End running");
    }
}
