package com.yinnut.collection;

import java.util.LinkedList;


public class SxtMap002 {
	LinkedList[] arr = new LinkedList[99];
	int size;
	
	public void put(Object key, Object value) {
		int a = key.hashCode() % arr.length;
		
		Entry e = new Entry(key, value);
		
		if (arr[a] != null) {
			for (Object o: arr[a]) {
				Entry ee = (Entry)o;
				if (ee.getKey().equals(key)) {
					ee.setValue(value);
					return;
				}
			}
			arr[a].add(e);
		} else {
			arr[a] = new LinkedList();
			arr[a].add(e);
		}
		
	}
	
	public Object get(Object key) {
		int a = key.hashCode() % arr.length;
		
		if (arr[a] == null) {
			return null;
		}
		
		for (Object e : arr[a]) {
			Entry ee = (Entry)e;
			if (ee.getKey().equals(key)) {
				return ee.getValue();
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		SxtMap002 sxtMap002 = new SxtMap002();
		
		for (int i = 0; i < 10000; i++) {
			sxtMap002.put(i, i + 12);
			
		}
		
		for (int i = 0; i < sxtMap002.arr.length; i++) {
			if (sxtMap002.arr[i] != null) {
				System.out.println(i+"--->"+sxtMap002.arr[i].size());
			}
		}
		
		System.out.println(sxtMap002.get("9999"));
		
		sxtMap002.put(9999, 123456);
		
		System.out.println(sxtMap002.get(9999));
	}

}
