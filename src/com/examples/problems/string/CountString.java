package com.examples.problems.string;

public class CountString {
	public static void main(String[] args) {
		String str = "Hello Abi !!!";
		String[] temp = str.split(" ");
		String append = "";
		for (int i = 0; i < temp.length; i++) {
			append = append + temp[i];
		}
		System.out.println("Count :: " + append.length());
	}

	public static void countStringWithStream() {
		String str = "Hello Abi !!!";

		System.out.println(str.chars().mapToObj(c -> (char) c).count());
	}
}