package com.yinnut.io.file;

import java.io.File;
import java.io.FilenameFilter;

public class Demo03 {
	public static void main(String[] args) {
		String path = "/Users/liujingjing/aaaa";
		File file = new File(path);
//		boolean result = file.mkdir();
//		System.out.println(result);
		if (file.isDirectory()) {
			String[] list = file.list();
			for (String each_item : list) {
				System.out.println(each_item);
			}
			
			System.out.println("-----目录或文件绝对路径-----");
			File[] listFiles = file.listFiles();
			for (int i = 0; i < listFiles.length; i++) {
				System.out.println(listFiles[i].getAbsolutePath());
			}
			
			System.out.println("-----javaw文件-----");
			listFiles = file.listFiles(new FilenameFilter() {				
				public boolean accept(File dir, String name) {
					System.out.println(dir.getName());
					
					return new File(dir,name).isFile() && name.endsWith("java");
				}
			});
			for (int i = 0; i < listFiles.length; i++) {
				System.out.println(listFiles[i].getAbsolutePath());
			}
		}

	}
}
