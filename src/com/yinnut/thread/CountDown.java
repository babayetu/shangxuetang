package com.yinnut.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CountDown {

	public static void main(String[] args) throws InterruptedException {
		Date endTimeDate = new Date(System.currentTimeMillis() + 10000);
		long end = endTimeDate.getTime();
		
		while (true) {
			endTimeDate = new Date(endTimeDate.getTime() - 1000);
			
			System.out.println(new SimpleDateFormat("mm:ss").format(endTimeDate));
			Thread.sleep(1000);
			if (end - endTimeDate.getTime() > 10000) {
				break;
			}
		}

	}

}
