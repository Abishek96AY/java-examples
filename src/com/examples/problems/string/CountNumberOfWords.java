package com.examples.problems.string;

import java.util.Arrays;

public class CountNumberOfWords {
	public static void main(String[] args) {
		String input = "Java is fun";
		withoutStream(input);
		withStream(input);
	}

	static void withoutStream(String input) {
		int count = input.split("\\s+").length;
		System.out.println(count);
	}

	static void withStream(String input) {
		long count = Arrays.stream(input.split("\\s+")).count();
		System.out.println(count);
	}
}