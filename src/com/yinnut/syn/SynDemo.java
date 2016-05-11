package com.yinnut.syn;



public class SynDemo {

	public static void main(String[] args) {
		Web12306 web12306 = new Web12306();
		Thread t1 = new Thread(web12306, "路人甲");
		Thread t2 = new Thread(web12306, "黄牛乙");
		Thread t3 = new Thread(web12306, "工程师");
		
		t1.start();
		t2.start();
		t3.start();

	}

}

class Web12306 implements Runnable{
	
	private int num = 10;
	private boolean flag = true;

	public void run() {
		while(flag) {
			try {
				test05();
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	public synchronized void test01() {
		if (num<=0) {
			flag = false;
			return;
		}

		System.out.println(Thread.currentThread().getName() + "抢到了"+num--);
	}
	
	public void test02() {
		if (num<=0) {
			flag = false;
			return;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "抢到了"+num--);
	}
	
	public void test03() {
		synchronized (this) {
			if (num<=0) {
				flag = false;
				return;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "抢到了"+num--);
		}
	}
	
	//锁定范围不正确
	public void test04() {
		//a b c
		synchronized (this) {
			if (num<=0) {
				flag = false;
				return;
			}
		}
		
		//a b
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "抢到了"+num--);
		
	}
	
	//锁定资源不正确
	public void test05() {
		synchronized ((Integer)num) {
			if (num<=0) {
				flag = false;
				return;
			}
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println(Thread.currentThread().getName() + "抢到了"+num--);
		}
	}
}