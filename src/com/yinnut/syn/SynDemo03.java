package com.yinnut.syn;

public class SynDemo03 {

	public static void main(String[] args) {
		Object goods = new Object();
		Object money = new Object();
		Test aaa = new Test(goods,money);
		Thread t1 = new Thread(aaa);
		Test2 bbb = new Test2(goods,money);
		Thread t2 = new Thread(bbb);
		
		t1.start();
		t2.start();
	}

}

class Test implements Runnable {
	Object goods ;
	Object money ;

	public Test(Object goods, Object money) {
		this.goods = goods;
		this.money = money;
	}
	
	public void run() {
		while(true) {
			test();
		}
		
	}
	
	public void test() {
		synchronized (goods) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized (money) {
				
			}
		}
		System.out.println("一手给钱");
	}
}

class Test2 implements Runnable {
	Object goods;
	Object money;
	
	
	public Test2(Object goods, Object money) {
		this.goods = goods;
		this.money = money;
	}

	public void run() {
		while(true) {
			test();
		}
		
	}
	
	public void test() {
		synchronized (money) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized (goods) {
				
			}
		}
		System.out.println("一手给货");
	}
}