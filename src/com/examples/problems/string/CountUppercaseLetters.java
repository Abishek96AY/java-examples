package com.examples.problems.string;

public class CountUppercaseLetters {
	public static void main(String[] args) {
		String input = "Hello World";

		withOutStream(input);
		withStream(input);
	}

	// --- Without Streams ---
	static void withOutStream(String input) {
		int count = 0;
		for (char c : input.toCharArray()) {
			if (Character.isUpperCase(c)) {
				count++;
			}
		}
		System.out.println(count);
	}

	// --- With Streams ---
	static void withStream(String input) {
		long count = input.chars().filter(Character::isUpperCase).count();
		System.out.println(count);
	}
}