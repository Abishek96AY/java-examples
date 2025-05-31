package com.examples.string;

public class StringReversal
{
	public static String method1(String str)
	{
		if (str.isEmpty())
			return str;
		return method1(str.substring(1)) + str.charAt(0);
	}

	public static void method2()
	{
		String original = "JAVA";
		char[] chars = original.toCharArray();
		for (int i = chars.length - 1; i >= 0; i--) {
			System.out.print(chars[i]);
		}
	}

	public static void method3()
	{
		String original = "JAVA";
		StringBuilder buffer = new StringBuilder(original);
		System.out.println(buffer.reverse());
	}
	
	public static void main(String[] args) {
		method1("JAVA");
	}
}