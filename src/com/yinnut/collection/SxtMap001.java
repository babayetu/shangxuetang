package com.yinnut.collection;


public class SxtMap001 {
	
	Entry[] arr = new Entry[100];
	
	public Object get(Object key) {
		int keyHash = key.hashCode() % 100;
		
		Entry cursor = arr[keyHash];
		
		while (cursor != null) {
			if (cursor.getKey().equals(key)) {
				return cursor.getValue();
			}
			
			cursor = cursor.getNext();
		}
		
		return null;
	}
	
	public void put(Object key, Object value) {
		int keyHash = key.hashCode() % 100;
		
		Entry newFirst = new Entry(key, value);
		
		if (arr[keyHash] != null) {			
			Entry cursor = arr[keyHash];
			while (cursor != null) {
				if (cursor.getKey().equals(key)) {
					cursor.setValue(value);
					break;
				}
				
				cursor = cursor.getNext();
			}
			
			if (cursor == null) {
				newFirst.setNext(arr[keyHash]);
				arr[keyHash] = newFirst;
			}
		} else {
			arr[keyHash] = newFirst;
		}
	}	
	
	public boolean containsKey(Object key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null ) {
				if (arr[i].getKey().equals(key)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean containsValue(Object value) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null ) {
				if (arr[i].getValue().equals(value)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		SxtMap001 sxtMap001 = new SxtMap001();
		
		sxtMap001.put("aa", new Wife("bb"));
		sxtMap001.put("cc", new Wife("dd"));
		
		Wife w = (Wife) sxtMap001.get("aa");
		
		System.out.println(w.name);
		
		sxtMap001.put("aa", new Wife("dd"));
		
		w = (Wife) sxtMap001.get("aa");
		
		System.out.println(w.name);
		
		System.out.println(sxtMap001.containsKey("aa"));
		
		System.out.println(sxtMap001.containsValue("bb"));
	}
}

class Wife {
	String name;

	public Wife(String name) {
		this.name = name;
	}
	
	
}
