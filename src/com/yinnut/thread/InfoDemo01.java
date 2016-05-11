package com.yinnut.thread;

public class InfoDemo01 {

	public static void main(String[] args) throws InterruptedException {
		MyThread myThread = new MyThread();
		Thread proxy = new Thread(myThread);
		proxy.setName("it");
		System.out.println(proxy.getName());
		System.out.println(Thread.currentThread());
		proxy.start();
		
		System.out.println("启动后的状态:"+ proxy.isAlive());
		Thread.sleep(20);
		myThread.stop();
		Thread.sleep(200);
		System.out.println("停止后的状态:"+ proxy.isAlive());
	}

}
