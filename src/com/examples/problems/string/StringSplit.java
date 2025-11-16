package com.examples.problems.string;

import java.util.Arrays;
import java.util.List;

public class StringSplit {
    public static void main(String[] args) {
        String input = "Java,Python,C++";

        withOutStream(input);  // loop-based
        withStream(input);     // stream-based
    }

    // --- Without Streams ---
    static void withOutStream(String input) {
        List<String> list = Arrays.asList(input.split(","));  // convert array to list
        System.out.println(list);
    }

    // --- With Streams ---
    static void withStream(String input) {
        List<String> list = Arrays.stream(input.split(",")).toList();
        System.out.println(list);
    }
}