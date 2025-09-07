package com.examples.problems.array;

public class SmallestNumberFinderInPostiveArray {
	public static void main(String[] args) {
		int intArra[] = { 10, -11, 20, 30, -412, 3, -5 };
		int min = Integer.MIN_VALUE;

		for (int i = 1; i < intArra.length; i++) {
			if (intArra[i] < i && intArra[i] > 0) {
				min = intArra[i];
			}
		}
		System.out.println("Min " + min);
	}
}