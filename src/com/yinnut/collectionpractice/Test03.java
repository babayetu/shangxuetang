package com.yinnut.collectionpractice;

import java.util.HashMap;
import java.util.Set;

public class Test03 {

	public static void main(String[] args) {
		HashMap hashMap = new HashMap();
		
		hashMap.put("1", "aaa");
		hashMap.put("2", "bbb");
		hashMap.put("3", "ccc");
		
		Set keySet = hashMap.keySet();
		
		for (Object o : keySet) {
			System.out.println(hashMap.get(o));
		}
	}

}
