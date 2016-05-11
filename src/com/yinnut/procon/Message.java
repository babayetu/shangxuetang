package com.yinnut.procon;

public class Message {
	private String name;
	
	
	public Message(String name) {
		this.name = name;
	}


	public String toString() {
		return "Message [name=" + name + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
}
