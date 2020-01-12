package com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 *
 * 日期格式是不同步的。
 * 建议为每个线程创建独立的格式实例。
 * 如果多个线程同时访问一个格式，则它必须是外部同步的。
 *（当我们使用实例变量时，应始终检查其是否是一个线程安全类。）
 *
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
