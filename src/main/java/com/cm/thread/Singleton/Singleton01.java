package com.cm.thread.Singleton;

import java.util.Arrays;

/**
 * 线程安全的单例模式
 * 更好的是采用下面的方式，既不用加锁，也能实现懒加载
 *
 * @author chengawu
 * @date 12/21/2018 3:37 PM
 */
public class Singleton01 {
    public Singleton01() {
        System.out.println("single");
    }

    private static class Inner {
        private static Singleton01 s = new Singleton01();
    }

    public static Singleton01 getSingle() {
        return Inner.s;
    }

    public static void main(String[] args) {
        Thread[] ths = new Thread[200];
        for (int i = 0; i < ths.length; i++) {
            ths[i] = new Thread(() -> {
                Singleton01.getSingle();
            });
        }
        Arrays.asList(ths).forEach(o -> o.start());
    }
}
