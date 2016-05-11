package com.yinnut.collection;

import java.util.Date;

public class StudentHashcode {
	
	private Integer id;
	private String name;
	private Date birthday;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentHashcode other = (StudentHashcode) obj;
		if (id != other.id)
			return false;
		return true;
	}


	public static void main(String[] args) {
		

	}

}
