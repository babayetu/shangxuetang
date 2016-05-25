package com.yinnut.net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetDemo01 {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress localHost = InetAddress.getLocalHost();
		System.out.println(localHost.getHostAddress());
		System.out.println(localHost.getHostName());
		
		InetAddress byName = InetAddress.getByName("192.168.1.206");
		System.out.println(byName.getHostAddress());
		System.out.println(byName.getHostName());
		
		InetAddress byName2 = InetAddress.getByName("www.baidu.com");
		System.out.println(byName2.getHostAddress());
		System.out.println(byName2.getHostName());
	}

}
