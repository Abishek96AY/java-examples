package com.examples.problems.string;

import java.util.*;
import java.util.stream.*;

public class FirstUniqueChar {
	public static void main(String[] args) {
		method2();
	}
	
	public static void method1()
	{
		String str = "swiss";
		Map<Character, Integer> map = new LinkedHashMap<>();

		for (char c : str.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println("First non-repeated: " + entry.getKey());
				break;
			}
		}
	}
	
	public static void method2()
	{
		String str = "swiss";

        Character firstUnique = str.chars()   // IntStream of char values
                .mapToObj(c -> (char) c)      // convert int -> Character
                .collect(Collectors.groupingBy(
                        e -> e,  // group by character
                        LinkedHashMap::new,   // preserve insertion order
                        Collectors.counting() // count frequency
                ))
                .entrySet().stream()          // Stream over Map entries
                .filter(e -> e.getValue() == 1) // keep only unique chars
                .map(Map.Entry::getKey)         // get the character
                .findFirst()                    // take the first one
                .orElse(null);                  // or null if none exists

        System.out.println("First non-repeated: " + firstUnique);
	}
}