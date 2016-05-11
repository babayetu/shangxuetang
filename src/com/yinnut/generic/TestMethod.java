package com.yinnut.generic;

import java.io.Closeable;
import java.io.IOException;

public class TestMethod {

	public static void main(String[] args) {
		test(new employee("高圆圆",28));

	}
	//泛型方法
	public static <T> void test(T a) {
		System.out.println(a);
	}
	
	public static <T extends Closeable> void test(T... a) throws IOException {
		for (T t : a) {
			t.close();
		}
	}
}

class employee {
	private String nameString;
	private int age;
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public employee(String nameString, int age) {
		this.nameString = nameString;
		this.age = age;
	}
	public String toString() {
		return "employee [nameString=" + nameString + ", age=" + age + "]";
	}
	
	
}