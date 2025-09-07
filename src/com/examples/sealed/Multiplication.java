package com.examples.sealed;

public non-sealed class Multiplication extends Calculator {
	@Override
	public int calculate(int a, int b) {
		return a * b;
	}
}