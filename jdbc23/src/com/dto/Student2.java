package com.dto;

public class Student2 {
	
	private int roll;
	private String  name;
	private String Address;
	public Student2(int roll, String name, String address) {
		super();
		this.roll = roll;
		this.name = name;
		Address = address;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	@Override
	public String toString() {
		return "Student2 [roll=" + roll + ", name=" + name + ", Address=" + Address + "]";
	}
	
	

}
