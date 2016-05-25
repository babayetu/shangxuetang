package com.yinnut.otherstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import com.yinnut.io.util.CloseStream;

/**
 * System.in 输入流 键盘控制
 * System.out 输出流 控制台输出
 * System.err
 * 
 * ==>重定向
 * setIn
 * setOut
 * SetErr
 * @author liujingjing
 *
 */
public class SystemDemo01 {

	public static void main(String[] args) throws FileNotFoundException {
		test3();
		
	}
	
	public static void test1() throws FileNotFoundException {
		InputStream is = new BufferedInputStream(new FileInputStream(new File("t2.txt")));
		Scanner sc = new Scanner(is);
		
		while(sc.hasNextInt()) {
			System.out.println(sc.nextInt());
		}
		
		CloseStream.close(is);
	}
	
	public static void test2() throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入:");
		String str = scanner.nextLine();
		System.out.println(str);
		
	}
	
	public static void test3() throws FileNotFoundException {
		System.out.println("请输入:");
		
		PrintStream ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("t3.txt",true)),true);
		System.setOut(ps);
		Scanner scanner = new Scanner(System.in);
		
		String str = scanner.nextLine();
		System.out.println(str);
		CloseStream.close(ps);
		
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("我又回来了");
	}

}
