package com.yinnut.io.randomfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.yinnut.io.util.CloseStream;

public class RandomDemo01 {

	public static void main(String[] args) {
		RandomAccessFile ra = null;
		try {
			ra = new RandomAccessFile("t3.txt", "rw");
			ra.seek(10);
			
			//定义缓存大小
			byte[] car = new byte[1024];
			int len = 0;
			while ((len=ra.read(car)) != -1) {
				System.out.println(new String(car,0,len));
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseStream.close(ra);
		}

	}

}
