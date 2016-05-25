package com.yinnut.otherstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.yinnut.io.util.CloseStream;

/**
 * 自己封装一个输入来替代Scanner
 * 
 * @author liujingjing
 *
 */
public class BufferedIn {

	public static void main(String[] args) throws IOException {
		test1();

	}
	
	public static void test1() throws IOException {
		InputStream is = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		String temp = null;
		System.out.println("请输入:\n");
		while ( null != (temp = br.readLine())) {
			if (! temp.equals("q")) {
				System.out.println(temp);
			} else {
				break;
			}
			
		}
		
		CloseStream.close(is,br);
	}
}
