package com.yinnut.thread;

public class JoinDemo01 implements Runnable {
	public static void main(String[] args) throws InterruptedException {
		JoinDemo01 joinDemo01 = new JoinDemo01();  //新生
		Thread thread = new Thread(joinDemo01);
		thread.start();
		
		for (int i = 0; i < 1000; i++) {
			if (i == 50) {
				thread.join();
			}
			System.out.println("main..."+i);
		}
		
		
	}
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("joining..."+i);
			
		}
	}
}
