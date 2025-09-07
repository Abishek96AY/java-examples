package com.examples.sealed;

public sealed abstract class Calculator permits Addition, Subtraction, Multiplication {
	public abstract int calculate(int a, int b);
}