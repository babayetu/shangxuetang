package com.yinnut.io.file;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class Demo02 {
	@Test
	public void test1() throws Exception {
		String filePath = "/Users/liujingjing/abcdef.txt";
		File path = new File(filePath);
		
		if (path.exists()) {
			path.delete();
		}
//		try {
//			boolean flag = path.createNewFile();
//			System.out.println(flag ? "成功" : "失败");
//		} catch (IOException e) {
//			// e.printStackTrace();
//			System.out.println("文件创建失败");
//		}
		
//		File temp = File.createTempFile("tes", ".tmp", new File("/Users/liujingjing"));
//		Thread.sleep(5000);
//		temp.deleteOnExit();
		
		File dir = new File("/Users/liujingjing/new_dir/1");
//		dir.mkdirs();
		
		if (dir.isDirectory()) {
			String[] list = dir.list();
			
		}
	}
}
