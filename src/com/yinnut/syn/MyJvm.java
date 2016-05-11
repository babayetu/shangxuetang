package com.yinnut.syn;

/**
 * 懒汉式
 * 1. 私有构造器
 * 2. 私有静态变量
 * 3. 提供公共方法访问静态变量
 * 
 * @author liujingjing
 *
 */
public class MyJvm {
	private static MyJvm instance;
	private MyJvm() {
		
	}
	
	public MyJvm getInstance() {
		if (instance == null) {  //为了提高效率
			synchronized (MyJvm.class) {
				if (instance == null) {   //安全
					instance = new MyJvm();
				}				
			}
		}
		
		return instance;
	}
}

/**
 * 饿汉式
 * 1. 私有构造器
 * 2. 私有静态变量，类加载时创建。就是该类的任何函数被调用时,比如getInstance或其他
 * 3. 提供公共方法访问静态变量
 * 
 */

class MyJvm2 {
	private static MyJvm2 instance = new MyJvm2();
	private MyJvm2() {
		
	}
	
	public MyJvm2 getInstance() {
		return instance;
	}
}

/**
 * 饿汉式延迟加载
 * 只有在调用getInstance时，内部类JvmHolder才会被加载，才会实例化instance
 * 和饿汉式不同的是，调用其他函数，不会使得instance被实例化
 * 
 */

class MyJvm3 {
	private static class JvmHolder {
		private static MyJvm3 instance = new MyJvm3();
	}
	
	private MyJvm3() {
		
	}
	
	public MyJvm3 getInstance() {
		return JvmHolder.instance;
	}
	
}
