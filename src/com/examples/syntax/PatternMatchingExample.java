package com.examples.syntax;

public class PatternMatchingExample {

	void simpleExample() {
		Object obj = "Hello Java 17";

		if (obj instanceof String s) {
			System.out.println(s.toUpperCase()); // no explicit cast needed
		}
	}

	public static String formatOld(Object obj) {
		if (obj == null) {
			return "Null value";
		} else if (obj instanceof String) {
			String s = (String) obj; // manual cast
			return "String: " + s.toUpperCase();
		} else if (obj instanceof Integer) {
			Integer i = (Integer) obj; // manual cast
			return "Integer: " + (i * 2);
		} else {
			return "Unknown type";
		}
	}

	public static String format(Object obj) {
		return switch (obj) {
		case String s -> "String: " + s.toUpperCase();
		case Integer i -> "Integer: " + (i * 2);
		case null -> "Null value";
		default -> "Unknown type";
		};
	}

	public static void main(String[] args) {
		System.out.println(formatOld("hello")); // String: HELLO
		System.out.println(formatOld(10)); // Integer: 20
		System.out.println(formatOld(null)); // Null value
		System.out.println(formatOld(3.14)); // Unknown type

		System.out.println("-----------------");

		System.out.println(format("hello")); // String: HELLO
		System.out.println(format(10)); // Integer: 20
		System.out.println(format(null)); // Null value
		System.out.println(format(3.14)); // Unknown type
	}
}