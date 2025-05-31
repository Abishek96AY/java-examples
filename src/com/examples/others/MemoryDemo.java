package com.examples.others;

public class MemoryDemo {

	/*
	 * 1. x and y are local variables stored in stack memory.
       2. obj and anotherObj are references stored in stack memory, but the objects they reference are stored in heap memory.
	 */


	public static void main(String[] args) {
		int x = 5; // Stored in stack memory
		MemoryDemo obj = new MemoryDemo(); // obj reference stored in stack, object stored in heap
		obj.method();
	}

	public void method() {
		int y = 10; // Stored in stack memory
		MemoryDemo anotherObj = new MemoryDemo(); // anotherObj reference stored in stack, object stored in heap
	}
}