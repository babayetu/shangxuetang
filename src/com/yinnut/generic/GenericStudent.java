package com.yinnut.generic;

public class GenericStudent<T1,T2> {
	private T1 javase;
	private T2 oracle;
	
	
	public T1 getJavase() {
		return javase;
	}


	public void setJavase(T1 javase) {
		this.javase = javase;
	}


	public T2 getOracle() {
		return oracle;
	}


	public void setOracle(T2 oracle) {
		this.oracle = oracle;
	}
	
	public static void test1(GenericStudent<Object, Object> gs) {
		
	}

	public static void test2(GenericStudent<?, ?> gs) {
		
	}
	
	public static void main(String[] args) {
		GenericStudent<String, Integer> genericStudent = new GenericStudent<String, Integer>();
		GenericStudent genericStudent2 = new GenericStudent();
		
		genericStudent.setJavase("优秀");
		genericStudent.setOracle(new Integer(100));
		
		Integer aaa = genericStudent.getOracle();
		System.out.println(aaa);
		
//		test1(genericStudent);
		test2(genericStudent);
		test1(genericStudent2);
		test2(genericStudent2);
		
	}
}
