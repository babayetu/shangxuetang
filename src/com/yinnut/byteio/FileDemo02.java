package com.yinnut.byteio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileDemo02 {

	public static void main(String[] args) {
		OutputStream os = null;
		try {
			//1. 建立联系
			File file = new File("ta.txt");
			//2. 选择输出流，以追加形式写入文件
			os = new FileOutputStream(file,true);
			//3. 操作
			String content = "我是一个赚钱机器\n那就努力赚钱吧";
			//字符串转字节数组byte[]
			os.write(content.getBytes());			
			//4. 关闭输出流
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件未找到");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
