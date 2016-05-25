package com.yinnut.bytearray;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件-FileInputStream-> 程序 -ByteArrayOutputStream-> 字节数组
 * 字节数组 -ByteArrayInputStream-> 程序 -FileOutputStream-> 文件
 * @author liujingjing
 *
 */
public class NewCopy {

	public static void main(String[] args) throws IOException {
		NewCopy newCopy = new NewCopy();
		String src = "/Users/liujingjing/spring_workspace/Shangxuetang/src/com/yinnut/bytearray/NewCopy.java";
		newCopy.setBytesToFile(newCopy.getBytesFromFile(new File(src)),new File("/Users/liujingjing/ttt2.java"));

	}
	
	/**
	 * 从文件读出内容输出到ByteArrayOutputStream流
	 * 结束后把ByteArrayOutputStream流的内容转变成byte[]
	 * @param src
	 * @return
	 * @throws IOException
	 */
	public byte[] getBytesFromFile(File src) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		byte[] car = new byte[1024];
		int len = 0;
		while (-1 != (len=is.read(car))) {
			baos.write(car, 0, len);
		}
		baos.flush();
		is.close();
		byte[] result = baos.toByteArray();
		baos.close();
		return result;
	}
	
	/**
	 * 构建ByteArrayInputStream从byte[]
	 * 输出到FileOutputStream，从而写入文件
	 * @param content
	 * @param dest
	 * @throws IOException
	 */
	public void setBytesToFile(byte[] content, File dest) throws IOException {
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(content));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		
		byte[] car = new byte[1024];
		int len = 0;
		while (-1!=(len = is.read(car))) {
			os.write(car, 0, len);
		}
		os.flush();
		os.close();
		is.close();
	}	
}
