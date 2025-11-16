package com.examples.problems.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveWhiteSpaces {
	public static void main(String[] args) {
		String input = "a b c d";
		withoutStream(input);
		withStream(input);
	}

	static void withoutStream(String input) {
		String[] strArr = input.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String string : strArr) {
			sb.append(string);
		}
		System.out.println(sb.toString());
	}

	static void withStream(String input) {
		String output = Arrays.stream(input.split(" ")).collect(Collectors.joining());
		System.err.println(output);
	}
}