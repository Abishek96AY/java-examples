package com.examples.problems.common;

import java.util.Scanner;

public class CalculateSalary
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Basic Salary of the Employee:");
		double basic = scanner.nextDouble();

		double hra = 0.10 * basic;  // 10% of basic
		double da = 0.08 * basic;   // 8% of basic
		double grossSalary = basic + hra + da;

		double tax = 0.05 * grossSalary; // 5% tax on gross salary
		double netSalary = grossSalary - tax;

		System.out.println("Employee Salary Breakdown:");
		System.out.println("Basic: " + basic);
		System.out.println("HRA: " + hra);
		System.out.println("DA: " + da);
		System.out.println("Gross Salary: " + grossSalary);
		System.out.println("Tax Deduction: " + tax);
		System.out.println("Net Salary: " + netSalary);
	}
}