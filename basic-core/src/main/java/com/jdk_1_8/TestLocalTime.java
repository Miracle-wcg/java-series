package com.jdk_1_8;

import org.junit.Test;

import java.time.LocalDateTime;

public class TestLocalTime {
    @Test
    public void test01(){
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);


    }
}
