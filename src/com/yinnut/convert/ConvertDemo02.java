package com.yinnut.convert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ConvertDemo02 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(//缓冲流
					new InputStreamReader( //解码流
					new FileInputStream( //字节流 - 文件
					new File("/Users/liujingjing/spring_workspace/Shangxuetang/src/com/yinnut/convert/ConvertDemo01.java"))
					,"utf-8") // 解码字符集
				);
		
		BufferedWriter bw = new BufferedWriter( //缓冲流
				new OutputStreamWriter( //编码流
				new FileOutputStream( //字节流 - 文件
				new File("/Users/liujingjing/ccc.java")
				),"utf-8")  // 编码字符集
				);
		
		String eachLine = null;
		while (null != (eachLine=br.readLine())){
			bw.write(eachLine);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
