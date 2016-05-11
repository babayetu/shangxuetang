package com.yinnut.collection;

import java.util.HashMap;

public class SxtHashSet {
	private HashMap hm = new HashMap();
	private static final Object PRESENT = new Object();
	
	public void add(Object value) {
		hm.put(value, PRESENT);
	}
	
	public void remove(Object value) {
		hm.remove(value);
	}
	
	public boolean contains(Object value) {
		return hm.containsKey(value);
	}
	
	public int size() {
		return hm.size();
	}
	
	public static void main(String[] args) {
		SxtHashSet sxtHashSet = new SxtHashSet();
		sxtHashSet.add("aaa");
		sxtHashSet.add("bbb");
		System.out.println(sxtHashSet.size());
		System.out.println(sxtHashSet.contains("bbb"));
	}

}
