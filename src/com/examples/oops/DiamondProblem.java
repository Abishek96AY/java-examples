package com.examples.oops;

interface A {
	void display();
}

interface B extends A {
	default void display() {
		System.out.println("B");
	}
}

interface C extends A {
	default void display() {
		System.out.println("C");
	}
}

class D implements B, C {
	@Override
	public void display() {
		// Resolve ambiguity
		B.super.display();
	}
}

public class DiamondProblem {
	public static void main(String[] args) {
		D d = new D();
		d.display(); // This will call the overridden display method in class D
	}
}
