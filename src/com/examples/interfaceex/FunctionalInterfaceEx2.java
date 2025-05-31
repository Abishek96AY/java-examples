package com.examples.interfaceex;

@FunctionalInterface
public interface FunctionalInterfaceEx2 {
	void regularMethod();

	default void defaultMethod() {
		System.out.println("This is a default method");
	}

	static void staticMethod() {
		System.out.println("This is a static method");
	}
}