package com.yinnut.io.file;

import java.io.File;
import java.util.Arrays;

public class Demo04 {
	public static void main(String[] args) {
		String pathname = "/Users/liujingjing/aaaa";
		File path = new File(pathname);
		File[] listRoots = File.listRoots();
		
		Demo04 demo04 = new Demo04();
		for (File file : listRoots) {
			demo04.printChild(file);
		}
	}
	
	public void printChild(File input) {
		if (input == null || !input.exists()) {
			return;
		}
		
		if (input.isDirectory()) {
			for (File file : input.listFiles()) {
				printChild(file);
			}
		} else {
			if (input.getName().endsWith(".java")) {
				System.out.println(input.getAbsolutePath());
			}
		}
		
	}
}
