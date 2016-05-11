package com.yinnut.thread;

public class InfoDemo02 {

	public static void main(String[] args) throws InterruptedException {
		MyThread mt1 = new MyThread();
		Thread proxy1 = new Thread(mt1,"挨踢1");
		proxy1.setPriority(10);
		
		MyThread mt2 = new MyThread();
		Thread proxy2 = new Thread(mt2,"挨踢2");
		proxy2.setPriority(1);
		
		proxy1.start();
		proxy2.start();
		
		Thread.sleep(100);
		
		mt1.stop();
		mt2.stop();
		
	}

}
