package com.examples.problems.string;

import java.util.stream.Collectors;

public class RemoveLastCharacter {
    public static void main(String[] args) {
        String input = "Hello";

        withOutStream(input);  // loop-based
        withStream(input);     // stream-based
    }

    // --- Without Streams ---
    static void withOutStream(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println(input); // nothing to remove
            return;
        }
        String output = input.substring(0, input.length() - 1);
        System.out.println(output);
    }

    // --- With Streams ---
    static void withStream(String input) {
        String output = input.chars()
                .mapToObj(c -> (char) c)
                .limit(input.length() - 1)  // skip the last character
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(output);
    }
}