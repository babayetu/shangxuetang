package com.yinnut.byteio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
	public static void copyFile(String src, String dest) throws IOException {		
		copyFile(new File(src),new File(dest));
	}
	
	/**
	 * 
	 * @param srcFile  源文件
	 * @param destFile 目的文件
	 * @throws IOException
	 */
	public static void copyFile(File srcFile, File destFile) throws IOException {
		
		if (! srcFile.isFile()) {
			System.out.println("源文件不是文件");
			return;
		}
		
		InputStream is = null;
		OutputStream os = null;

		is = new BufferedInputStream(new FileInputStream(srcFile));
		os = new BufferedOutputStream(new FileOutputStream(destFile));
		int len = 0;
		byte[] car = new byte[1024];
		while ((len = is.read(car)) != -1) {
			os.write(car, 0, len);
		}
		os.flush();
		os.close();
		is.close();
	}
	
	/**
	 * 
	 * @param src  源文件String
	 * @param dest 目标文件String
	 * @throws IOException
	 */
	public static void copyDir(String src, String dest) throws IOException {
		copyDir(new File(src),new File(dest));
	}
	/**
	 * 
	 * @param src  源File对象
	 * @param dest 目标 File对象
	 * @throws IOException
	 */
	public static void copyDir(File src, File dest) throws IOException {
		if (src.isDirectory()) {
			dest = new File(dest,src.getName());
		}
		copyDirDetails(src,dest);
	}
	/**
	 * 
	 * @param src   源dir
	 * @param dest  目的dir
	 * @throws IOException 
	 */
	private static void copyDirDetails(File src, File dest) throws IOException {
		if (src.isFile()) {
			FileUtil.copyFile(src, dest);
			return;
		} else {
			dest.mkdirs();
			File[] listFiles = src.listFiles();
			for (File eachFile : listFiles) {
				File newDest = new File(dest, eachFile.getName());
				copyDirDetails(eachFile,newDest);
			}
		}
	}
}
