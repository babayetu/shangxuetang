package com.yinnut.generic;

import java.lang.instrument.IllegalClassFormatException;

public class StudentApp {
	public static void main(String[] args) throws IllegalClassFormatException {
		Student s = new Student();
		s.setJavase(100);
		s.setOracle(90);
		
		Integer javase = (Integer)s.getJavase();
		
		System.out.println("javase:"+javase);
		
		if (s.getOracle() instanceof String) {
			String oracle = (String)s.getOracle();
			System.out.println("oracle:"+oracle);
		} else {
			throw new IllegalClassFormatException();
		}

		
	}
}
