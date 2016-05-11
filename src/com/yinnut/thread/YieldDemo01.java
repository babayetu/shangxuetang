package com.yinnut.thread;

public class YieldDemo01 extends Thread {
	public static void main(String[] args) throws InterruptedException {
		YieldDemo01 yieldDemo01 = new YieldDemo01();  //新生
		Thread thread = new Thread(yieldDemo01);
		thread.start();	//就绪
		
		for (int i = 0; i < 1000; i++) {
			if (i % 20 == 0) {
				Thread.yield();
			}
			System.out.println("main..."+i);
		}
	}
	
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("yield..."+i);
			
		}
	}
}
