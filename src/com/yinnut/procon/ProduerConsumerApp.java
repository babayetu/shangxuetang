package com.yinnut.procon;

import java.util.LinkedList;

public class ProduerConsumerApp {

	public static void main(String[] args) {
		Object producerLock = new Object();
		Object consumerLock = new Object();
		LinkedList<Message> lm = new LinkedList<Message>();
		
		Producer producer = new Producer(lm, "producer", producerLock, consumerLock);
		Consumer consumer = new Consumer(lm, "consumer", producerLock, consumerLock);
		
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);
		
		t1.start();
		t2.start();
	}

}
