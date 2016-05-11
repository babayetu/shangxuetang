package com.yinnut.thread;

public class ProgrammerApp {

	public static void main(String[] args) {
		Runnable programmer = new Programmer();
		new Thread(programmer).start();
	}

}
