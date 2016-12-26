package netty.authority;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class Ch6P2UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Ch6P2UserInfo buidlUserName(String name) {
		this.name = name;
		return this;
	}

	public Ch6P2UserInfo buidlUserAge(int age) {
		this.age = age;
		return this;
	}
	
	public byte[] codeC(ByteBuffer buffer) {
		buffer.clear();
		byte[] value = this.name.getBytes();
		buffer.putInt(value.length);
		buffer.put(value);
		buffer.putInt(this.age);
		buffer.flip();
		value = null;
		byte[] result = new byte[buffer.remaining()];
		buffer.get(result);
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		Ch6P2UserInfo info = new Ch6P2UserInfo();
		info.buidlUserAge(20).buidlUserName("Welcome to Netty");
		int loop = 1000000;
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < loop; i++) {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(info);
			oos.flush();
			oos.close();
			byte[] byteArray = baos.toByteArray();
			baos.close();
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("jdk serialization took " + (endTime - startTime) + " ms");
		
		System.out.println("---------------------");
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		startTime = System.currentTimeMillis();
		
		for (int i = 0; i < loop; i++) {
			byte[] b = info.codeC(buffer);
		}

		endTime = System.currentTimeMillis();
		
		System.out.println("the byte array serialization took " + (endTime - startTime) + " ms");
	}
}
