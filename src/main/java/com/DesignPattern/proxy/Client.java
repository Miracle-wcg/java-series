package com.DesignPattern.proxy;

public class Client {
    public static void main(String[] args) {
        Image image = new ProxyImage("aaa.img");
        image.display();
        image.display();
    }
}
