package com.examples.string;

public class StringContainsNumeric
{
	static boolean method1()
	{
		String a = "123";
		try {
			Integer.parseInt(a);
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	static boolean method2()
	{
		CharSequence cs = "+123";
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isDigit(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args)
	{
		System.out.println(method1() ? "String contains !!!" : "All Integers !!");
	}
}
