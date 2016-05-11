package com.yinnut.io.file;

import java.io.File;

import org.omg.PortableInterceptor.USER_EXCEPTION;

public class Demo01 {
	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		
		String parentPath="/Users/liujingjing";
		String name = "xsd-config.html";
		
		File path = new File(parentPath,name);
		System.out.println(path.isFile());
		System.out.println(path.getParent());
		
		path = new File(new File(parentPath),name);
		System.out.println(path.isFile());
		System.out.println(path.getName());
		System.out.println(path.getPath());
		System.out.println(path.getParent());
		
		//没有盘符，以user.dir构建联系
		path = new File("test.txt");
		System.out.println(path.getName());
		System.out.println(path.getPath());
		System.out.println(path.getAbsolutePath());
		System.out.println(path.getParent());
//		
//		path = new File(".");
//		System.out.println(path.getName());
//		System.out.println(path.getPath());
//		System.out.println(path.getAbsolutePath());
	}
}
