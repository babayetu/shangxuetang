package com.yinnut.collectionpractice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
	private long id;
	private String name;
	private long salary;
	private String company;
	private Date hired;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getHired() {
		return hired;
	}
	public void setHired(Date hired) {
		this.hired = hired;
	}
	public Employee(long id, String name, long salary, String company,
			String hired) throws ParseException {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.company = company;
		
		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
		this.setHired(simpleDateFormat.parse(hired));
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", company=" + company + ", hired=" + hired + "]";
	}
	
	
}
