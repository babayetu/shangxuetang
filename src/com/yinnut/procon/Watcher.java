package com.yinnut.procon;

public class Watcher implements Runnable {
	private Movie iMovie;
	
	
	public Watcher(Movie iMovie) {
		this.iMovie = iMovie;
	}


	public void run() {
		for (int i=0;i<20;i++) {
			iMovie.watch();
		}
		
	}

}
