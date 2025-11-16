package com.examples.problems.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountOccurrenceEachCharacter {
	public static void main(String[] args) {
		String input = "Java Guides Net Java is Powerful";
		withoutStream(input);
		withStream(input);
	}

	static void withoutStream(String input) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		char[] charArr = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();

		for (Character c : charArr) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println("Duplicate :: " + entry.getKey() + ", Count :: " + entry.getValue());
			}
		}

		System.out.println(map);
	}

	static void withStream(String str) {
		Map<Character, Long> map = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()));

		map.forEach((a, b) -> {
			if (b > 1) {
				System.out.println("Duplicate :: " + a + ", Count :: " + b);
			}
		});
	}
}