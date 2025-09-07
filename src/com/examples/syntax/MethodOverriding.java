package com.examples.syntax;

//Superclass Animal
class Animal {
	void sound() {
		System.out.println("Animal makes a sound");
	}
}

//Subclass Dog
class Dog extends Animal {
	// Method overriding
	void sound() {
		System.out.println("Dog barks");
	}
}

//Subclass Cat
class Cat extends Animal {
	// Method overriding
	void sound() {
		System.out.println("Cat meows");
	}
}

public class MethodOverriding {
	public static void main(String[] args) {
		
		Animal animal1 = new Dog(); // Polymorphic behavior
		Animal animal2 = new Dog(); // Polymorphic behavior
		Animal animal3 = new Animal(); // Polymorphic behavior

		animal1.sound(); // Output will be "Dog barks"
		animal2.sound(); // Output will be "Cat meows"
		animal3.sound(); // Output will be "Animal makes a sound"
	}
}
