package com.comercial.easyrules.shop;

public class Person {
	private String name;
	private int age;
	private boolean adult;

	// getters and setters omitted
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	public Person() {
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	public Person(String name, int age, boolean adult) {
		super();
		this.name = name;
		this.age = age;
		this.adult = adult;
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	

}