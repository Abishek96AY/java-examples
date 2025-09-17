package com.examples.problems.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AnagramCheck {
	public static void main(String[] args) {
		withoutStream();
	}

	static void withoutStream() {
		String s1 = "listen";
		String s2 = "silent";

		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();
		Arrays.sort(a1);
		Arrays.sort(a2);

		System.out.println(Arrays.equals(a1, a2));
	}

	static void withStream() {
		String s1 = "listen";
		String s2 = "silent";

		// Sort characters using streams
		String sorted1 = s1.chars().sorted().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());

		String sorted2 = s2.chars().sorted().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());

		System.out.println(sorted1.equals(sorted2));
	}
}