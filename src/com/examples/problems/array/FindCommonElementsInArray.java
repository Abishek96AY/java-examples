package com.examples.problems.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FindCommonElementsInArray {
	public static void main(String[] args) {

		int[] arr1 = { 10, 5, 20, 8, 20, 15 };
		int[] arr2 = { 20, 15, 30, 5 };

		// Without Stream
		Set<Integer> set = new HashSet<>();
		for (int i : arr1) {
			set.add(i);
		}
		System.out.println("Without Stream");
		for (int i : arr2) {
			if (set.contains(i)) {
				System.out.println(i);
			}
		}

		// With Stream
		Set<Integer> common = Arrays.stream(arr1)
				.boxed()
				.filter(i -> Arrays.stream(arr2).anyMatch(j -> j == i))
				.collect(Collectors.toSet());
		System.out.println("With Stream");
		System.out.println(common.toString());
	}
}