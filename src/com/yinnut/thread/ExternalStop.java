package com.yinnut.thread;


public class ExternalStop {
	public static void main(String[] args) throws InterruptedException {
		Study study = new Study();
		new Thread(study).start();
		
		for (int i = 0; i < 100; i++) {
			Thread.sleep(100);
			if (i == 50) {
				study.stop();
			}
			System.out.println("main---->"+i);
		}
		
	}
	
}

class Study implements Runnable {
	private boolean flag = true;
	
	public void run() {
		while(flag) {
			System.out.println("studying thread...");
		}
	}
	
	public void stop() {
		flag = false;
	}
}
