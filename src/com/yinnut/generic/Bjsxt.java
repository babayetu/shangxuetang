package com.yinnut.generic;

public class Bjsxt<T> {
	T stu;
	
	public static void main(String[] args) {
		Bjsxt<GenericStudent<String, Integer>> bj = new Bjsxt<GenericStudent<String, Integer>>();
		bj.stu = new GenericStudent<String, Integer>();
		GenericStudent<String, Integer>  student = bj.stu;
		System.out.println(student.getJavase());

	}

}
