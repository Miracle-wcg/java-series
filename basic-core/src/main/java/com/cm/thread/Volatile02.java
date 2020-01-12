package com.cm.thread;

/**
 * @author chengawu
 * @date 12/29/2018 2:44 PM
 */
public class Volatile02 {
    private volatile static Volatile02 instance;

    public static Volatile02 getInstance() {
        if (instance == null) {
            synchronized (Volatile02.class) {
                if (instance == null) {
                    instance = new Volatile02();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Volatile02.getInstance();
    }
}
