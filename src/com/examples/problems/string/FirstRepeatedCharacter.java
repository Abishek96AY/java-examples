package com.examples.problems.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstRepeatedCharacter {
    public static void main(String[] args) {
        String input = "abca";
        withoutStream(input);
        withStream(input);
    }
    
    static void withoutStream(String input) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            /*if (map.get(c) == 2) { // first repeated
                System.out.println("First repeated char: " + c);
                return;
            }*/
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("First repeated char: " + entry.getKey());
                return;
            }
        }

        System.out.println("No repeated characters");
    }

    static void withStream(String input) {
    	Character output = input.chars().mapToObj(c -> (char) c)
    			.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
    			 .entrySet()
                 .stream()
                 .filter(e -> e.getValue() > 1)
                 .map(Map.Entry::getKey)
                 .findFirst()
                 .orElse(null);
        System.out.println("First repeated char (Stream): " + output);
    }
}