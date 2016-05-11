package com.yinnut.procon;

public class App {

	public static void main(String[] args) {
		Movie movie = new Movie();
		Thread t1 = new Thread(new Player(movie));
		Thread t2 = new Thread(new Watcher(movie));
		
		t1.start();
		t2.start();
	}

}
