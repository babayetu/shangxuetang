package com.yinnut.otherstream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * PrintStrean 打印流 -> 处理流
 * @author liujingjing
 *
 */
public class PrintStreamDemo01 {

	public static void main(String[] args) throws FileNotFoundException {
//		PrintStream out = System.out;
//		out.println("aaa");
		
		//输出到文件，使用
//		PrintStream ps = new PrintStream(new File("ttttt.txt"));
		PrintStream ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("/Users/liujingjing/t2.txt"))));

		ps.println("line one");
		ps.println("line two");
		
		ps.close();
		
		test1();
	}
	
	public static void test1() {
		System.out.println("test");
		System.err.println("error");
	}

}
