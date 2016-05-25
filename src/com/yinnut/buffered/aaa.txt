package com.yinnut.buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class BufferedFileRead {

	public static void main(String[] args) throws IOException {
		File f = new File("/Users/liujingjing/spring_workspace/Shangxuetang/src/com/yinnut/buffered/BufferedFileRead.java");
		File f2 = new File("/Users/liujingjing/spring_workspace/Shangxuetang/src/com/yinnut/buffered/aaa.txt");
		
		//新增缓冲流放在节点流的前面，类似装饰者模式
		BufferedReader fr = new BufferedReader(new FileReader(f));
		char[] car = new char[1024];
		
		BufferedWriter fw = new BufferedWriter(new FileWriter(f2));

		String line = null;
		//判断条件变了
		while ((line = fr.readLine() ) != null) {
			fw.write(line);
			fw.newLine();  //新增方法
		}
		
		fw.flush();
		fw.close();
		fr.close();
	}

}
