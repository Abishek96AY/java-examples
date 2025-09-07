package com.examples.problems.string;

public class SwapStrings {

	static String a = "Abi", b = "shek", temp = "";

	static void method1() {
		temp = b;
		b = a;
		a = temp;

		System.out.println("A :: " + a + ", B :: " + b);
	}

	static void method2() {
		a = a + b; // Step 1: concatenate a and b
		int len = a.length() - b.length();
		System.out.println("a : " + a.length() + ", b : " + b.length() + ", len : " + len);
		b = a.substring(0, len); // Step 2: assign b the value of the original a
		a = a.substring(b.length()); // Step 3: assign a the value of the original b

		System.out.println("A :: " + a + ", B :: " + b);
	}

	public static void main(String[] args) {
		method2();
	}
}