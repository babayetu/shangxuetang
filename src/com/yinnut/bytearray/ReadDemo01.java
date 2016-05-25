package com.yinnut.bytearray;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadDemo01 {

	public static void main(String[] args) throws IOException {
		String str = "奔跑吧！京京酱";
		InputStream bais = new BufferedInputStream(new ByteArrayInputStream(str.getBytes()));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		byte[] car = new byte[1024];
		int len = 0;
		
		byte[] dest;
		
		while ((len = bais.read(car)) != -1) {  //从ByteArrayInputStream输入流读取到自定义的car数组中
			baos.write(car, 0, len);   //写入ByteArrayOutputStream输出流
			dest = baos.toByteArray();  //获取输出流字节数组
			System.out.println(new String(dest,0,dest.length));
		}

		bais.close();
		baos.close();
	}

}
