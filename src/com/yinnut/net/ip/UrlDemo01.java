package com.yinnut.net.ip;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlDemo01 {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.baidu.com:8080/index.html#aa?uname=bjsxt");
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getPath());
		
		URL basicURL = new URL("http://www.baidu.com:80/");
		URL relativeURL = new URL(basicURL,"index.html?uname=bjsxt");
		System.out.println(relativeURL);
		System.out.println(relativeURL.getFile());
		System.out.println(relativeURL.getRef());
		System.out.println(relativeURL.getQuery());
	}

}
