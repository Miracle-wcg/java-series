package com.cm.understandingJvm;

/**
 * @author chengawu
 * @date 1/11/2019 2:47 PM
 */
public class Test {
    public static void main(String[] args) {
//        int a = 100;
//        int b = 200;
//        int c = 300;
//        System.out.println((a + b) * c);
        String a = new String("A") + new String("A");
        String b = "AA";
        String c = new String("A") + new String("A");
        System.out.println(a.intern() == a);
        System.out.println(b.intern() == b);
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b.intern() == c);
    }
}
