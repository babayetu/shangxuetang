package com.yinnut.procon;

/**
 * 生产者
 * @author liujingjing
 *
 */
public class Player implements Runnable {
	private Movie iMovie;
	
	
	public Player(Movie iMovie) {
		this.iMovie = iMovie;
	}


	public void run() {
		for (int i = 0; i < 20; i++) {
			if (i%2 == 0) {
				iMovie.play("左青龙");
			} else {
				iMovie.play("右白虎");
			}
			
		}
	}
	
}
