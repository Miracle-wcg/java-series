package com;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
//        System.out.println(isboolIp("asdad"));
//        System.out.println(isboolIp("192.168.1.1"));
//        System.out.println(isboolIp("256.2.3.4"));
//        System.out.println(isboolIp("1.2.3.4"));
//        System.out.println(isboolIp("1.2.3.4.5"));
//        System.out.println(isboolIp("1.2.3.4."));
//        Instant instant = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
//        System.out.println(instant.toString());
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        Instant instant = Instant.now();
        LocalDateTime nowTime = instant.atZone(zoneId).toLocalDateTime();
        Date input = Date.from(instant);
        System.out.println(input);
        System.out.println("******Now******");
        System.out.println(instant);
        System.out.println(nowTime);
        System.out.println("******Now******");
        Instant newInstant = Instant.now().plusSeconds(120);
        Date out = Date.from(newInstant);
        System.out.println(out);
        LocalDateTime dateTime = newInstant.atZone(zoneId).toLocalDateTime();
        System.out.println(newInstant);
        System.out.println(dateTime);
        System.out.println(input.compareTo(out));
        System.out.println(out.compareTo(input));
        System.out.println(out.compareTo(out));

    }

    /**
     * 判断是否为合法IP * @return the ip
     */
    public static boolean isboolIp(String ipAddress) {
        String ip = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
        Pattern pattern = Pattern.compile(ip);
        Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();
    }

}
