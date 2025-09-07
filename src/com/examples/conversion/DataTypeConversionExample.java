package com.examples.conversion;

public class DataTypeConversionExample {

	public static void main(String[] args) {
		// ---------------- Primitive to Primitive ----------------
		int intVal = 100;
		double doubleVal = intVal; // int -> double (widening)
		byte byteVal = (byte) intVal; // int -> byte (narrowing)

		System.out.println("int to double: " + doubleVal);
		System.out.println("int to byte: " + byteVal);

		// ---------------- Primitive to Wrapper (Autoboxing) ----------------
		Integer intObj = intVal; // int -> Integer
		Double doubleObj = doubleVal; // double -> Double

		System.out.println("int to Integer (autoboxing): " + intObj);
		System.out.println("double to Double (autoboxing): " + doubleObj);

		// ---------------- Wrapper to Primitive (Unboxing) ----------------
		int intFromObj = intObj; // Integer -> int
		double doubleFromObj = doubleObj; // Double -> double

		System.out.println("Integer to int (unboxing): " + intFromObj);
		System.out.println("Double to double (unboxing): " + doubleFromObj);

		// ---------------- Primitive to String ----------------
		String str1 = Integer.toString(intVal); // int -> String
		String str2 = String.valueOf(doubleVal); // double -> String

		System.out.println("int to String: " + str1);
		System.out.println("double to String: " + str2);

		// ---------------- String to Primitive ----------------
		int strToInt = Integer.parseInt("123"); // String -> int
		double strToDouble = Double.parseDouble("45.67"); // String -> double

		System.out.println("String to int: " + strToInt);
		System.out.println("String to double: " + strToDouble);

		// ---------------- Wrapper to String ----------------
		String wrapperToString = intObj.toString(); // Integer -> String
		System.out.println("Integer to String: " + wrapperToString);

		// ---------------- String to Wrapper ----------------
		Integer stringToWrapper = Integer.valueOf("456");
		System.out.println("String to Integer: " + stringToWrapper);

		// ---------------- long conversions ----------------
		long longVal = intVal; // int -> long
		Long longObj = longVal; // long -> Long (autoboxing)
		int backToInt = longObj.intValue(); // Long -> int (narrowing)

		System.out.println("int to long: " + longVal);
		System.out.println("long to Long: " + longObj);
		System.out.println("Long to int: " + backToInt);
	}
}