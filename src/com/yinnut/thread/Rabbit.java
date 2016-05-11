package com.yinnut.thread;

/**
 * 模拟龟兔赛跑
 * @author liujingjing
 *
 */
public class Rabbit extends Thread {
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("兔子跑了"+i+"步");
		}
	}
}

class Tortoise extends Thread {
	public void run() {
		for (int i = 0; i < 400; i++) {
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("乌龟跑了"+i+"步");
		}
	}
}