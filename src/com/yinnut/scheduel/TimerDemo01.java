package com.yinnut.scheduel;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo01 {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTimerTask(), 0,2000);
	}
}

class MyTimerTask extends TimerTask {
	private int count = 0;
	
	@Override
	public void run() {
		System.out.println(count++);
		
	}
	
}
