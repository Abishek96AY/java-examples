package com.examples.problems.string;

public class CountVowels {
    public static void main(String[] args) {
        String input = "Programming";

        withOutStream(input);  // loop-based
        withStream(input);     // stream-based
    }

    // --- Without Streams ---
    static void withOutStream(String input) {
        String vowels = "aeiou";
        int count = 0;

        for (char c : input.toLowerCase().toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }

        System.out.println(count);
    }

    // --- With Streams ---
    static void withStream(String input) {
        String vowels = "aeiou";

        long count = input.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> vowels.indexOf(ch) != -1)
                .count();

        System.out.println(count);
    }
}