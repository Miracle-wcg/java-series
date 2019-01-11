package com.cm.MutilThread.Chapter01.t4_threadsafe;

/**
 * @author chengawu
 * @date 1/11/2019 5:36 PM
 */
public class Run {
    public static void main(String[] args) {
        ALogin a = new ALogin();
        a.start();
        BLogin b = new BLogin();
        b.start();
    }
}
