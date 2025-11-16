package com.examples.syntax;

abstract class AbsClass {
	String str = "";

	public AbsClass(String str) {
		this.str = str;
	}

	abstract void abc();

	void test() {
		System.err.println(str + "Test !!!");
	}
}

public class AbstarctClassEx extends AbsClass {
	public AbstarctClassEx(String test) {
		super(test);
	}

	public static void main(String[] args) {
		AbstarctClassEx obj = new AbstarctClassEx("Hello : ");
		obj.test();
		obj.abc();
	}

	@Override
	void abc() {
		System.out.println("Abc !!!");
	}
}