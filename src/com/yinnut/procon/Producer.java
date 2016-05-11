package com.yinnut.procon;

import java.util.LinkedList;

public class Producer implements Runnable {
	private LinkedList<Message> lm;
	private String name;
	private Object consumerLock;
	private Object producerLock;
	
	public Producer(LinkedList<Message> lm, String name, Object producerLock, Object consumerLock) {
		this.lm = lm;
		this.name = name;
		this.producerLock = producerLock;
		this.consumerLock = consumerLock;
	}


	public void run() {
		while(true) {
			synchronized (consumerLock) {
				synchronized (producerLock) {
					for (int i = 0;i<10;i++) {
						lm.add(new Message(name + ":" + i));
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("生产了"+name+":"+i);
					}

					producerLock.notify();
				}
				
				try {
					consumerLock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}


	}
	
}
