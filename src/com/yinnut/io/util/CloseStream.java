package com.yinnut.io.util;

import java.io.Closeable;
import java.io.IOException;

public class CloseStream {

	public static void main(String[] args) {

	}
	
	/**
	 * 工具类 关闭流
	 * 可变参数 ... 只能放在最后一个位置
	 */
	public static void close(Closeable ... io) {
		for (Closeable closeable : io) {
			if (closeable != null) {
				try {
					closeable.close();
				} catch (IOException e) {
					System.out.println("关闭失败");
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 使用泛型方法
	 * @param io
	 */
	public static <T extends Closeable> void close2(T... io) {
		for (T closeable : io) {
			if (closeable != null) {
				try {
					closeable.close();
				} catch (IOException e) {
					System.out.println("关闭失败");
					e.printStackTrace();
				}
			}
		}
	}
	
}
