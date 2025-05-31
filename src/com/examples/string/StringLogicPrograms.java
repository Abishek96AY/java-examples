package com.examples.string;

public class StringLogicPrograms
{
	public static void countString()
	{
		String str = "Hello Abi !!!";
		String[] temp = str.split(" ");
		String append = "";
		for (int i = 0; i < temp.length; i++)
		{
			append = append+temp[i];
		}
		System.out.println("Count :: "+append.length());
	}

	public static String reverseString()
	{
		String str = "Hello Abi !!!";
		StringBuilder sb = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--)
		{
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}

	public static void main(String[] args)
	{
		countString();
	}
}