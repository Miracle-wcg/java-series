package com.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {
    public static void main(String[] args) throws Exception {
        System.out.println("接收方启动.....");
        DatagramSocket server = new DatagramSocket(8888);
        byte[] content = new byte[1024 * 60];
        DatagramPacket packet = new DatagramPacket(content, 0, content.length);
        server.receive(packet);
        byte[] result = packet.getData();
        int len = result.length;
        System.out.println(new String(result, 0, len));
        server.close();
    }
}
