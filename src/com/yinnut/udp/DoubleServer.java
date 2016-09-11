package com.yinnut.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 服务端
 * @author liujingjing
 *
 */
public class DoubleServer {

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
			
			ByteArrayInputStream bais = new ByteArrayInputStream(data,0,length);
			DataInputStream dis = new DataInputStream(bais);

			Double dd = dis.readDouble();
			System.out.println(dd);
			
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
