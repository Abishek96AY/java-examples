package com.examples.problems.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {
	public static void main(String[] args) {
		String input = "swiss";
		withStream(input);
	}

	static void withoutStream(String input) {
		char output;
		Map<Character, Long> map = new LinkedHashMap<>();
		char[] charArr = input.toCharArray();
		for (char c : charArr) {
			map.put(c, map.getOrDefault(c, 0l) + 1);
		}

		System.err.println(map);

		for (Map.Entry<Character, Long> e : map.entrySet()) {
			if (e.getValue() == 1) {
				output = e.getKey();
				System.out.println("Word :: " + output);
				break;
			}
		}
	}

	static void withStream(String input) {
		Character output = input.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);

		System.out.println(output);
	}
}