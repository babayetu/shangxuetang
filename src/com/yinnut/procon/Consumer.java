package com.yinnut.procon;

import java.util.LinkedList;

public class Consumer implements Runnable{
	private LinkedList<Message> lm;
	private String name;
	private Object consumerLock;
	private Object producerLock;
	
	public Consumer(LinkedList<Message> lm, String name, Object producerLock, Object consumerLock) {
		this.lm = lm;
		this.name = name;
		this.producerLock = producerLock;
		this.consumerLock = consumerLock;
	}


	public void run() {
		while (true) {
			synchronized (producerLock) {
				synchronized (consumerLock) {
					while (lm.size() > 0) {
						Message oneMessage = lm.pop();
						System.out.println(oneMessage.getName()+"被消费了");
					}

					consumerLock.notify();
				}
				
				try {
					producerLock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
