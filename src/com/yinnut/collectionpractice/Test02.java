package com.yinnut.collectionpractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test02 {
	public static void main(String[] args) {
		Map map1 = new HashMap();
		map1.put("name", "高崎");
		map1.put("age", 30);
		
		Map map2 = new HashMap();
		map2.put("name", "马士兵");
		map2.put("age", 35);
		
		List  al = new ArrayList<Map>();
		al.add(map1);
		al.add(map2);
		
		for (Object employee : al) {
			if (employee != null) {
				Map e = (Map)employee;
				System.out.println(e.get("name"));
			}
		}

	}
}
