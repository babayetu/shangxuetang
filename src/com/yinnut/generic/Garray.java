package com.yinnut.generic;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class Garray {

	public static void main(String[] args) {
		Integer[] i = new Integer[4];
		
//		GenericStudent<String, Integer>[] gs = new GenericStudent<Stirng, Integer>[10];
		GenericStudent<?,?>[] gs = new GenericStudent[10];
		
		MyArrayList<String> mal = new MyArrayList<>();
		mal.add(0, "aaa");
		System.out.println(mal.getOne(0));
	}

}

class MyArrayList<E> {
	Object[] cap = new Object[10];
	
	public void add(int index, E e) {
		cap[index] = e;
	}
	
	@SuppressWarnings("unchecked")
	public E[] getElement() {
		return (E[])cap;
	}
	
	@SuppressWarnings("unchecked")
	public E getOne(int index) {
		return (E)cap[index];
	}
}
