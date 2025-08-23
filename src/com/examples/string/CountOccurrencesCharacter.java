package com.examples.string;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesCharacter {
	public static void main(String[] args) {
		Map<Character, Integer> map = new HashMap<>();

		String str = "programming";
		char[] obj = str.toCharArray();

		for (char ch : obj) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		System.out.println(map);
	}
}