package com.examples.problems.array;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
	public static void main(String[] args) {
		int[] arr = { 10, 5, 20, 8, 20, 15 };
		
		//Without Stream
		Set<Integer> set = new LinkedHashSet<>();
		for (int i : arr) {
			set.add(i);
		}
		
		System.out.println("Without Stream");
		for (Integer integer : set) {
			System.err.println(integer);
		}
		
		//With Stream
		int[] unique = Arrays.stream(arr).distinct().toArray();
		System.out.println("With Stream");
		Arrays.stream(unique).forEach((a) ->{
			System.err.println(a);
		});
	}
}