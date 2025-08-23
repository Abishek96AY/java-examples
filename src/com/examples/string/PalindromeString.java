package com.examples.string;

public class PalindromeString {
	public static void main(String[] args) {

	}

	public static boolean method2() {
		String str = "radar";
		String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

		int left = 0;
		int right = cleaned.length() - 1;

		// Step 2: Two Pointers Approach
		while (left < right) {
			if (cleaned.charAt(left) != cleaned.charAt(right)) {
				return false; // It's not a palindrome if there's a mismatch
			}
			left++;
			right--;
		}
		return true;
	}

	public static boolean method3() {
		String str = "radar";
		String cleanString = str.toLowerCase();

		// Step 2: Reverse the string
		String reversed = new StringBuilder(cleanString).reverse().toString();

		// Step 3: Compare the original string with the reversed string
		return cleanString.equals(reversed);
	}

	public static void method1() {
		String obj = "radar";
		String temp = "";
		char[] ob = obj.toCharArray();
		for (int i = ob.length - 1; i >= 0; i--) {
			temp = temp + ob[i];
		}
		if (obj.equals(temp)) {
			System.out.println(obj + " It's a Palindrome !!!");
		} else {
			System.out.println(obj + " It's a not Palindrome !!!");
		}
	}
}