package com.yinnut.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Race tortoise = new Race("老不死",1000);
		Race rabbit = new Race("小兔子",300);
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		Future<Integer> result1 = es.submit(tortoise);
		Future<Integer> result2 = es.submit(rabbit);
		
		Thread.sleep(2000);
		
		tortoise.setFlag(false);
		rabbit.setFlag(false);
		
		Integer integer = result1.get();
		Integer integer2 = result2.get();
		
		System.out.println("乌龟走了" + integer);
		System.out.println("兔子走了" + integer2);
		
		es.shutdownNow();
	}

}

class Race implements Callable<Integer> {
	private String name;
	private int time;
	private boolean flag = true;
	private int step = 0;

	public Race() {
	}

	public Race(String name, int time) {
		this.name = name;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public Integer call() throws Exception {
		while (flag) {
			Thread.sleep(time);
			step++;
		}
		return step;
	}
	
}