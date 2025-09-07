package com.examples.problems.common;

public class SumOfNaturalNumbers
{
	static int input = 100, sumWithFormula = 0, sumWithLoop = 0;

	public static void method1()
	{
		sumWithFormula = (input * (input + 1)) / 2;
		System.out.println("Sum :: "+sumWithFormula);
	}

	public static void method2()
	{
		for (int i = 1; i <= input; i++)
		{
			sumWithLoop = sumWithLoop+i;
		}
		System.out.println("Sum :: "+sumWithLoop);
	}

	public static void main(String[] args)
	{	
		method1();
	}
}