package com.examples.problems.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MaximumOccurringCharacter {
	public static void main(String[] args) {
		String input = "successes";
		System.out.println(maxOccurringChar(input));
		System.out.println(maxOccurringCharStream(input));
	}

	static char maxOccurringChar(String input) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : input.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		char maxChar = 0;
		int maxCount = 0;
		for (Map.Entry<Character, Integer> e : map.entrySet()) {
			if (e.getValue() > maxCount) {
				maxChar = e.getKey();
				maxCount = e.getValue();
			}
		}
		return maxChar;
	}

	static char maxOccurringCharStream(String str) {
		return str.chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()))
				.entrySet()
				.stream()
				.max(Entry.comparingByValue())
				.get()
				.getKey();
	}
}