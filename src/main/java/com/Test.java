package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        System.out.println(isboolIp("asdad"));
        System.out.println(isboolIp("192.168.1.1"));
        System.out.println(isboolIp("256.2.3.4"));
        System.out.println(isboolIp("1.2.3.4"));
        System.out.println(isboolIp("1.2.3.4.5"));
        System.out.println(isboolIp("1.2.3.4."));
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
