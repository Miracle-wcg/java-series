package com.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connect Successfully");
        System.out.println("Server running:" + jedis.ping());

        //String
        System.out.println("********** String Test ****************");
        jedis.set("key", "testKey");
        System.out.println("Redis Saved String;" + jedis.get("key"));

        System.out.println("********** List Test ****************");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Oracle");
        jedis.lpush("site-list", "Baidu");
        List<String> list = jedis.lrange("site-list", 0, 2);
        for (String str : list) {
            System.out.println("Item is:" + str);
        }
    }
}
