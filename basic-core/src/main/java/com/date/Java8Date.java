package com.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @Author Miracle.wcg
 * @Date 2019-08-25 15:37
 */
public class Java8Date {
    public static final DateTimeFormatter SIMPLE_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private Java8Date() {
    }

    public static LocalDate parse(String target) {
        return LocalDate.parse(target, SIMPLE_DATE_FORMAT);
    }

    public static String format(LocalDate format) {
        return format.format(SIMPLE_DATE_FORMAT);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        final String str = "2019-07-03";
        IntStream.rangeClosed(0, 50).forEach(i -> executorService.submit(() -> System.out.println(Java8Date.parse(str))));
        executorService.shutdown();
    }
}
