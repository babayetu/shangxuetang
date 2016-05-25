package com.yinnut.io.pattern;
/**
 * 演示装饰者模式
 * @author liujingjing
 *
 */
public class Voice {
	private int volumn = 10;
	
	
	public Voice() {
	}

	public Voice(int volumn) {
		this.volumn = volumn;
	}

	public int getVolumn() {
		return volumn;
	}

	public void setVolumn(int volumn) {
		this.volumn = volumn;
	}

	public void say() {
		System.out.println(volumn);
	}
	
}
