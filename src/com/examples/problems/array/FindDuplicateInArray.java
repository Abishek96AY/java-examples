package com.examples.problems.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicateInArray {
	static int arr[] = { 10, 11, 12, 10, 10 };

	public static void main(String[] args) {
		method1();
		method2();
		method3();
	}

	public static void method1() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[1] == arr[j]) {
					System.out.println("Without Stream 1. Duplicate Found :: " + arr[i]);
				}
			}
		}
	}

	public static void method2() {

		Set<Integer> set = new HashSet<>();

		for (int i : arr) {
			if (!set.add(i)) {
				System.out.println("Without Stream 2. Duplicate Found :: " + i + " ");
			}
		}
	}
	
	public static void method3() {

		Set<Integer> duplicates =
			    Arrays.stream(arr)
			          .boxed()
			          .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
			          .entrySet().stream()
			          .filter(e -> e.getValue() > 1)
			          .map(Map.Entry::getKey)
			          .collect(Collectors.toSet());
		
		duplicates.forEach((a) ->{
			System.out.println("With Stream. Duplicate Found :: " + a + " ");
		});
	}
}