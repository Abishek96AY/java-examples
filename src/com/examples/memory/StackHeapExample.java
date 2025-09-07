package com.examples.memory;

public class StackHeapExample {
	public static void main(String[] args) {
        int x = 10;                 // primitive → stored in stack
        String name = new String("Abi"); // reference in stack, object in heap

        display(x, name);
    }

    static void display(int number, String text) {
        int y = 20;                 // primitive → stored in stack
        System.out.println("number = " + number);
        System.out.println("text = " + text);
        System.out.println("y = " + y);
    }
}