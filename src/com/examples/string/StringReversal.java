package com.examples.string;

public class StringReversal {
	public static String method1(String str) {
		if (str.isEmpty())
			return str;
		return method1(str.substring(1)) + str.charAt(0);
	}

	public static void method2(String str) {
		char[] chars = str.toCharArray();
		for (int i = chars.length - 1; i >= 0; i--) {
			System.out.print(chars[i]);
		}
	}

	public static void method3(String str) {
		StringBuilder buffer = new StringBuilder(str);
		System.out.println(buffer.reverse());
	}

	public static void main(String[] args) {
		method1("JAVA");
	}
}