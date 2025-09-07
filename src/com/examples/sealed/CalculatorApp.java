package com.examples.sealed;

public class CalculatorApp {
	public static void main(String[] args) {
		Calculator add = new Addition();
		Calculator sub = new Subtraction();
		Calculator advSub = new AdvancedSubtraction();
		Calculator mul = new Multiplication();

		System.out.println("Addition: " + add.calculate(10, 5));
		System.out.println("Subtraction: " + sub.calculate(10, 5));
		System.out.println("Advanced Subtraction (absolute): " + advSub.calculate(5, 10));
		System.out.println("Multiplication: " + mul.calculate(10, 5));
	}
}