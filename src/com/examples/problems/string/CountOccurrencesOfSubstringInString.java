package com.examples.problems.string;

import java.util.Arrays;

public class CountOccurrencesOfSubstringInString {
	public static void main(String[] args) {
		String input = "Java is a widely used programming language. Java is a versatile and has a large community.";
		String substring = "Java";

		withOutStream(input, substring);
		withStream(input, substring);
	}

	static void withOutStream(String input, String substring) {
		String[] strArr = input.replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+");
		int count = 0;
		for (String word : strArr) {
			if (word.equalsIgnoreCase(substring)) {
				count++;
			}
		}
		System.out.println("withOutStream() " + substring + " occurred " + count + " times...");
	}

	static void withStream(String input, String substring) {
		String[] strArr = input.replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+");
		long count = Arrays.stream(strArr).filter(word -> word.equalsIgnoreCase(substring)).count();

		System.out.println("withStream() " + substring + " occurred " + count + " times...");
	}
}