package com.cm;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        String s1 = "java";
        StringBuffer s2 = new StringBuffer("123");

        System.out.println(s1 == s1.intern());
        System.out.println(s2.toString() == s2.toString().intern());
    }
}
