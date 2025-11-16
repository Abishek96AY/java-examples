package com.examples.problems.string;

public class StringContainsOnlyAlphabets {
    public static void main(String[] args) {
        String input = "Hello";

        withOutStream(input);
        withStream(input);
    }

    // --- Without Streams ---
    static void withOutStream(String input) {
        boolean output = true;

        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c)) {
                output = false;
                break;
            }
        }

        System.out.println(output);
    }

    // --- With Streams ---
    static void withStream(String input) {
        boolean output = input.chars()
                .mapToObj(e -> (char) e)
                .allMatch(Character::isLetter);
        System.out.println(output);
    }
}