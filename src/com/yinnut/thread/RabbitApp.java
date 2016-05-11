package com.yinnut.thread;

public class RabbitApp {

	public static void main(String[] args) {
		Rabbit rabbit = new Rabbit();
		rabbit.start();
		
		Tortoise tortoise = new Tortoise();
		tortoise.start();
	}

}
