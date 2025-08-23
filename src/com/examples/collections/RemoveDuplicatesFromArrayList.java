package com.examples.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicatesFromArrayList {
	public static void method1() {
		final List<Integer> listWithDuplicates = new ArrayList<>();

		listWithDuplicates.add(10);
		listWithDuplicates.add(20);
		listWithDuplicates.add(30);
		listWithDuplicates.add(30);
		listWithDuplicates.add(50);
		listWithDuplicates.add(50);
		listWithDuplicates.add(10);

		System.out.println("Before removing duplicates :: " + listWithDuplicates.toString());

		final List<Integer> listWithoutDuplicates = new ArrayList<>(new HashSet<>(listWithDuplicates));

		System.out.println("After removing duplicates :: " + listWithoutDuplicates.toString());
	}

	public static void method2() {
		final List<Integer> listWithDuplicates = new ArrayList<>();

		listWithDuplicates.add(10);
		listWithDuplicates.add(20);
		listWithDuplicates.add(30);
		listWithDuplicates.add(30);
		listWithDuplicates.add(50);
		listWithDuplicates.add(50);
		listWithDuplicates.add(10);

		System.out.println("Before removing duplicates :: " + listWithDuplicates.toString());

		final List<Integer> listWithoutDuplicates = listWithDuplicates.stream().distinct().toList();

		System.out.println("After removing duplicates :: " + listWithoutDuplicates.toString());
	}

	public static void main(final String[] args) {
		method1();
		method2();
	}
}