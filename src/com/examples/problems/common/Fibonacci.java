package com.examples.problems.common;

public class Fibonacci
{
	public static void main(String[] args)
	{
		int num1 = 0, num2 = 1, sum = 0, n = 10;
		System.out.print(num1 +", "+ num2);
		for (int i = 2; i < n; i++)
		{
			sum = num1 + num2;

			System.out.print(", "+sum);

			num1 = num2;

			num2 = sum;
		}
	}
}