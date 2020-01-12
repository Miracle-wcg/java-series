package com.cm.thread.ConcurrentCollections.Day1;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author chengawu
 * @date 1/2/2019 5:02 PM
 */
public class T04_ConcurrentQueue {

    public static void main(String[] args) {
        Queue<String> strs = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < 10; i++) {
            strs.offer("a"+i);
        }

        System.out.println(strs);
        System.out.println(strs.size());

        System.out.println(strs.poll());
        System.out.println(strs.size());

        System.out.println(strs.peek());
        System.out.println(strs.size());
    }
}
