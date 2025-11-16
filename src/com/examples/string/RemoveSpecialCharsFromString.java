package com.examples.string;

import java.util.Arrays;

public class RemoveSpecialCharsFromString {
	public static void main(String[] args) {
		String input1 = "####Java 123 @ fun!";
		String result = input1.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(result);
		
		String input = "Java   is  fun";
		System.out.println(Arrays.toString(input.split("\\s+")));
	}
}