package com.yinnut.byteio;

import java.io.File;
import java.io.IOException;

public class CopyDir {
	
	/**
	 * 隐藏bug，如果dest目的文件夹是src的子文件夹，会无限递归
	 * @param src   源File
	 * @param dest  目的File
	 * @throws IOException 
	 */
	public static void copyDir(File src, File dest) throws IOException {

		if (src.isFile()) {
			FileUtil.copyFile(src, dest);
			return;
		} else {
			dest.mkdirs();
			File[] listFiles = src.listFiles();
			for (File eachFile : listFiles) {
				File newDest = new File(dest, eachFile.getName());
				copyDir(eachFile,newDest);
			}
		}
	}
	
	private static boolean isSubFolder(File src, File dest) {
		if (dest.getAbsolutePath().contains(src.getAbsolutePath())) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		File srcPath = new File("/Users/liujingjing/javatest");
		//bug所在地,destPath是srcPath子文件夹
		File destPath = new File("/Users/liujingjing/javatest/dir1");
		
		//修复思路，模仿windows报出错误
		if (isSubFolder(srcPath,destPath)) {
			throw new IOException("目的文件夹是源文件夹的子文件夹");
		}
				
		copyDir(srcPath,destPath);
	}

}
