package com.cm.mutilThread.Chapter01.t3;

/**
 * @author chengawu
 * @date 1/11/2019 5:27 PM
 */
public class Run {
    public static void main(String[] args) {
        MyThread a = new MyThread("A");
        MyThread b = new MyThread("B");
        MyThread c = new MyThread("C");
        a.start();
        b.start();
        c.start();
    }
}
