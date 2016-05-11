package com.yinnut.procon;

public class ThreeThread implements Runnable {
	private String name;
	private Object prev;
	private Object myself;
	
	
	
	public ThreeThread(String name, Object prev, Object myself) {
		this.name = name;
		this.prev = prev;
		this.myself = myself;
	}
	
	public void run() {
		int count = 10;
		while (count>0) {
			synchronized (prev) {
				synchronized (myself) {
					System.out.println(this.name + ":" + count);
					count--;
					myself.notify();
					System.out.println(Thread.currentThread().getName() + "->"+myself.getClass().getName() + "释放");
				}
				
				try {
					System.out.println(Thread.currentThread().getName() + "->"+"等待"+ prev.getClass().getName());
					prev.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}	



	public static void main(String[] args) throws InterruptedException {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		Thread t1 = new Thread(new ThreeThread("A",c,a));
		Thread t2 = new Thread(new ThreeThread("B",a,b));
		Thread t3 = new Thread(new ThreeThread("C",b,c));
		
		t1.start();
		Thread.sleep(500);
		t2.start();
		Thread.sleep(500);
		t3.start();
		Thread.sleep(500);
	}

}
