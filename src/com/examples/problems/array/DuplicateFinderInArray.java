package com.examples.problems.array;

import java.util.HashSet;
import java.util.Set;

public class DuplicateFinderInArray {
	public static void main(String[] args) {
		method2();
	}

	public void method1() {
		int arr[] = { 10, 11, 12, 10, 10 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[1] == arr[j]) {
					System.out.println("Duplicate Found :: " + arr[i]);
				}
			}
		}
	}

	public static void method2() {
		int arr[] = { 10, 11, 12, 10, 10 };

		Set<Integer> set = new HashSet<>();

		for (int value : arr) {
			if (!set.add(value)) {
				System.out.print(value + " ");
			}
		}
	}
}