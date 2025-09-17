package com.examples.problems.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseCharactersOfEachWord {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		String input = "I love Java";
		for (String string : input.split("\\s+")) {
			sb.append(withoutStream1(string)).append(" ");
		}
		System.out.println(sb.toString().trim());
	}

	static String withoutStream1(String input) {
		StringBuilder sb = new StringBuilder();
		char[] charArr = input.toCharArray();
		for (int i = charArr.length - 1; i >= 0; i--) {
			sb.append(charArr[i]);
		}
		return sb.toString();
	}

	static void withStream1(String input) {
		String result = Arrays.stream(input.split("\\s+")).map(word -> new StringBuilder(word).reverse().toString())
				.collect(Collectors.joining(" "));

		System.out.println(result);
	}

	static void withStream2(String input) {
		String result = Arrays.stream(input.split("\\s+"))
				.map(word -> word.chars().mapToObj(c -> String.valueOf((char) c))
				.reduce("", (rev, ch) -> ch + rev))
				.collect(Collectors.joining(" "));

		System.out.println(result);
	}
}