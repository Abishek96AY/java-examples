package com.examples.problems.string;

import java.util.HashMap;
import java.util.Map;

public class CountVowelsConsonants {
	public static void main(String[] args) {
		Map<String, Integer> map = countVowelsAndConsonants("Abishek");

		System.out.println("Number of vowels: " + map.get("Vowels"));
		System.out.println("Number of consonants: " + map.get("Consonants"));
	}

	public static Map<String, Integer> countVowelsAndConsonants(String input) {
		Map<String, Integer> map = new HashMap<>();
		for (char c : input.toLowerCase().toCharArray()) {
			if (c >= 'a' && c <= 'z') { // Ensure character is a letter
				if ("aeiou".indexOf(c) != -1) {
					map.put("Vowels", map.getOrDefault("Vowels", 0) + 1);
				} else {
					map.put("Consonants", map.getOrDefault("Consonants", 0) + 1);
				}
			}
		}
		return map;
	}
}