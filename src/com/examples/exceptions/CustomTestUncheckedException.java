package com.examples.exceptions;

public class CustomTestUncheckedException{
	
	public void processTransaction(double amount) {
        if (amount <= 0) {
            throw new CustomUncheckedException("Transaction amount must be greater than zero.");
        }
        System.out.println("Transaction processed successfully.");
    }
	
	public static void main(String[] args) {
		new CustomTestUncheckedException().processTransaction(-1);
	}
}

class CustomUncheckedException extends RuntimeException {
    public CustomUncheckedException(String message) {
        super(message);
    }
}