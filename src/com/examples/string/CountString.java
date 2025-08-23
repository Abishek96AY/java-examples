package com.examples.string;

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
}
