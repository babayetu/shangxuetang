package com.yinnut.net.ip;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class InetSocketDemo01 {

	public static void main(String[] args) {
		InetSocketAddress isa = new InetSocketAddress("www.baidu.com", 18080);
		
		System.out.println(isa.getHostName());

		System.out.println(isa.getPort());
		
		InetAddress address = isa.getAddress();
		
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());
	}

}
