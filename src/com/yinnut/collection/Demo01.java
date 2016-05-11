package com.yinnut.collection;

import java.util.ArrayList;

public class Demo01 {
	public static void main(String[] args) {
		ArrayList arrayList1 = new ArrayList();
		arrayList1.add("aaa");
		arrayList1.add("bbb");
		System.out.println(arrayList1.size());
		
		ArrayList arrayList2 = new ArrayList();
		arrayList2.add("ccc");
		arrayList2.add("ddd");
		
		arrayList1.add(arrayList1);
		
		System.out.println(arrayList1.size());
		
		new String("bbb");
	}
	
}
