package com.examples.problems.string;

import java.util.stream.Stream;

public class SwapTwoStringsWithoutTemp {
	public static void main(String[] args) {
		String s1 = "Java";
		String s2 = "Python";

		withOutStream(s1, s2);
		withStream(s1, s2);
	}

	// --- Without Streams ---
	static void withOutStream(String s1, String s2) {
		System.out.println("Before swap: " + s1 + ", " + s2);

		// Swap using concatenation
		s1 = s1 + s2;
		s2 = s1.substring(0, s1.length() - s2.length());
		s1 = s1.substring(s2.length());

		System.out.println("After swap: " + s1 + ", " + s2);
	}

	// --- With Streams (just for demonstration, still prints swap) ---
	static void withStream(String s1, String s2) {
		String[] finalSwap = Stream.of(s1, s2)
                .reduce("", (a, b) -> b + "," + a)  // a = "", b = "Java" -> result = "Python,Java"
                .split(",");

        System.out.println("After swap: " + finalSwap[0] + ", " + finalSwap[1]);
    }
}
