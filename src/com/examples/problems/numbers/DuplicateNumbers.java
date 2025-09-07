package com.examples.problems.numbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DuplicateNumbers {

	static int[] arr = { 1, 2, 3, 2, 4, 5, 1 };

	public static void main(String[] args) {
		method3();
	}

	public static void method1() {

		Map<Integer, Integer> map = new HashMap<>();

		for (Integer i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() > 1) {
				System.out.println("Duplicate Number :: " + e.getKey());
			}
		}
	}

	public static void method2() {
		Set<Integer> set = new LinkedHashSet<>();

		for (Integer a : arr) {
			set.add(a);
		}

		System.out.println(set);
	}

	public static void method3() {
		List<Integer> list = Arrays.stream(arr).boxed().distinct().toList();

		System.out.println(list);
	}
}