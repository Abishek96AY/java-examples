package com.examples.problems.string;

public class CountDigitsInString {

	public static void main(String[] args) {
		String input = "abc123xyz45";

		withOutStream(input);
		withStream(input);
	}

	// Without Stream
	static void withOutStream(String input) {
		int count = 0;
		for (char c : input.toCharArray()) {
			if (Character.isDigit(c)) {
				count++;
			}
		}
		System.out.println("withOutStream() → Digits count = " + count);
	}

	// With Stream
	static void withStream(String input) {
		long count = input.chars().filter(Character::isDigit).count();
		System.out.println("withStream() → Digits count = " + count);
	}
}