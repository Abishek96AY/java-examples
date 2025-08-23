package com.examples.test;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		String str = "programmming";

		Map<Character, Integer> map = new HashMap<>();

		for (Character c : str.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		System.out.println(""+map.toString());
	}
}