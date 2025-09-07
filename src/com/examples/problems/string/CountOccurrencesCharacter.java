package com.examples.problems.string;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountOccurrencesCharacter {

	public static void main(String[] args) {
		method2();
	}

	public static void method1() {
		String str = "programming";
		char[] obj = str.toCharArray();

		Map<Character, Integer> map = new HashMap<>();

		for (char ch : obj) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		System.out.println(map);
	}

	public static void method2() {
		String str = "programming";

		Map<Character, Long> charCountMap = str.chars() // IntStream of char codes
				.mapToObj(c -> (char) c) // convert to Character
				.collect(Collectors.groupingBy(c -> c, Collectors.counting() // count frequency
				));

		System.out.println(charCountMap);

	}
}