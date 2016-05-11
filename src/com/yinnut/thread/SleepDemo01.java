package com.yinnut.thread;


public class SleepDemo01 implements Runnable {
	public static void main(String[] args) {
		SleepDemo01 sleepDemo01 = new SleepDemo01();
		new Thread(sleepDemo01).start();
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
