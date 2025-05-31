package com.examples.logical;

public class Factorial
{
	public static void method1()
	{
		int n = 5, ans = 1;
		for (int i = 1; i <= n; i++)
		{
			ans = i * ans;
		}
		System.err.println("Ans :: "+ans);
	}
	
	public static int usingRecursionMethod(int n)
	{
		System.out.println("Call !!!");
		if (n == 0 || n==1)
		{
			System.out.println("1");
			return 1;
		}
		else
		{
			int ans = n * usingRecursionMethod(n - 1);
			System.out.println("Ans :: "+ans);
			return ans;
		}
	}

	public static void main(String[] args)
	{
		System.out.println("Final Ans :: "+usingRecursionMethod(5));
	}
}