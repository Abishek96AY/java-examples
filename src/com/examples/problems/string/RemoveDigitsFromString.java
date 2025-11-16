package com.examples.problems.string;

import java.util.stream.Collectors;

public class RemoveDigitsFromString {
	public static void main(String[] args) {
		String input = "abc123";

		withOutStream(input); // loop-based
		withStream(input); // stream-based
	}

	// --- Without Streams ---
	static void withOutStream(String input) {
		StringBuilder sb = new StringBuilder();
		for (char c : input.toCharArray()) {
			if (Character.isLetter(c)) { // keep letters only
				sb.append(c);
			}
		}
		System.out.println(sb.toString());
	}

	// --- With Streams ---
	static void withStream(String input) {
		String output = input.chars()
				.mapToObj(c -> (char) c)
				.filter(Character::isLetter)
				.map(String::valueOf)
				.collect(Collectors.joining());
		
		/*output = input.chars()
				.mapToObj(c -> String.valueOf((char) c))
				.filter(e -> !e.matches("\\d+"))
				.collect(Collectors.joining());*/

		System.out.println(output);
	}
}