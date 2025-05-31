package com.examples.logical;

public class ReverseNumber
{
	public static void method1()
	{
		int originalNumber = 10, reversedNumber = 0;
		
		while (originalNumber != 0)
		{
			int lastDigit = originalNumber % 10; // Extracting the last digit
			reversedNumber = reversedNumber * 10 + lastDigit; // Appending the digit to the reversed number
			originalNumber = originalNumber / 10; // Removing the last digit from the original number
		}
		
		System.out.println("Reversed Number: " + reversedNumber);
	}
	
	public static void method2()
	{
		int originalNumber = 10; String reversedNumber = "";
		
		while (originalNumber != 0)
		{
			int lastDigit = originalNumber % 10; // Extracting the last digit
			reversedNumber = reversedNumber + lastDigit; // Appending the digit to the reversed number
			originalNumber = originalNumber / 10; // Removing the last digit from the original number
		}
		
		System.out.println("Reversed Number: " + reversedNumber);
	}
	
	public static void main(String[] args)
	{
		method2();
	}
}