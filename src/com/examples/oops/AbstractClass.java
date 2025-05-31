package com.examples.oops;

//Abstract class
abstract class SuperClass {

	public SuperClass()
	{
		System.out.println("SuperClass constructor called !!!");
	}

	// Abstract method (does not have a body)
	public abstract void sound();

	// Regular method
	public void eat() {
		System.out.println("This animal is eating.");
	}
}

//Subclass (inheriting from Animal)
class BaseClass1 extends SuperClass {
	// Providing implementation for the abstract method
	@Override
	public void sound() {
		System.out.println("The dog barks");
	}
}

//Subclass (inheriting from Animal)
class BaseClass2 extends SuperClass {
	// Providing implementation for the abstract method
	@Override
	public void sound() {
		System.out.println("The cat meows");
	}
}

class AbstractClass {
	public static void main(String[] args) {
		BaseClass1 dog = new BaseClass1();
		dog.sound();  // The dog barks
		dog.eat();    // This animal is eating.

		BaseClass2 cat = new BaseClass2();
		cat.sound();  // The cat meows
		cat.eat();    // This animal is eating.
	}
}