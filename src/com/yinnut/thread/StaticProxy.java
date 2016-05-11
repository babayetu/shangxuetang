package com.yinnut.thread;

public class StaticProxy {
	public static void main(String[] args) {
		Marry you = new You();
		Marry weddingCompany = new WeddingCompany(you);
		weddingCompany.marry();
	}
}

interface Marry {
	void marry();
}

class You implements Marry {

	public void marry() {
	
		System.out.println("you and 高圆圆结婚了");
	}
	
}

class WeddingCompany implements Marry {
	private Marry you;

	public WeddingCompany() {
	}

	public WeddingCompany(Marry you) {
		this.you = you;
	}
	
	private void before() {
		System.out.println("before marry");
	}
	
	private void after() {
		System.out.println("after marry");
	}
	public void marry() {
		before();
		you.marry();
		after();
	}
	
}