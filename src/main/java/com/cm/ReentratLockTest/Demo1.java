package com.cm.ReentratLockTest;

import java.util.concurrent.locks.ReentrantLock;

public class Demo1 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new ReentrantLock(false);
        lock.lock();
        lock.tryLock();
        lock.newCondition();
    }
}
