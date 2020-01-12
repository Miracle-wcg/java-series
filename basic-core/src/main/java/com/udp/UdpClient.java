package com.udp;

import java.net.*;

public class UdpClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送方启动.....");
        DatagramSocket client = new DatagramSocket(9999);
        String data = "发送测试信号";
        byte[] datas = data.getBytes();
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 8888));
        client.send(packet);
        client.close();
    }
}
