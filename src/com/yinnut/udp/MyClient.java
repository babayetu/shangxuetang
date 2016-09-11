package com.yinnut.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class MyClient {

	public static void main(String[] args) throws IOException {
		//1. 创建服务端+端口
		DatagramSocket ds = new DatagramSocket(12345);
		//2.准备数据
		String msg = "udp 编程";
		//3.打包，指定发送的地点及端口 
		DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length,new InetSocketAddress("127.0.0.1",7777));
		//4.发送
		ds.send(dp);
		//5.释放
		ds.close();

	}

}
