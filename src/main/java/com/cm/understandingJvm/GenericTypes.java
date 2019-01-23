package com.cm.understandingJvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 必须使用Sun JDK 1.6 的javac才能编译成功
 *
 * @author chengawu
 * @date 1/17/2019 3:30 PM
 */
public class GenericTypes {
   /* public static String method(List<String> list) {
        System.out.println("invoke method(List<String> list)");
        return "";
    }*/

    public static int method(List<Integer> list) {
        System.out.println("invoke method(List<Integer> list)");
        return 1;
    }

    public static void main(String[] args) {
//        method(new ArrayList<String>());
        method(new ArrayList<Integer>());
    }
}
