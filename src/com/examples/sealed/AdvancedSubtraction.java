package com.examples.sealed;

public final class AdvancedSubtraction extends Subtraction {
	@Override
	public int calculate(int a, int b) {
		return Math.abs(a - b);
	}
}