package com.yinnut.otherstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ObjectDemo01 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String filePath = "2.temp";
		serialize(filePath);
		deserialize(filePath);
	}
	
	public static void serialize(String dest) throws IOException{
		Employee em1 = new Employee("张三", 10000);
		Employee em2 = new Employee("张李四", 20000);
		int[] arr = {1,2,3,4,5,6};
		
		ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(
				new FileOutputStream(new File(dest))
				)
				);
		oos.writeObject(em1);
		oos.writeObject(em2);
		oos.writeObject(arr);
		oos.flush();
		oos.close();
	}
	
	public static void deserialize(String src) throws IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(
				new FileInputStream(new File(src))
				)
				);
		Employee em1 = (Employee)ois.readObject();
		Employee em2 = (Employee)ois.readObject();
		
		System.out.println(em1);
		System.out.println(em2);
		
		int[] arr = (int[]) ois.readObject();
		System.out.println(Arrays.toString(arr));
		
		ois.close();
	}
}
