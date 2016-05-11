package com.yinnut.thread;

public class SleepDemo02 implements Runnable {
	private int num = 50;
	
	public static void main(String[] args) {
		SleepDemo02 web12306 = new SleepDemo02();
		Thread t1 = new Thread(web12306, "路人甲");
		Thread t2 = new Thread(web12306, "黄牛乙");
		Thread t3 = new Thread(web12306, "工程师");
		
		t1.start();
		t2.start();
		t3.start();
	}

	public void run() {
		while(true) {
			if (num<=0) {
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() + "抢到了"+num--);
		}		
	}
}
