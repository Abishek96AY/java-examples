package com.examples.problems.array;

import java.util.Arrays;

public class SortArray {
	public static void main(String[] args) {
		int[] arr = { 10, 5, 20, 8, 20, 15 };
		Arrays.sort(arr);
		System.out.println("Sorted Array Without Stream !!! ");
		for (int i : arr) {
			System.out.println(i);
		}
		
		int[] sorted = Arrays.stream(arr).sorted().toArray();
		System.out.println("Sorted Array With Stream !!! ");
		for (int i : sorted) {
			System.out.println(i);
		}
	}
}