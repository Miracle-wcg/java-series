package com.cm.thread.ConcurrentCollections.Day2;

import java.util.concurrent.Executor;

/**
 * @author chengawu
 * @date 1/4/2019 5:27 PM
 */
public class T01_MyExecutor implements Executor {

    public static void main(String[] args) {
        new T01_MyExecutor().execute(() -> System.out.println("hello executor"));
    }

    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
