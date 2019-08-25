package com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @Author Miracle.wcg
 * @Date 2019-08-25 15:18
 */
public class DateTest1 {
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private DateTest1() {
    }

    public static Date parse(String target) {
        try {
            return SIMPLE_DATE_FORMAT.parse(target);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String format(Date format) {
        return SIMPLE_DATE_FORMAT.format(format);

    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        final String str = "2019-07-03";

        System.out.println("******** parse date ********");
        IntStream.rangeClosed(0, 20).forEach(i -> executorService.submit(() -> System.out.println(DateTest1.parse(str))));
        executorService.shutdown();
    }

}
