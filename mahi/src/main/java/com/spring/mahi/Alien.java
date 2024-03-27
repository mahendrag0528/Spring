package com.spring.mahi;

public class Alien {
	private int age;
	private Laptop laptop;
	
	public Laptop getLap() {
		return laptop;
	}
	public void setLap(Laptop lap) {
		this.laptop = lap;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		System.out.println(1000);
		this.age = age;
	}
	Alien(){
		System.out.println("Alien objext is created");
	}
	public void print() {
		System.out.println("hiii"+" "+age);
		laptop.compile();
	}
}
