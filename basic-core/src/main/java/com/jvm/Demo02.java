package com.jvm;

public class Demo02 {
    public static void main(String[] args) {
        try {
            Class d1 = Class.forName("com.jvm.Demo01");
            Class d2 = ClassLoader.class.getClassLoader().loadClass("com.jvm.Demo01");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
