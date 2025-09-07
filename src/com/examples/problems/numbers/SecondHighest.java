package com.examples.problems.numbers;

import java.util.Arrays;
import java.util.Comparator;

public class SecondHighest {
	public static void main(String[] args) {

	}

	static void method1() {
		int[] arr = { 10, 5, 20, 8, 20, 15 };

		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;

		for (int n : arr) {
			if (n > first) {
				second = first;
				first = n;
			} else if (n > second && n < first) {
				second = n;
			}
		}

		System.out.println("Second highest: " + second);
	}

	static void method2() {
		int[] arr = { 10, 5, 20, 8, 20, 15 };

		int second = Arrays.stream(arr)
				.distinct() // remove duplicates
				.boxed() // convert int -> Integer
				.sorted(Comparator.reverseOrder()) // sort desc
				.skip(1) // skip highest
				.findFirst() // take second
				.orElse(Integer.MIN_VALUE);

		System.out.println("Second highest: " + second);
	}
}