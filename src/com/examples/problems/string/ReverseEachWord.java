package com.examples.problems.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseEachWord {
	public static void main(String[] args) {
		reverseEachWordStream();
	}

	private static String reverseEachWordWithoutStream() {
		String originalStr = "Java is fun";
		String[] words = originalStr.split(" ");
		String reversedStr = "";

		/*for (int i = (words.length - 1); i >= 0; i--) {
			reversedStr = reversedStr + reverseWithStringConcat(words[i]) + " ";
		}*/

		for (String word : words) {
			reversedStr = reversedStr + reverseWithStringConcat(word) + " ";
		}

		System.out.println(originalStr);
		System.out.println(reversedStr);

		return reversedStr;
	}

	private static final String reverseWithStringConcat(String string) {
		String reverseWord = "";
		for (int i = (string.length() - 1); i >= 0; i--) {
			reverseWord = reverseWord + string.charAt(i);
		}
		return reverseWord;
	}

	private static void reverseEachWordStream() {
		String originalStr = "Java is fun";
		String reversedStr = Arrays.stream(originalStr.split(" ")) // split into words
				.map(word -> new StringBuilder(word).reverse().toString()) // reverse each
				.collect(Collectors.joining(" ")); // join back with space

		System.out.println(originalStr);
		System.out.println(reversedStr);
	}
}