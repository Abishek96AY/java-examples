package com.examples.interfaces;

public class FunctionalInterfaceEx2Main implements FunctionalInterfaceEx2 {
	
    @Override
    public void regularMethod() {
        System.out.println("This is a regular method implementation");
    }
    
    public static void main(String[] args) {
        FunctionalInterfaceEx2Main obj = new FunctionalInterfaceEx2Main();
        obj.regularMethod();    // This is a regular method implementation
        obj.defaultMethod();    // This is a default method
        FunctionalInterfaceEx2.staticMethod(); // This is a static method
    }
}
