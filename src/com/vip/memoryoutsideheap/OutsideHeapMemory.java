package com.vip.memoryoutsideheap;

import java.nio.ByteBuffer;

public class OutsideHeapMemory {
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
		buffer.putChar('a');
		System.out.println(buffer);
		buffer.putChar('c');
		System.out.println(buffer);
		buffer.putInt(10);
		System.out.println(buffer);
	}
}
