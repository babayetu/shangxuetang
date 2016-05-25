package com.yinnut.otherstream;

import java.io.Serializable;

public class Employee implements Serializable{
	private transient String name;
	private long salary;
	
	public Employee(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String toString() {
		return "Employee [salary=" + salary + "]";
	}
	
}
