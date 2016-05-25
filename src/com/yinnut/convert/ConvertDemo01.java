package com.yinnut.convert;

import java.io.UnsupportedEncodingException;

public class ConvertDemo01 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		ConvertDemo01 convertDemo01 = new ConvertDemo01();
		convertDemo01.test1();
	}
	
	public void test1() {
		String testStr = "中国";
		byte[] testByte = testStr.getBytes();
		
		//字节数不完整
		System.out.println(new String(testByte, 0, 3));
	}
	
	public void test2() throws UnsupportedEncodingException {
		//解码 byte --> char
		String str = "加油go！Goal! Fighting!";
		//编码  char --> byte
		byte[] data = str.getBytes();
		//编码与解码的字符集统一
		System.out.println(new String(data));
		//设定编码字符集
		data = str.getBytes("gbk");
		//不指定，使用平台默认字符集比如utf-8,解码编码字符集不统一，出现乱码
		System.out.println(new String(data));
		//用相同的字符集解码，不会出现乱码
		System.out.println(new String(data,"gbk"));
	}
}
