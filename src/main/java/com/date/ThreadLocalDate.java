package com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @Author Miracle.wcg
 * @Date 2019-08-25 15:36
 */
public class ThreadLocalDate {
    public static final ThreadLocal SIMPLE_DATE_FORMAT = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    private ThreadLocalDate() {
    }

    public static Date parse(String target) {
        try {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) SIMPLE_DATE_FORMAT.get();
            return simpleDateFormat.parse(target);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String format(Date format) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) SIMPLE_DATE_FORMAT.get();
        return simpleDateFormat.format(format);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        final String str = "2019-07-03";
        IntStream.rangeClosed(0, 50).forEach(i -> executorService.submit(() -> System.out.println(ThreadLocalDate.parse(str))));
        executorService.shutdown();
    }
}
