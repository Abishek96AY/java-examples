package com.examples.problems.string;

public class CountOccurrencesOfSubstringInString {
	public static void main(String[] args) {
		String inputString = "Java is a widely used programming language. Java is versatile and has a large community.";
		String substring = "Java";

		String[] strArr = inputString.split(" ");
		int count = 0;
		for (String string : strArr) {
			if (string.equals(substring)) {
				count++;
			}
		}
		System.out.println(substring + " occurred " + count + " times...");
	}
}