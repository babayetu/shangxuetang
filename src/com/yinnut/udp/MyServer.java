package com.yinnut.udp;

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
			server = new DatagramSocket(7777);
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
