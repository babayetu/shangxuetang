package com.yinnut.procon;

public class Movie {
	private String pic;
	private boolean flag = true;
	
	public synchronized void play(String pic) {
		if (flag == false) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("生产了:"+pic);
		this.pic = pic;
		this.notify();
		this.flag = false;
	}
	
	public synchronized void watch() {
		if (flag == true) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pic);
		this.notify();
		this.flag = true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
