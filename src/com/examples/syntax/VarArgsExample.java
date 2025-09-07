package com.examples.syntax;

public class VarArgsExample {
	// Method using varargs
	public static int sum(int... numbers) {
		int total = 0;
		for (int num : numbers) {
			total += num;
		}
		return total;
	}

	public static void main(String[] args) {
		System.out.println("Sum of 10, 20 = " + sum(10, 20));
		System.out.println("Sum of 1, 2, 3 = " + sum(1, 2, 3));
		System.out.println("Sum of 5, 10, 15, 20, 25 = " + sum(5, 10, 15, 20, 25));
		System.out.println("Sum with no args = " + sum()); // works, result = 0
	}
}