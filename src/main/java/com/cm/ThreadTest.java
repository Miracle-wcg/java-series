package com.cm;

public class ThreadTest {
    static Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("T1 running...");
        }
    });

    static Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("T2 running...");
        }
    });

    static Thread t3 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("T3 running...");
        }
    });

    public static void main(String[] args) {
        t1.start();
        t2.start();
        t3.start();
    }
}
