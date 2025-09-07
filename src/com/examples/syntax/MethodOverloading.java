package com.examples.syntax;

class MathOperations {
	int add(int a, int b) {
		return a + b;
	}

	double add(double a, double b) {
		return a + b;
	}
}

public class MethodOverloading {
	public static void main(String[] args) {
		MathOperations math = new MathOperations();
		System.out.println(math.add(5, 3)); // Output will be 8 (int version of add method)
		System.out.println(math.add(2.5, 3.5)); // Output will be 6.0 (double version of add method)
	}
}