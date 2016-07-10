package com.vip.oomtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class HeapOOM {

	public static void main(String agrs[]) throws InterruptedException {

		Random random = new Random();

		List<Integer> list = new ArrayList<Integer>();

		Thread.sleep(20000);

//		while (true) {
//
//			int sleepTime = 100;
//
//			list.add(new StartObject().work(sleepTime));
//
//		}
		
		for (int i = 0; i < 10; i++) {
			Runnable programmer = new Programmer();
			new Thread(programmer).start();
			Thread.sleep(1000);
			
		}
		

	}

}

class Programmer implements Runnable {

	public void run() {
		System.out.println("hello world");
		
	}

}