package com.examples.sealed;

public sealed class Subtraction extends Calculator permits AdvancedSubtraction {
	@Override
	public int calculate(int a, int b) {
		return a - b;
	}
}