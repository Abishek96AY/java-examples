package com.examples.problems.string;

public class StringContainsNumeric {
	public static void main(String[] args) {
		String input1 = "Hello123";
		String input2 = "HelloWorld";

		withOutStream(input1); // true
		withOutStream(input2); // false

		withStream(input1); // true
		withStream(input2); // false
	}

	static void withOutStream(String input) {
		boolean containsDigit = false;
		for (char c : input.toCharArray()) {
			if (Character.isDigit(c)) {
				containsDigit = true;
				break;
			}
		}
		System.out.println("withOutStream(" + input + "): " + containsDigit);
	}

	static void withStream(String input) {
		boolean containsDigit = input.chars().anyMatch(Character::isDigit);
		System.out.println("withStream(" + input + "): " + containsDigit);
	}
}