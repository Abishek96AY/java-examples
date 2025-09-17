package com.examples.problems.string;

public class StringContainsNumericOrLetters {
	public static void main(String[] args) {
		String input1 = "Hello123";
		String input2 = "12345";
		String input3 = "Hello";
		String input4 = "@#$%^";

		withOutStream(input1);
		withOutStream(input2);
		withOutStream(input3);
		withOutStream(input4);

		withStream(input1);
		withStream(input2);
		withStream(input3);
		withStream(input4);
	}

	// Without Stream
	static void withOutStream(String input) {
		boolean containsLetter = false;
		boolean containsDigit = false;

		for (char c : input.toCharArray()) {
			if (Character.isLetter(c)) {
				containsLetter = true;
			} else if (Character.isDigit(c)) {
				containsDigit = true;
			}
			if (containsLetter && containsDigit)
				break; // early exit
		}

		System.out.println("withOutStream(" + input + "): letters=" + containsLetter + ", digits=" + containsDigit);
	}

	// With Stream
	static void withStream(String input) {
		boolean containsLetter = input.chars().anyMatch(Character::isLetter);
		boolean containsDigit = input.chars().anyMatch(Character::isDigit);

		System.out.println("withStream(" + input + "): letters=" + containsLetter + ", digits=" + containsDigit);
	}
}