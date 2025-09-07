package com.examples.problems.numbers;

import java.util.*;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 8, 12};

        int second = Arrays.stream(arr)
                .distinct()
                .boxed()
                .sorted((a, b) -> b - a)
                .skip(1)
                .findFirst()
                .orElseThrow();

        System.out.println("Second largest: " + second);
    }
}