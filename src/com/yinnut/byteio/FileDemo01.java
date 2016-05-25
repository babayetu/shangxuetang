package com.yinnut.byteio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileDemo01 {

	public static void main(String[] args) throws IOException {
		File f = new File("/Users/liujingjing/chinese.txt");
		InputStream fis = new FileInputStream(f);
		
		//缓冲卡车
		byte[] car = new byte[1024];
		//每次读取的长度，除了空文件，每个文件至少读2次，最后一次返回-1
		int len = 0;
		while((len = fis.read(car)) != -1) {
			//把byte[]转成字符串
			System.out.println(new String(car,0,len));
		}
		
		if (null != fis) {
			fis.close();
		}
	}

}
