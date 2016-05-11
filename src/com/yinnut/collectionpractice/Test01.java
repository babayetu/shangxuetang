package com.yinnut.collectionpractice;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Test01 {
	public static void main(String[] args) throws ParseException {
		Employee e1 = new Employee(301L,"高崎",3000L,"尚学堂项目部","2007-10");
		Employee e2 = new Employee(302L,"马士兵",3000L,"尚学堂项目部","2006-10");
		Employee e3 = new Employee(303L,"裴新",3000L,"尚学堂教学部","2007-10");
		
		ArrayList<Employee> arrayList = new ArrayList<Employee>();
		arrayList.add(e1);
		arrayList.add(e2);
		arrayList.add(e3);
		
		Test01.printEmployeeName(arrayList);
	}
	
	public static void printEmployeeName(List employees) {
		for (Object employee : employees) {
			if (employee != null) {
				Employee e = (Employee)employee;
				System.out.println(e.getName());
			}
		}
	}
}
