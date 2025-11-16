package com.examples.interfaces;

public class InterfaceImpl implements Interface {

	@Override
	public void eat() {
		System.out.println("Dog is eating.");
	}

	@Override
	public void sleep() {
		System.out.println("Dog is sleeping.");
	}

	@Override
	public void makeSound() {
		System.out.println("Dog is barking.");
	}
	
	public static void main(String[] args) {
		InterfaceImpl myDog = new InterfaceImpl();
		myDog.eat();
		myDog.sleep();
		myDog.makeSound();
	}
}