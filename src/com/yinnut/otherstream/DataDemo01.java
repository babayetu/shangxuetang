package com.yinnut.otherstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 数据类型(基本+ String)处理流
 * @author liujingjing
 *
 */
public class DataDemo01 {

	public static void main(String[] args) throws IOException {
		//存储到文件中
		//write("1.temp");
		//read("1.temp");
		
		//存储到字节数组中
		read(write());
	}
	
	public static void write(String dest) throws IOException {
		double point = 0.5;
		long num = 100L;
		String str = "数据类型";
		
		File destFile = new File(dest);
		
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(destFile)));
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		
		dos.flush();
		dos.close();
	}
	
	public static byte[] write() throws IOException {
		byte[] bb = null;
		double point = 0.5;
		long num = 100L;
		String str = "数据类型";
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		
		dos.flush();
		bb = baos.toByteArray();
		dos.close();
		return bb;
	}
	
	public static void read(String src) throws IOException {
		File srcFile = new File(src);
		
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(
				new FileInputStream(srcFile)));
		//顺序很重要，先读long后读double，出来奇怪的结果
		System.out.println(dis.readDouble());
		System.out.println(dis.readLong());
		System.out.println(dis.readUTF());
		
		dis.close();
	}
	
	public static void read(byte[] content) throws IOException {
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(
				new ByteArrayInputStream(content)));
		//顺序很重要，先读long后读double，出来奇怪的结果
		System.out.println(dis.readDouble());
		System.out.println(dis.readLong());
		System.out.println(dis.readUTF());
		
		dis.close();
	}
}
