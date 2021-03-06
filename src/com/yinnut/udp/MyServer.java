package com.yinnut.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 服务端
 * @author liujingjing
 *
 */
public class MyServer {

	public static void main(String[] args) {
		DatagramSocket server = null;
		try {
			//1.创建服务器+端口号
			server = new DatagramSocket(7777);
			//2.准备接收容器
			byte[] container = new byte[1024];
			//3.封装成包
			DatagramPacket dp = new DatagramPacket(container,container.length);
			//4. 接收数据
			server.receive(dp);
			//5.分析数据
			byte[] data = dp.getData();
			int length = dp.getLength();
			System.out.println(new String(data,0,length));
			//6.释放资源
			 server.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
