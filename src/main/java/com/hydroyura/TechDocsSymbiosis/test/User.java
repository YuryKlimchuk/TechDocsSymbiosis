package com.hydroyura.TechDocsSymbiosis.test;

public class User {
	
	
	private String name, surname;
	private int age;
	
	
	public User() {
		System.out.println("Contructor.User()");
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}


	public String getSurname() {
		return surname;
	}


	public int getAge() {
		return age;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
	

}
