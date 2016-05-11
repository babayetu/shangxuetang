package com.yinnut.procon;

public class Three1 implements Runnable{
	private String name;
	private Object prevThreadLock;
	private Object myThreadLock;

	public void run() {
		int count = 10;
		synchronized (prevThreadLock) {
			synchronized (myThreadLock) {
				System.out.println("name");
				myThreadLock.notify();
			}
			
			try {
				prevThreadLock.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}

class Three2 implements Runnable {
	private String name;
	private Object prevThreadLock;
	private Object myThreadLock;

	public void run() {

		
	}
	
	
}

class Three3 implements Runnable {
	private String name;
	private Object prevThreadLock;
	private Object myThreadLock;

	public void run() {

		
	}
	
	
}