package com.yinnut.byteio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyDemo {

	public static void main(String[] args) {
		try {
			copyFile("threeBing.html", "aaa.html");
		} catch (IOException e) {
			System.out.println("拷贝失败");
			e.printStackTrace();
		}
	}

	/**
	 * 文件的拷贝
	 * 
	 * @param 源文件路径
	 * @param 目标文件路径
	 * @throws IOException
	 * @return
	 */
	public static void copyFile(String src, String dest) throws IOException {
		
		File srcFile = new File(src);
		File destFile = new File(dest);
		
		if (! srcFile.isFile()) {
			System.out.println(src+" 不是文件");
			return;
		}
		
		InputStream is = null;
		OutputStream os = null;

		is = new FileInputStream(srcFile);
		os = new FileOutputStream(destFile);
		int len = 0;
		byte[] car = new byte[1024];
		while ((len = is.read(car)) != -1) {
			os.write(car, 0, len);
		}
		os.flush();
		os.close();
		is.close();
	}

}
