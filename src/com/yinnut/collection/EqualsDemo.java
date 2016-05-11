package com.yinnut.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class EqualsDemo {
	
	
	public static void main(String[] args) {
		List list = new ArrayList();
		String a = new String("aaa");
		String b = new String("aaa");
		list.add(a);
		list.add(b);
		System.out.println(list.size());
		
		HashMap hm = new HashMap();
		hm.put(a, "AAAA");
		hm.put(b, "BBBBB");
		System.out.println(hm.get(a));
		
	}
}
