package com.yinnut.collection;

import java.util.HashSet;
import java.util.Set;

public class TestSet {
	public static void main(String[] args) {
		Set set = new HashSet();
		
		String a = "aaa";
		String b = "bbb";
		String c = new String("aaa");
		System.out.println(a.hashCode());
		System.out.println(c.hashCode());
		set.add(a);
		set.add(b);
		set.add(c);
		System.out.println(set.size());
		System.out.println(set.contains("aaa"));
		set.remove("aaa");
		System.out.println(set.contains("aaa"));
	}
}
