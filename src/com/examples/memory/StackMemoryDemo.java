package com.examples.memory;

public class StackMemoryDemo {
    public static void main(String[] args) {
        int a = 100;           // stored in stack
        String name = "Abi";   // reference in stack, "Abi" object in heap

        myMethod();

        System.out.println("End of main");
    }

    static void myMethod() {
        int b = 200;           // stored in stack (inside myMethod’s frame)
        System.out.println("b = " + b);
    }
}