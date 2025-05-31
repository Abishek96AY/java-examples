package com.examples.interfaceex;

@FunctionalInterface
public interface FunctionalInterfaceEx1
{
	void run(String a);

	// default method
	default void defaultMethod() {
		System.out.println("This is a default method");
	}

	// static method
	static void staticMethod() {
		System.out.println("This is a static method");
	}
}