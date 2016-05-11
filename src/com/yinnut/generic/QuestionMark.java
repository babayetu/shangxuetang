package com.yinnut.generic;

public class QuestionMark<T> {
	T score;
	
	public static void main(String[] args) {
		QuestionMark<?> qm = new QuestionMark<String>();
		test(new QuestionMark<Integer>());
		test2(new QuestionMark<Apple>());
		test(qm);
	}
	
	public static void test(QuestionMark<?> qm) {
		
	}
	
	public static void test2(QuestionMark<? extends Fruit> qm) {
		
	}
	
	public static void test3(QuestionMark<? super Fruit> qm) {
		
	}
}
