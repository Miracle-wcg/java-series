package com.redis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.3.14", 6379);
//        jedis.set("k1", "v1");
//        System.out.println(jedis.ping());
//        jedis.lpush("site-list", "Google");
//        jedis.lpush("site-list", "Twitter");
//        jedis.lpush("site-list", "Facebook");
//
//        List<String> list = jedis.lrange("site-list", 0, -1);
//        for (String val : list) {
//            System.out.println(val);
//        }

        Set<String> strings = jedis.keys("*");
        for (String val : strings) {
            System.out.println(val);
        }
    }
}
