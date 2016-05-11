package com.yinnut.syn;

public class SynDemo02 {
	public static void main(String[] args) {
		JvmThread jvm1 = new JvmThread(100);
		JvmThread jvm2 = new JvmThread(500);
		JvmThread jvm3 = new JvmThread(800);
		
		jvm1.start();
		jvm2.start();
		jvm3.start();
	}
}

class JvmThread extends Thread {
	private long time;
	
	public JvmThread(long time) {
		this.time = time;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + "--->创建" + Jvm.getInstance4(time));
	}
}

class Jvm {
	private static Jvm instance = null;
	
	private Jvm() {
		
	}

	public static Jvm getInstance4(long time) {
		if (instance == null) {
			//a b 等
			synchronized (Jvm.class) {
				if (instance == null) {
					try {
						Thread.sleep(time);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					instance = new Jvm();
				}
			}
		}
			
		return instance;
	}
	
	public static Jvm getInstance3(long time) {
		synchronized (Jvm.class) {
			if (instance == null) {
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				instance = new Jvm();
			}
			
			return instance;
		}
	}
	
	public static synchronized Jvm getInstance2(long time) {
		if (instance == null) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
		
		return instance;
	}
	
	public static Jvm getInstance1(long time) {
		if (instance == null) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
		
		return instance;
	}
}