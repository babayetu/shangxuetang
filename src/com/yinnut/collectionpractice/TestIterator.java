package com.yinnut.collectionpractice;

import java.util.HashSet;
import java.util.Iterator;

public class TestIterator {
	public static void main(String[] args) {
		HashSet hashSet = new HashSet();
		
		hashSet.add("aaa");
		hashSet.add("bbb");
		
		Iterator iterator = hashSet.iterator();
		
//		while (iterator.hasNext()) {
//			String s = (String)iterator.next();
//			System.out.println(s);
//		}
		
		for (Object object : hashSet) {
			String s = (String) object;
			System.out.println(s);
		}
	}
}
