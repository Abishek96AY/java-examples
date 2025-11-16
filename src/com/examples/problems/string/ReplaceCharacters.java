package com.examples.problems.string;

import java.util.stream.Collectors;

public class ReplaceCharacters {
	public static void main(String[] args) {
		String input = "hello";
		String s = "l", r = "aaa";

		withOutStream(input, s, r);
		withStream(input, s, r);
	}

	static void withOutStream(String input, String s, String r) {
		String output = input.replaceAll(s, r);
		System.out.println(output);
	}

	static void withStream(String input, String s, String r) {
		String output = input.chars()
				.mapToObj(c -> String.valueOf((char) c).replace(s, r))
				.collect(Collectors.joining());

		System.out.println(output);
	}
}