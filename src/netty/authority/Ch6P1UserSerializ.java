package netty.authority;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class Ch6P1UserSerializ implements Serializable{

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
	
	public Ch6P1UserSerializ buidlUserName(String name) {
		this.name = name;
		return this;
	}

	public Ch6P1UserSerializ buidlUserAge(int age) {
		this.age = age;
		return this;
	}
	
	public byte[] codeC() {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		byte[] value = this.name.getBytes();
		buffer.putInt(value.length);
		buffer.put(value);
		buffer.putInt(age);
		buffer.flip();
		value = null;
		byte[] result = new byte[buffer.remaining()];
		buffer.get(result);
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		Ch6P1UserSerializ info = new Ch6P1UserSerializ();
		info.buidlUserAge(10).buidlUserName("lele");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(info);
		oos.flush();
		oos.close();
		
		byte[] b = baos.toByteArray();
		System.out.println("jdk serialization length is:" + b.length);
		baos.close();
		System.out.println("byte serialization length is:" + info.codeC().length);
	}
}

