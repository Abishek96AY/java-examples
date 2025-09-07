package com.examples.conversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayArrayListConversion {
	public static void main(String[] args) {
		// ---------------- String[] <-> ArrayList<String> ----------------
		String[] strArray = { "Apple", "Banana", "Cherry" };

		// Array -> ArrayList
		List<String> strList = new ArrayList<>(Arrays.asList(strArray));
		System.out.println("String Array to ArrayList: " + strList);

		// ArrayList -> Array
		String[] backToStrArray = strList.toArray(new String[0]);
		System.out.println("ArrayList to String Array: " + Arrays.toString(backToStrArray));

		// ---------------- Integer[] <-> ArrayList<Integer> ----------------
		Integer[] intArray = { 1, 2, 3, 4, 5 };

		// Array -> ArrayList
		List<Integer> intList = new ArrayList<>(Arrays.asList(intArray));
		System.out.println("Integer Array to ArrayList: " + intList);

		// ArrayList -> Array
		Integer[] backToIntArray = intList.toArray(new Integer[0]);
		System.out.println("ArrayList to Integer Array: " + Arrays.toString(backToIntArray));

		// ---------------- int[] <-> ArrayList<Integer> (primitive case) ----------------
		int[] primitiveIntArray = { 10, 20, 30 };

		// int[] -> ArrayList<Integer>
		List<Integer> primitiveIntList = new ArrayList<>();
		for (int num : primitiveIntArray) {
			primitiveIntList.add(num); // autoboxing int -> Integer
		}
		System.out.println("int[] to ArrayList<Integer>: " + primitiveIntList);

		// ArrayList<Integer> -> int[]
		int[] backToPrimitiveIntArray = primitiveIntList.stream().mapToInt(Integer::intValue).toArray();
		System.out.println("ArrayList<Integer> to int[]: " + Arrays.toString(backToPrimitiveIntArray));
	}
}