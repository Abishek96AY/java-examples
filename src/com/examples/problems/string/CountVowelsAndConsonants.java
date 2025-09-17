package com.examples.problems.string;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountVowelsAndConsonants {
	public static void main(String[] args) {
		String input = "Programming";
		withoutStream2(input);
	}

	static void withoutStream1(String input) {
		int vowelsCount = 0, consonantsCount = 0;
		String vowels = "aeiou";
		char[] charArr = input.toLowerCase().toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			if (vowels.indexOf(charArr[i]) != -1) {
				vowelsCount++;
			} else {
				consonantsCount++;
			}
		}
		System.out.println("vowelsCount :: " + vowelsCount + ", consonantsCount :: " + consonantsCount);
	}

	static void withoutStream2(String input) {
		String vowels = "aeiou";
		Map<String, Integer> map = new HashMap<>();
		char[] charArr = input.toLowerCase().toCharArray();
		for (Character c : charArr) {
			if (vowels.indexOf(c) != -1) {
				map.put("VowelsCount", map.getOrDefault("VowelsCount", 0) + 1);
			} else {
				map.put("ConsonantsCount", map.getOrDefault("ConsonantsCount", 0) + 1);
			}
		}

		System.out.println(map.toString());
	}

	static void withStream(String input) {
		String vowels = "aeiou";
		Map<String, Long> result = input.toLowerCase().chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> vowels.indexOf(c) != -1 ? "VowelsCount" : "ConsonantsCount", Collectors.counting()));
		System.out.println(result);
	}
}